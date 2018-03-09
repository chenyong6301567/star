package com.hotyum.stars.biz.manager.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.croky.util.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.hotyum.stars.biz.manager.AgentManager;
import com.hotyum.stars.biz.manager.NoticeManager;
import com.hotyum.stars.biz.manager.ReferralInformationManager;
import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.biz.manager.SysUserRoleManager;
import com.hotyum.stars.biz.manager.TokenAccessManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.CustomerRecommandVO;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.biz.model.UserListVO;
import com.hotyum.stars.dal.dao.UserDAO;
import com.hotyum.stars.dal.mapper.UserSqlProvider;
import com.hotyum.stars.dal.model.Agent;
import com.hotyum.stars.dal.model.SysUserRole;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.dal.model.UserExample;
import com.hotyum.stars.utils.Assert;
import com.hotyum.stars.utils.DateUtil;
import com.hotyum.stars.utils.DecimalUtil;
import com.hotyum.stars.utils.MD5Util;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.utils.enums.BooleanType;
import com.hotyum.stars.utils.enums.LoginType;
import com.hotyum.stars.utils.enums.NoticeType;
import com.hotyum.stars.utils.enums.PicType;
import com.hotyum.stars.utils.enums.RefereeType;
import com.hotyum.stars.utils.enums.RoleType;
import com.hotyum.stars.utils.enums.SexType;
import com.hotyum.stars.utils.enums.SmsType;
import com.hotyum.stars.utils.enums.Status;
import com.hotyum.stars.utils.enums.UserType;
import com.hotyum.stars.utils.exception.ApplicationException;

