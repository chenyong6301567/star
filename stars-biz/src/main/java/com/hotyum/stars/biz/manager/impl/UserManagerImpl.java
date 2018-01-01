package com.hotyum.stars.biz.manager.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.pagehelper.StringUtil;
import com.hotyum.stars.biz.manager.RegisterNoticeManager;
import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.biz.manager.SysUserRoleManager;
import com.hotyum.stars.biz.manager.TokenAccessManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.dal.dao.UserDAO;
import com.hotyum.stars.dal.model.RegisterNotice;
import com.hotyum.stars.dal.model.SysUserRole;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.dal.model.UserExample;
import com.hotyum.stars.utils.Assert;
import com.hotyum.stars.utils.enums.LoginType;
import com.hotyum.stars.utils.enums.PicType;
import com.hotyum.stars.utils.enums.RefereeType;
import com.hotyum.stars.utils.enums.SmsType;
import com.hotyum.stars.utils.enums.Status;
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
	private RegisterNoticeManager registerNoticeManager;

	private static final String DERECTMESSAGE = "您的直推客户{0}成功注册了系统，请您悉知。";

	private static final String INDERECTMESSAGE = "您的间推客户{0}成功注册了系统，请您悉知。";

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagerImpl.class);

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
			boolean codeResult = smsManager.checkVerifyCode(phone, verifyCode, SmsType.LOGIN.getValue());
			if (!codeResult) {
				throw new ApplicationException("您好，短信验证码错误");
			}
		} else if (loginType.equals(LoginType.PASSWORDLOGIN.getValue())) {
			// 密码登录
			Assert.notEmpty(password, "密码不能为空");
			String md5pwd = Md5Crypt.md5Crypt(password.getBytes());
			if (StringUtils.isEmpty(user.getPwd())) {
				throw new ApplicationException("您好，请先用验证码登录之后设置好密码再用密码登录");
			}
			if (user.getPwd().equals(md5pwd)) {
				throw new ApplicationException("您好，密码不一致，请重新輸入正确的密码");
			}
		}

		// 生成uuId作为token返回
		String token = tokenAccessManager.insertLoginToken(user);
		List<SysUserRole> sysUserRolesList = sysUserRoleManager.getRoleByUserId(user.getId());
		return new TokenInfoVO(token, sysUserRolesList);
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
	private User getUserByPhone(String phone) {
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
		User newUser = new User();
		if (StringUtils.isNotEmpty(refereePhone)) {
			// 查询推荐用户是否存在
			refereUser = getUserByPhone(refereePhone);
			if (null == refereUser) {
				throw new ApplicationException("您好，推荐用户不存在录");
			}
			registerNoticeManager.insert(refereUser.getId(), refereePhone, RefereeType.DERECT.getValue(),
					String.format(DERECTMESSAGE, refereUser.getRealName()));

			// 直接推荐人
			newUser.setDirectRecommendationAccount(refereePhone);
			// 直接推荐人的推荐人就是间接推荐人,要查询间接推荐人是否存在
			if (StringUtils.isNotEmpty(refereUser.getDirectRecommendationAccount())) {
				User indirectUser = getUserByPhone(refereUser.getDirectRecommendationAccount());
				if (null != indirectUser) {
					// 间接推荐人
					newUser.setIndirectRecommendationAccount(refereUser.getDirectRecommendationAccount());
					registerNoticeManager.insert(refereUser.getId(), refereePhone, RefereeType.DERECT.getValue(),
							String.format(INDERECTMESSAGE, refereUser.getRealName()));
				}
			}
		}
		newUser.setAccount(phone);
		newUser.setPwd(Md5Crypt.md5Crypt(loginPwd.getBytes()));
		newUser.setAgentCode(agentCode);
		newUser.setGmtCreate(new Date());
		newUser.setGmtModify(new Date());
		newUser.setStatus(Status.ZERO.getValue());
		try {
			userDAO.insertSelective(newUser);
		} catch (DataAccessException e) {
			LOGGER.error("gregister失败====", e);
			throw new RuntimeException("内部服务器错误");
		}

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
		boolean codeResult = smsManager.checkVerifyCode(phone, verifyCode, SmsType.REGISTER.getValue());
		if (!codeResult) {
			throw new ApplicationException("您好，重置密码短信验证码错误");
		}
		user.setPwd(Md5Crypt.md5Crypt(pwd.getBytes()));
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
		user.setPwd(Md5Crypt.md5Crypt(pwd.getBytes()));
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
		user.setDirectRecommendationAccount(indirectRecommendationAccount);
		user.setIndirectRecommendationAccount(indirectRecommendationAccount);
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
		try {
			userDAO.updateByPrimaryKey(user);
		} catch (DataAccessException e) {
			LOGGER.error("checkRealName失败====", e);
			throw new RuntimeException("内部服务器错误");
		}
	}

}
