package com.hotyum.stars.web.controller;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.croky.util.StringUtils;
import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.utils.Assert;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.RandomUtil;
import com.hotyum.stars.web.model.Result;
import com.hotyum.stars.web.util.TokenAccessUtils;

/**
* 登录以及注册  
* 
* @Title: 登录以及注册     
* @Description: 登录以及注册      
* @author cy
* @date 2017年12月31日 下午19:22:29 
*/
@RestController
public class AccountController {

	@Autowired
	private UserManager userManager;

	@Autowired
	private SmsManager smsManager;

	private static final int[] LOGINTYPE = { 1, 2 };

	/**
	 * 登录(包括密码登录和手机验证码登录，根据loginType进行区分)
	 * 
	 * @param phone 手机号|string|必填
	 * @param password 密码|string
	 * @param verifyCode 短信验证码,短信登录必填|string
	 * @param loginType 登录方式(1手机验证码登录,2密码登录)|int|必填
	 * @Title authLogin
	 * @respbody 
	 * @author cy
	 * @Description 登录(包括密码登录和手机验证码登录，根据loginType进行区分)
	 * @date 2017/12/31 19:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "account/login")
	public Result authLogin(@RequestParam(required = true) String phone, String password, String verifyCode,
			@RequestParam(required = true) Integer loginType) {
		Assert.checkPhone(phone, "请输入有效的手机号码");
		if (!ArrayUtils.contains(LOGINTYPE, loginType)) {
			return Result.errorReponse("登录类型不正确");
		}
		TokenInfoVO tokenInfoVO = userManager.login(phone, password, verifyCode, loginType);
		return Result.normalResponse(tokenInfoVO);

	}

	/**
	 * 注册账号
	 * 
	 * @param phone 手机号|string|必填
	 * @param userName 真实姓名|string|必填
	 * @param verifyCode 短信验证码|string|必填
	 * @param agentCode 代理商编号|string|必填
	 * @param loginPwd  登录密码|string|必填
	 * @param refereePhone 推荐人手机号|string|必填
	 * @Title register
	 * @respbody 
	 * @author cy
	 * @Description 注册账号
	 * @date 2017/12/31 21:39
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "account/register")
	public Result register(@RequestParam(required = true) String phone, @RequestParam(required = true) String userName,
			@RequestParam(required = true) String verifyCode, @RequestParam(required = true) String agentCode,
			@RequestParam(required = true) String loginPwd, String refereePhone) {
		Assert.checkPhone(phone, "请输入有效的手机号码");
		if (StringUtils.isNotEmpty(refereePhone)) {
			Assert.checkPhone(refereePhone, "请输入有效的推荐人手机号码");
		}
		userManager.register(phone, userName, verifyCode, agentCode, loginPwd, refereePhone);
		return Result.normalResponse();

	}

	/**
	 * 重置密码
	 * 
	 * @param phone 手机号|string|必填
	 * @param verifyCode 短信验证码|string|必填
	 * @param pwd  登录密码|string|必填
	 * @Title resetPwd
	 * @respbody 
	 * @author cy
	 * @Description 重置密码
	 * @date 2017/12/31 22:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "account/resetPwd")
	public Result resetPwd(@RequestParam(required = true) String phone,
			@RequestParam(required = true) String verifyCode, @RequestParam(required = true) String pwd) {
		Assert.checkPhone(phone, "请输入有效的手机号码");
		userManager.resetPwd(phone, verifyCode, pwd);
		return Result.normalResponse();

	}

	/**
	 * 登录之后修改密码
	 * 
	 * @param pwd 密码|string|必填
	 * @Title loginResetPwd
	 * @respbody 
	 * @author cy
	 * @Description 登录之后修改密码
	 * @date 2018/1/1 14:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "account/loginResetPwd")
	public Result loginResetPwd(@RequestParam(required = true) String pwd, HttpServletRequest request) {
		Integer userId = TokenAccessUtils.getLoginUserId(request);
		userManager.resetPwd(userId, pwd);
		return Result.normalResponse();
	}

	/**
	 * 发送短信验证码
	 * 
	 * @param phone 手机号|string|必填
	 * @param type  短信类型|type|必填
	 * @Title sendMsg
	 * @respbody 
	 * @author cy
	 * @Description 重置密码
	 * @date 2017/12/31 22:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "account/sendMsg")
	public Result sendMsg(@RequestParam(required = true) String phone, @RequestParam(required = true) byte type) {
		Assert.checkPhone(phone, "请输入有效的手机号码");
		String content = Constants.MESSAGECONENT;
		// 随机获取4位数短信验证码
		String messageCode = RandomUtil.random(Constants.MESSAGECODELENGTH);
		content = MessageFormat.format(content, messageCode);
		// 短信发送记录入库
		smsManager.saveMessageContent(content, type, phone, messageCode);
		// TODO
		// Boolean sendResult = smsService.send(phone, content);
		return Result.normalResponse();

	}

}