/**
 * @author cy
 * @Description 用户
 * @date 2017年12月31日下午7:44:06 
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private SmsManager smsManager;

	@Autowired
	private TokenAccessManager tokenAccessManager;

	@Autowired
	private SysUserRoleManager sysUserRoleManager;

	@Autowired
	private NoticeManager noticeManager;

	@Autowired
	private ReferralInformationManager referralInformationManager;

	@Autowired
	private AgentManager agentManager;

	private static final String DERECTMESSAGE = "您的直推客户{0}成功注册了系统，请您悉知。";

	private static final String INDERECTMESSAGE = "您的间推客户{0}成功注册了系统，请您悉知。";

	private static final String PHONEREX = "(\\d{3})\\d{4}(\\d{4})";

	private static final String HIDESTR = "$1****$2";

	private static final String ACCOUNTHIDESTR = "$1*********";

	private static final String ACCOUNTREX = "(\\d{3})\\d{8}";

	private static final String IDCARD = "(\\d{4})\\d{10}(\\w{4})";

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

	private ReentrantLock lock = new ReentrantLock();

	/**
	* @Title:login
	* @author:cy
	* @Description 登录
	* @date:2017年12月31日下午8:11:33
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public TokenInfoVO login(String phone, String password, String verifyCode, Integer loginType) {
		// 查询用户是否存在
		User user = getUserByPhone(phone);
		if (null == user) {
			throw new ApplicationException("您好，请先注册再登录");
		}
		// 区分登录方式
		if (loginType.equals(LoginType.VERIFYCODELOGIN.getValue())) {
			// 短信验证码登录,校验短信验证码
			Assert.notEmpty(verifyCode, "验证码不能为空");
			boolean codeResult = smsManager.checkVerifyCode(phone, verifyCode, SmsType.LOGIN.getValue());
			if (!codeResult) {
				throw new ApplicationException("您好，短信验证码错误");
			}
		} else if (loginType.equals(LoginType.PASSWORDLOGIN.getValue())) {
			// 密码登录
			Assert.notEmpty(password, "密码不能为空");
			String md5pwd = MD5Util.generatePassword(password);
			if (StringUtils.isEmpty(user.getPwd())) {
				throw new ApplicationException("您好，请先用验证码登录之后设置好密码再用密码登录");
			}
			if (!user.getPwd().equalsIgnoreCase(md5pwd)) {
				throw new ApplicationException("您好，请重新輸入正确的登录密码");
			}
		}
		// 生成uuId作为token返回
		String token = tokenAccessManager.insertLoginToken(user);
		List<SysUserRole> sysUserRolesList = sysUserRoleManager.getRoleByUserId(user.getId());

		UserBaseInfoVO userBaseInfoVO = null;
		try {
			userBaseInfoVO = ObjectUtils.convert(user, UserBaseInfoVO.class);
			setDerectId(userBaseInfoVO);
			setInderectId(userBaseInfoVO);
			referralInformationManager.getReferInfomation(userBaseInfoVO);
		} catch (Exception e) {
			LOGGER.error("getUserBaseInfo对象转换异常", e);
			throw new RuntimeException("getUserBaseInfo对象转换异常", e);
		}
		return new TokenInfoVO(token, sysUserRolesList, userBaseInfoVO);
	}

	/**
	* @Title setInderectId
	* @author cy
	* @Description 
	* @date 2018年1月28日下午7:33:22
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void setInderectId(UserBaseInfoVO userBaseInfoVO) {
		if (StringUtils.isNoneEmpty(userBaseInfoVO.getIndirectRecommendationAccount())) {
			User user = getByAccount(userBaseInfoVO.getIndirectRecommendationAccount());
			userBaseInfoVO.setInderectRecomandPersonId(user.getId());
		}
	}

	/**
	* @Title setDerectId
	* @author cy
	* @Description 
	* @date 2018年1月28日下午7:30:32
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	private void setDerectId(UserBaseInfoVO userBaseInfoVO) {
		if (StringUtils.isNoneEmpty(userBaseInfoVO.getDirectRecommendationAccount())) {
			User user = getByAccount(userBaseInfoVO.getDirectRecommendationAccount());
			userBaseInfoVO.setDerectRecomandPersonId(user.getId());
		}
	}

	/**
	* @Title getUserByPhone
	* @author cy
	* @Description 根据手机号码获取用户
	* @date 2017年12月31日下午8:12:06
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	public User getUserByPhone(String phone) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAccountEqualTo(phone);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getUserByPhone获取用户信息失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:register
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午9:41:54
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void register(String phone, String userName, String verifyCode, String agentCode, String loginPwd,
			String refereePhone) {
		// 校验短信验证码是否正确
		boolean codeResult = smsManager.checkVerifyCode(phone, verifyCode, SmsType.REGISTER.getValue());
		if (!codeResult) {
			throw new ApplicationException("您好，注册短信验证码错误");
		}
		// 查询用户是否存在
		User user = getUserByPhone(phone);
		if (null != user) {
			throw new ApplicationException("您好，用户已存在，请直接登录");
		}
		User refereUser = null;
		User indirectUser = null;
		User newUser = new User();
		if (StringUtils.isNotEmpty(refereePhone)) {
			// 查询推荐用户是否存在
			refereUser = getUserByPhone(refereePhone);
			if (null == refereUser) {
				throw new ApplicationException("您好，推荐用户不存在录");
			}
			noticeManager.insert(refereUser.getId(), NoticeType.REGISTERNOTICE.getValue(),
					String.format(DERECTMESSAGE, refereUser.getRealName()));

			// 直接推荐人
			newUser.setDirectRecommendationAccount(refereePhone);
			indirectUser = getUserByPhone(refereUser.getDirectRecommendationAccount());
			// 间接推荐人
			newUser.setIndirectRecommendationAccount(refereUser.getDirectRecommendationAccount());
		}
		newUser.setAccount(phone);
		newUser.setPwd(MD5Util.generatePassword(loginPwd));
		newUser.setAgentCode(agentCode);
		newUser.setGmtCreate(new Date());
		newUser.setGmtModify(new Date());
		newUser.setStatus(Status.ZERO.getValue());
		newUser.setUserName(userName);
		newUser.setRealName(userName);
		try {
			userDAO.insertSelective(newUser);
		} catch (DataAccessException e) {
			LOGGER.error("gregister失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

		if (refereUser != null) {
			// 入库直接推荐人的推荐信息
			referralInformationManager.saveReferalInfomation(refereUser.getId(), refereUser.getUserName(),
					RefereeType.DERECT.getValue(), newUser.getId(), newUser.getUserName());
			// 直接推荐人的推荐人就是间接推荐人,要查询间接推荐人是否存在
			if (StringUtils.isNotEmpty(refereUser.getDirectRecommendationAccount())) {

				if (null != indirectUser) {
					noticeManager.insert(refereUser.getId(), NoticeType.REGISTERNOTICE.getValue(),
							String.format(INDERECTMESSAGE, refereUser.getRealName()));
					referralInformationManager.saveReferalInfomation(indirectUser.getId(), indirectUser.getUserName(),
							RefereeType.INDERECT.getValue(), newUser.getId(), newUser.getUserName());
				}
			}
		}

		// 用户插入默认客户角色2
		sysUserRoleManager.insert(RoleType.CUSTOMER.getValue(), newUser.getId());

	}

	/**
	* @Title:resetPwd
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午10:03:19
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void resetPwd(String phone, String verifyCode, String pwd) {
		// 查询用户是否存在
		User user = getUserByPhone(phone);
		if (null == user) {
			throw new ApplicationException("您好，请先注册账号");
		}
		// 校验短信验证码是否正确
		boolean codeResult = smsManager.checkVerifyCode(phone, verifyCode, SmsType.RESETPWD.getValue());
		if (!codeResult) {
			throw new ApplicationException("您好，重置密码短信验证码错误");
		}
		user.setPwd(MD5Util.generatePassword(pwd));
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("gregister失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:getUserById
	* @author:cy
	* @Description 
	* @date:2017年12月31日下午11:24:22
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public User getUserById(Integer userId) {
		try {
			return userDAO.selectByPrimaryKey(userId);
		} catch (DataAccessException e) {
			LOGGER.error("getUserById失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:resetPwd
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午2:06:57
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void resetPwd(Integer userId, String pwd) {
		User user = getUserById(userId);
		user.setPwd(MD5Util.generatePassword(pwd));
		user.setGmtModify(new Date());
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("resetPwd失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:updateUserBaseInfo
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午3:37:10
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateUserBaseInfo(String account, String realName, Byte sex, String contactPhone, String email,
			Byte whetherRealName, Byte wheatherGetMoney, Byte refereeQualification, String agentCode,
			String directRecommendationAccount, String indirectRecommendationAccount) {
		User user = getUserByPhone(account);
		if (null == user) {
			throw new ApplicationException("账号对应的用户不存在");
		}
		user.setRealName(realName);
		user.setSex(sex);
		user.setContactPhone(contactPhone);
		user.setWheatherGetMoney(wheatherGetMoney);
		user.setWhetherRealName(whetherRealName);
		user.setRefereeQualification(refereeQualification);
		user.setAgentCode(agentCode);

		if (StringUtils.isNotEmpty(directRecommendationAccount)) {
			User directUser = getUserByPhone(directRecommendationAccount);
			if (null == directUser) {
				throw new ApplicationException("直推人账号不存在");
			} else {
				user.setDirectRecommendationAccount(directRecommendationAccount);
			}
		} else {
			user.setDirectRecommendationAccount(directRecommendationAccount);
		}
		if (StringUtils.isNotEmpty(indirectRecommendationAccount)) {
			User inderect = getUserByPhone(indirectRecommendationAccount);
			if (null == inderect) {
				throw new ApplicationException("间推人账号不存在");
			} else {
				user.setIndirectRecommendationAccount(indirectRecommendationAccount);
			}
		} else {
			user.setIndirectRecommendationAccount(indirectRecommendationAccount);
		}

		user.setEmail(email);
		user.setGmtModify(new Date());
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("updateUserBaseInfo失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

	}

	/**
	* @Title:updateUsePic
	* @author:cy
	* @Description 保存上传图片路径
	* @date:2018年1月1日下午4:32:27
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateUsePic(String path, Byte picType, String account) {
		User user = getUserByPhone(account);
		if (null == user) {
			throw new ApplicationException("账号对应的用户不存在");
		}
		if (picType.equals(PicType.FRONT.getValue())) {
			user.setCertificateFront(path);
		} else if (picType.equals(PicType.BACK.getValue())) {
			user.setCertificateBack(path);
		} else {
			user.setAddressPic(path);
		}
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("updateUsePic失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:checkRealName
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午4:35:54
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void checkRealName(String realName, Byte certificateType, String certificateNumber, String account) {
		User user = getUserByPhone(account);
		if (null == user) {
			throw new ApplicationException("账号对应的用户不存在");
		}
		user.setRealName(realName);
		user.setCertificateType(certificateType);
		user.setCertificateNumber(certificateNumber);
		user.setGmtModify(new Date());
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("checkRealName失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:addUser
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午4:52:08
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void addUser(String account, String userName, String contactPhone, Byte userType, String agentName,
			Byte whetherFreeze, Date freezeDate, String pwd, String customerAgent, String agentCode,
			String refereePhone) {
		LOGGER.info("代理商编码agentCode=================" + agentCode);
		User user = getUserByPhone(account);
		if (null != user) {
			throw new ApplicationException("账号对应的用户已存在");
		}
		User newUser = new User();
		User indirectUser = null;
		User refereUser = null;
		if (StringUtils.isNotEmpty(refereePhone)) {
			// 查询推荐用户是否存在
			refereUser = getUserByPhone(refereePhone);
			if (null == refereUser) {
				throw new ApplicationException("您好，推荐用户不存在录");
			}
			noticeManager.insert(refereUser.getId(), NoticeType.REGISTERNOTICE.getValue(),
					String.format(DERECTMESSAGE, refereUser.getRealName()));
			// 直接推荐人
			newUser.setDirectRecommendationAccount(refereePhone);
			indirectUser = getUserByPhone(refereUser.getDirectRecommendationAccount());
			// 间接推荐人
			newUser.setIndirectRecommendationAccount(refereUser.getDirectRecommendationAccount());
		}
		// 首先要查询代理商是否添加、
		if (userType.equals(UserType.AGENT.getValue())) {
			Agent agent = agentManager.getAgentByAgentName(agentName);
			if (null == agent) {
				throw new ApplicationException("请先添加对应的代理商在再来添加用户");
			}
		}
		newUser.setAccount(account);
		newUser.setUserName(userName);
		newUser.setRealName(userName);
		newUser.setAgentName(agentName);
		newUser.setContactPhone(contactPhone);
		newUser.setUserType(userType);
		newUser.setWhetherFreeze(whetherFreeze);
		newUser.setFreezeDate(freezeDate);
		newUser.setPwd(MD5Util.generatePassword(pwd));
		newUser.setGmtCreate(new Date());
		newUser.setGmtModify(new Date());
		newUser.setStatus(Status.ZERO.getValue());
		newUser.setCustomerAgent(customerAgent);
		newUser.setAgentCode(agentCode);

		try {
			userDAO.insertSelective(newUser);
		} catch (DataAccessException e) {
			LOGGER.error("checkRealName失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		if (refereUser != null) {
			// 入库直接推荐人的推荐信息
			referralInformationManager.saveReferalInfomation(refereUser.getId(), refereUser.getUserName(),
					RefereeType.DERECT.getValue(), newUser.getId(), newUser.getUserName());
			// 直接推荐人的推荐人就是间接推荐人,要查询间接推荐人是否存在
			if (StringUtils.isNotEmpty(refereUser.getDirectRecommendationAccount())) {
				if (null != indirectUser) {
					noticeManager.insert(refereUser.getId(), NoticeType.REGISTERNOTICE.getValue(),
							String.format(INDERECTMESSAGE, refereUser.getRealName()));
					referralInformationManager.saveReferalInfomation(indirectUser.getId(), indirectUser.getUserName(),
							RefereeType.INDERECT.getValue(), newUser.getId(), newUser.getUserName());
				}
			}
		}

		// 代理商
		if (userType.equals(UserType.AGENT.getValue())) {
			sysUserRoleManager.insert(RoleType.AGENT.getValue(), newUser.getId());
		} else if (userType.equals(UserType.CUSTOMER.getValue())) {
			sysUserRoleManager.insert(RoleType.CUSTOMER.getValue(), newUser.getId());
		} else if (userType.equals(UserType.ADMIN.getValue())) {
			sysUserRoleManager.insert(RoleType.ADMIN.getValue(), newUser.getId());
		}

	}

	/**
	* @Title:getuserByAgentCode
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午5:14:33
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public User getuserByAgentCode(String agentCode) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAgentCodeEqualTo(agentCode);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getUserByPhone获取用户信息失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getUserList
	* @author:cy
	* @Description 
	* @date:2018年1月1日下午8:40:40
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<UserListVO> getUserList(String account, String userName, Byte userType, Byte whetherFreeze,
			String contactPhone, String directRecommendationAccount, Date gmtCreateBegin, Date gmtCreateEnd,
			int pageNum, int pageSize) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		if (StringUtils.isNotEmpty(account)) {
			criteria.andAccountLike("%" + account + "%");
		}
		if (StringUtils.isNotEmpty(userName)) {
			criteria.andUserNameLike("%" + userName + "%");
		}
		if (null != userType) {
			criteria.andUserTypeEqualTo(userType);
		}
		if (null != whetherFreeze) {
			criteria.andWhetherFreezeEqualTo(whetherFreeze);
		}
		if (StringUtils.isNotEmpty(contactPhone)) {
			criteria.andContactPhoneLike("%" + contactPhone + "%");
		}
		if (StringUtils.isNotEmpty(directRecommendationAccount)) {
			criteria.andDirectRecommendationAccountLike("%" + directRecommendationAccount + "%");
		}
		if (null != gmtCreateBegin) {
			criteria.andGmtCreateGreaterThan(gmtCreateBegin);
		}
		if (null != gmtCreateEnd) {
			criteria.andGmtCreateLessThan(gmtCreateEnd);
		}

		com.github.pagehelper.Page<User> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			userDAO.selectByExample(userExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRegisterNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertPage(page, pageNum, pageSize);
	}

	/**
	* @Title CovertPage
	* @author cy
	* @Description 
	* @date 2018年1月1日下午8:50:04
	* @param 
	* @param 
	* @param 
	* @return Page<UserListVO>
	* @throws:
	*/
	private Page<UserListVO> CovertPage(com.github.pagehelper.Page<User> page, int pageNum, int pageSize) {
		List<User> userList = page.toPageInfo().getList();
		List<UserListVO> userVOList = new ArrayList<>(userList.size());
		for (User user : userList) {
			try {
				UserListVO userListVO = ObjectUtils.convert(user, UserListVO.class);
				userListVO.setGmtCreate(DateUtil.date2Str(user.getGmtCreate(), DateUtil.FORMAT_DATE));
				if (null != user.getFreezeDate()) {
					userListVO.setFreezeDate(DateUtil.date2Str(user.getFreezeDate(), DateUtil.FORMAT_DATE));
				}
				userVOList.add(userListVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<UserListVO>(pageSize, pageNum, userList.size(), userVOList);
	}

	/**
	* @Title:getAllUser
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午1:22:02
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<User> getAllUser() {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		try {
			return userDAO.selectByExample(userExample);
		} catch (DataAccessException e) {
			LOGGER.error("getAllUser失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getByAccount
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午4:07:14
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public User getByAccount(String account) {
		if (StringUtils.isEmpty(account)) {
			return null;
		}
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAccountEqualTo(account);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getAllUser失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:updateSumMoneyByUsId
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午9:11:09
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void updateSumMoneyByUsId(double investmentAmount, Integer userId) {
		User user = getUserById(userId);
		if (null != user) {
			user.setGmtModify(new Date());
			user.setSumMoney(new BigDecimal(DecimalUtil.add(user.getSumMoney().doubleValue(), investmentAmount)));
			try {
				userDAO.updateByPrimaryKey(user);
			} catch (DataAccessException e) {
				LOGGER.error("updateSumMoneyByUsId失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}

	}

	/**
	* @Title:getCustomerRecommandVOList
	* @author:cy
	* @Description 
	* @date:2018年1月6日下午9:23:17
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public Page<CustomerRecommandVO> getCustomerRecommandVOList(String account, String realName, Byte whetherGetMoney,
			Byte refereeQualification, String indirectRecommendationAccount, String directRecommendationAccount,
			Date gmtCreateBegin, Date gmtCreateEnd, int pageNum, int pageSize) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		if (StringUtils.isNotEmpty(account)) {
			criteria.andAccountLike("%" + account + "%");
		}
		if (StringUtils.isNotEmpty(realName)) {
			criteria.andRealNameLike("%" + realName + "%");
		}
		if (null != whetherGetMoney) {
			criteria.andWhetherRealNameEqualTo(whetherGetMoney);
		}
		if (null != refereeQualification) {
			criteria.andRefereeQualificationEqualTo(refereeQualification);
		}
		if (StringUtils.isNotEmpty(indirectRecommendationAccount)) {
			criteria.andIndirectRecommendationAccountLike("%" + indirectRecommendationAccount + "%");
		}
		if (StringUtils.isNotEmpty(directRecommendationAccount)) {
			criteria.andDirectRecommendationAccountLike("%" + directRecommendationAccount + "%");
		}
		if (null != gmtCreateBegin) {
			criteria.andGmtCreateGreaterThan(gmtCreateBegin);
		}
		if (null != gmtCreateEnd) {
			criteria.andGmtCreateLessThan(gmtCreateEnd);
		}

		com.github.pagehelper.Page<User> page = PageHelper.startPage(pageNum, pageSize);
		page.setOrderBy(" gmt_create desc");
		try {
			userDAO.selectByExample(userExample);
		} catch (DataAccessException e) {
			LOGGER.error("getRegisterNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return CovertCustomerRecommandVOPage(page, pageNum, pageSize);
	}

	/**
	* @Title CovertCustomerRecommandVOPage
	* @author cy
	* @Description 
	* @date 2018年1月6日下午9:27:01
	* @param 
	* @param 
	* @param 
	* @return Page<CustomerRecommandVO>
	* @throws:
	*/
	private Page<CustomerRecommandVO> CovertCustomerRecommandVOPage(com.github.pagehelper.Page<User> page, int pageNum,
			int pageSize) {
		List<User> userList = page.toPageInfo().getList();
		List<CustomerRecommandVO> customerRecommandVOList = new ArrayList<CustomerRecommandVO>(userList.size());
		for (User user : userList) {
			try {
				CustomerRecommandVO customerRecommandVO = ObjectUtils.convert(user, CustomerRecommandVO.class);
				/*
				 * customerRecommandVO.setAccount(user.getAccount().replaceAll(
				 * PHONEREX, HIDESTR)); if
				 * (StringUtils.isNoneEmpty(user.getContactPhone())) {
				 * customerRecommandVO.setContactPhone(user.getContactPhone().
				 * replaceAll(PHONEREX, HIDESTR)); }
				 */
				customerRecommandVO.setAccount(user.getAccount());
				customerRecommandVO.setContactPhone(user.getContactPhone());
				customerRecommandVO.setGmtCreate(DateUtil.date2Str(user.getGmtCreate(), DateUtil.FORMAT_DATE));
				if (user.getSex().equals(SexType.MALE.getValue())) {
					customerRecommandVO.setSexName(SexType.MALE.getDescription());
				} else {
					customerRecommandVO.setSexName(SexType.FEMALE.getDescription());
				}
				customerRecommandVO.setWhetherRealName(BooleanType.getDes(user.getWhetherRealName()));
				customerRecommandVO.setWheatherGetMoney(BooleanType.getDes(user.getWheatherGetMoney()));
				customerRecommandVO.setRefereeQualification(BooleanType.getDes(user.getRefereeQualification()));
				customerRecommandVO.setSumMoney(user.getSumMoney().doubleValue());
				customerRecommandVO.setDirectRecommendationAccount(user.getDirectRecommendationAccount());
				customerRecommandVO.setIndirectRecommendationAccount(user.getIndirectRecommendationAccount());
				/*
				 * if
				 * (StringUtils.isNotEmpty(user.getDirectRecommendationAccount()
				 * )) { customerRecommandVO.setDirectRecommendationAccount(
				 * user.getDirectRecommendationAccount().replaceAll(ACCOUNTREX,
				 * ACCOUNTHIDESTR)); } if
				 * (StringUtils.isNotEmpty(user.getIndirectRecommendationAccount
				 * ())) { customerRecommandVO.setIndirectRecommendationAccount(
				 * user.getIndirectRecommendationAccount().replaceAll(
				 * ACCOUNTREX, ACCOUNTHIDESTR)); }
				 */
				customerRecommandVOList.add(customerRecommandVO);
			} catch (Exception e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return new Page<CustomerRecommandVO>(pageSize, pageNum, customerRecommandVOList.size(),
				customerRecommandVOList);
	}

	/**
	* @Title:updateUserCheckEmail
	* @author:cy
	* @Description 
	* @date:2018年1月25日下午10:46:14
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public boolean updateUserCheckEmail(String email) {
		User user = getUserByEmail(email);
		if (null != user) {
			user.setGmtModify(new Date());
			user.setCheckEmail(BooleanType.YES.getValue());
			try {
				userDAO.updateByPrimaryKey(user);
				return true;
			} catch (DataAccessException e) {
				LOGGER.error("CovertPage失败====", e);
				throw new RuntimeException("内部服务器错误");
			}
		}
		return false;
	}

	/**
	* @Title getUserByEmail
	* @author cy
	* @Description 
	* @date 2018年1月25日下午10:46:38
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	private User getUserByEmail(String email) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andEmailEqualTo(email);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
		} catch (DataAccessException e) {
			LOGGER.error("getAllUser失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:resetPwd
	* @author:cy
	* @Description 
	* @date:2018年1月28日下午7:35:29
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public void setUserBaseInfoVO(UserBaseInfoVO userBaseInfoVO) {
		setDerectId(userBaseInfoVO);
		setInderectId(userBaseInfoVO);
	}

	/**
	* @Title:getCustomerRecommandVOListByAccount
	* @author:cy
	* @Description 
	* @date:2018年1月28日下午8:05:50
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public CustomerRecommandVO getCustomerRecommandVOListByAccount(String account) {
		CustomerRecommandVO vo = null;
		try {
			User user = getByAccount(account);
			vo = converPOToVO(user);
			// 直接
			/*
			 * List<CustomerRecommandVO> deList = new ArrayList<>();
			 * CustomerRecommandVO deVo = getCustomerRecommandVO(user, vo);
			 * deList.add(deVo); vo.setDerectchildren(deList);
			 */
			// 间接
			CopyOnWriteArrayList<CustomerRecommandVO> indeList = new CopyOnWriteArrayList<>();
			CustomerRecommandVO indeVo = getCustomerRecommandVO(user, vo);
			indeList.add(indeVo);
			vo.setInDerectchildren(indeList);
		} catch (Exception e) {
			LOGGER.error("获取推荐人,错误：" + e.getMessage());
			throw new RuntimeException("获取推荐人失败");
		}
		return vo;
	}

	private CustomerRecommandVO getCustomerRecommandVO(User user, CustomerRecommandVO vo) {

		if (null == user) {
			return null;
		}
		/*
		 * if (vo.getDerectchildren() == null) { vo.setDerectchildren(new
		 * CopyOnWriteArrayList<CustomerRecommandVO>()); }
		 */
		if (vo.getInDerectchildren() == null) {
			vo.setInDerectchildren(new CopyOnWriteArrayList<CustomerRecommandVO>());
		}
		/*
		 * User deUser = getByAccount(user.getDirectRecommendationAccount());
		 * CustomerRecommandVO derectVo = converPOToVO(deUser); if (deUser !=
		 * null) { // vo.setDerectchildren(getCustomerRecommandVO(deUser,
		 * derectVo)); // 直接 CustomerRecommandVO deVo =
		 * getCustomerRecommandVO(deUser, derectVo);
		 * vo.getDerectchildren().add(deVo);
		 * 
		 * }
		 */
		synchronized (this) {
			User inUser = getByAccount(user.getIndirectRecommendationAccount());
			CustomerRecommandVO InDerectVo = converPOToVO(inUser);
			if (inUser != null) {
				// vo.setInDerectchildren(getCustomerRecommandVO(inUser,
				// InDerectVo));
				// 间接
				// CustomerRecommandVO indeVo = getCustomerRecommandVO(inUser,
				// InDerectVo);
				vo.getInDerectchildren().add(getCustomerRecommandVO(inUser, InDerectVo));
			}
		}
		return vo;
	}

	/**
	* @Title getCustomerRecccommandByAccount
	* @author cy
	* @Description 
	* @date 2018年1月28日下午8:08:25
	* @param 
	* @param 
	* @param 
	* @return CustomerRecommandVO
	* @throws:
	*/
	private CustomerRecommandVO getCustomerRecccommandByAccount(String account) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAccountEqualTo(account);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			if (!CollectionUtils.isEmpty(userList)) {
				CustomerRecommandVO vo = converPOToVO(userList.get(0));
				return vo;
			}

		} catch (DataAccessException e) {
			LOGGER.error("getRegisterNoticeByUserId失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return null;
	}

	/**
	* @Title converPOToVO
	* @author cy
	* @Description 
	* @date 2018年1月28日下午8:12:05
	* @param 
	* @param 
	* @param 
	* @return CustomerRecommandVO
	* @throws:
	*/
	private CustomerRecommandVO converPOToVO(User user) {
		if (null == user) {
			return null;
		}
		try {
			CustomerRecommandVO customerRecommandVO = ObjectUtils.convert(user, CustomerRecommandVO.class);
			customerRecommandVO.setAccount(user.getAccount().replaceAll(PHONEREX, HIDESTR));
			if (StringUtils.isNoneEmpty(user.getContactPhone())) {
				customerRecommandVO.setContactPhone(user.getContactPhone().replaceAll(PHONEREX, HIDESTR));
			}
			customerRecommandVO.setGmtCreate(DateUtil.date2Str(user.getGmtCreate(), DateUtil.FORMAT_DATE));
			if (user.getSex().equals(SexType.MALE.getValue())) {
				customerRecommandVO.setSexName(SexType.MALE.getDescription());
			} else {
				customerRecommandVO.setSexName(SexType.FEMALE.getDescription());
			}
			customerRecommandVO.setWhetherRealName(BooleanType.getDes(user.getWhetherRealName()));
			customerRecommandVO.setWheatherGetMoney(BooleanType.getDes(user.getWheatherGetMoney()));
			customerRecommandVO.setRefereeQualification(BooleanType.getDes(user.getRefereeQualification()));
			customerRecommandVO.setSumMoney(user.getSumMoney().doubleValue());
			if (StringUtils.isNotEmpty(user.getDirectRecommendationAccount())) {
				customerRecommandVO.setDirectRecommendationAccount(
						user.getDirectRecommendationAccount().replaceAll(ACCOUNTREX, ACCOUNTHIDESTR));
			}
			if (StringUtils.isNotEmpty(user.getIndirectRecommendationAccount())) {
				customerRecommandVO.setIndirectRecommendationAccount(
						user.getIndirectRecommendationAccount().replaceAll(ACCOUNTREX, ACCOUNTHIDESTR));
			}
			return customerRecommandVO;
		} catch (Exception e) {
			LOGGER.error("CovertPage失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

	/**
	* @Title:getUserListByAgentCode
	* @author:cy
	* @Description 
	* @date:2018年2月5日下午11:17:01
	* @param 
	* @param 
	* @param 
	* @return 
	* @throws:
	*/
	@Override
	public List<Integer> getUserListByAgentCode(String agentCode) {
		UserExample userExample = new UserExample();
		UserExample.Criteria criteria = userExample.createCriteria();
		criteria.andStatusGreaterThanOrEqualTo(Status.ZERO.getValue());
		criteria.andAgentCodeEqualTo(agentCode);
		try {
			List<User> userList = userDAO.selectByExample(userExample);
			if (!CollectionUtils.isEmpty(userList)) {
				List<Integer> users = new ArrayList<>();
				for (User user : userList) {
					users.add(user.getId());
				}
				return users;
			}
		} catch (DataAccessException e) {
			LOGGER.error("getUserListByAgentCode失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
		return null;
	}

}
