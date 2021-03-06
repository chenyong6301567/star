package com.hotyum.stars.biz.manager;

import java.util.Date;
import java.util.List;

import com.hotyum.stars.biz.model.CustomerRecommandVO;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.biz.model.UserListVO;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.Page;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午12:57:59 
 */
public interface UserManager {

	/**
	* @Title login
	* @author cy
	* @Description 登录
	* @date 2017年12月31日下午8:11:26
	* @param 
	* @param 
	* @param 
	* @return boolean
	* @throws:
	*/
	TokenInfoVO login(String phone, String password, String verifyCode, Integer loginType);

	/**
	* @Title register
	* @author cy
	* @Description 注册
	* @date 2017年12月31日下午9:41:36
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void register(String phone, String userName, String verifyCode, String agentCode, String loginPwd,
			String refereePhone);

	/**
	* @Title resetPwd
	* @author cy
	* @Description  重置密码
	* @date 2017年12月31日下午10:03:02
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void resetPwd(String phone, String verifyCode, String pwd);

	/**
	* @Title getUserById
	* @author cy
	* @Description 
	* @date 2017年12月31日下午11:24:15
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	User getUserById(Integer userId);

	/**
	* @Title resetPwd
	* @author cy
	* @Description 
	* @date 2018年1月1日下午2:06:50
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void resetPwd(Integer userId, String pwd);

	/**
	* @Title updateUserBaseInfo
	* @author cy
	 * @param userd 
	* @Description 
	* @date 2018年1月1日下午3:37:02
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void updateUserBaseInfo(String account, String realName, Byte sex, String contactPhone, String email,
			Byte whetherRealName, Byte wheatherGetMoney, Byte refereeQualification, String agentCode,
			String directRecommendationAccount, String indirectRecommendationAccount);

	/**
	* @Title updateUsePic
	* @author cy
	* @Description 
	* @date 2018年1月1日下午4:32:20
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void updateUsePic(String path, Byte picType, String account);

	/**
	* @Title checkRealName
	* @author cy
	* @Description 
	* @date 2018年1月1日下午4:35:45
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void checkRealName(String realName, Byte certificateType, String certificateNumber, String account);

	/**
	* @Title addUser
	* @author cy
	 * @param customerAgent 
	 * @param agentCode 
	 * @param refereePhone 
	* @Description 
	* @date 2018年1月1日下午4:52:01
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void addUser(String account, String userName, String contactPhone, Byte userType, String agentName,
			Byte whetherFreeze, Date freezeDate, String pwd, String customerAgent, String agentCode,
			String refereePhone);

	/**
	* @Title getuserByAgentCode
	* @author cy
	* @Description 
	* @date 2018年1月1日下午5:14:20
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	User getuserByAgentCode(String agentCode);

	/**
	* @Title getUserList
	* @author cy
	* @param pageSize 
	* @param pageNum 
	* @Description 获取用户管理列表
	* @date 2018年1月1日下午8:40:24
	* @param 
	* @param 
	* @param 
	* @return Page<UserListVO>
	* @throws:
	*/
	Page<UserListVO> getUserList(String account, String userName, Byte userType, Byte whetherFreeze,
			String contactPhone, String directRecommendationAccount, Date gmtCreateBegin, Date gmtCreateEnd,
			int pageNum, int pageSize);

	/**
	* @Title getAllUser
	* @author cy
	* @Description 
	* @date 2018年1月6日下午1:21:36
	* @param 
	* @param 
	* @param 
	* @return List<User>
	* @throws:
	*/
	List<User> getAllUser();

	/**
	* @Title getByAccount
	* @author cy
	* @Description 
	* @date 2018年1月6日下午4:07:04
	* @param 
	* @param 
	* @param 
	* @return User
	* @throws:
	*/
	User getByAccount(String derectRecomandPerson);

	/**
	* @Title updateSumMoneyByUsId
	* @author cy
	* @Description 
	* @date 2018年1月6日下午9:10:49
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void updateSumMoneyByUsId(double investmentAmount, Integer usId);

	/**
	* @Title getCustomerRecommandVOList
	* @author cy
	* @Description 
	* @date 2018年1月6日下午9:20:08
	* @param 
	* @param 
	* @param 
	* @return Page<CustomerRecommandVO>
	* @throws:
	*/
	Page<CustomerRecommandVO> getCustomerRecommandVOList(String account, String realName, Byte whetherGetMoney,
			Byte refereeQualification, String indirectRecommendationAccount, String directRecommendationAccount,
			Date gmtCreateBegin, Date gmtCreateEnd, int pageNum, int pageSize);

	/**
	* @Title updateUserCheckEmail
	* @author cy
	* @Description 
	* @date 2018年1月25日下午10:46:01
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	boolean updateUserCheckEmail(String email);

	User getUserByPhone(String phone);

	/**
	* @Title resetPwd
	* @author cy
	* @Description 
	* @date 2018年1月28日下午7:35:21
	* @param 
	* @param 
	* @param 
	* @return void
	* @throws:
	*/
	void setUserBaseInfoVO(UserBaseInfoVO userBaseInfoVO);

	/**
	* @Title getCustomerRecommandVOListByAccount
	* @author cy
	* @Description 
	* @date 2018年1月28日下午8:06:52
	* @param 
	* @param 
	* @param 
	* @return List<CustomerRecommandVO>
	* @throws:
	*/
	CustomerRecommandVO getCustomerRecommandVOListByAccount(String account);

	/**
	* @Title getUserListByAgentCode
	* @author cy
	* @Description 
	* @date 2018年2月5日下午11:16:50
	* @param 
	* @param 
	* @param 
	* @return List<Integer>
	* @throws:
	*/
	List<Integer> getUserListByAgentCode(String agentCode);

	/**
	* @Title:adminUpdateUserBaseInfo
	* @author：cy
	* @Description:管理员修改用户信息
	* @date:2018年3月10日
	* @return:void
	* @throws:
	*/
	void adminUpdateUserBaseInfo(Integer id, String account, String realName, String contactPhone, Byte userType,
			String agentCode, String agentName, Byte whetherFreeze, Date freezeDate, String customerAgent,
			String directRecommendationAccount);

	/**
	* @Title:getUserListAndInderectIsNullAndDerectIsNotNull
	* @author：cy
	* @Description:
	* @date:2018年3月13日
	* @param
	* @param
	* @param
	* @return:List<User>
	* @throws:
	*/
	List<User> getUserListAndInderectIsNullAndDerectIsNotNull();

	/**
	* @Title:updateUserInfo
	* @author：cy
	* @Description:
	* @date:2018年3月13日
	* @param
	* @param
	* @param
	* @return:void
	* @throws:
	*/
	void updateUserInfo(User user);
}
