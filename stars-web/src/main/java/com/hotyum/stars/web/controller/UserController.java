package com.hotyum.stars.web.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.croky.util.ObjectUtils;
import com.hotyum.stars.biz.manager.ReferralInformationManager;
import com.hotyum.stars.biz.manager.SendEmailManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.CustomerRecommandVO;
import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.biz.model.UserListVO;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.DataFormatVaildate;
import com.hotyum.stars.utils.MailUtil;
import com.hotyum.stars.utils.Page;
import com.hotyum.stars.utils.enums.UserType;
import com.hotyum.stars.utils.excel.ExcelUtils;
import com.hotyum.stars.web.model.Result;
import com.hotyum.stars.web.util.TokenAccessUtils;

/**
* 用户信息
* 
* @Title: 用户信息
* @Description: 用户信息      
* @author cy
* @date 2018年1月1日 下午14:43:29 
*/
@RestController
public class UserController {

	@Autowired
	private UserManager userManager;

	@Autowired
	private ReferralInformationManager referralInformationManager;

	@Autowired
	private SendEmailManager sendEmailManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	private static final String SERVERPATH = "http://111.230.221.41:8080/user/getpic?path=";

	private static final String REALPATH = "/usr/local/java/upload/certificate/";

	private static final String SMTP = "smtp.163.com"; // "SMTP服务器";
	private static final String FROM = "chenyong6301567@163.com";// "发信人";
	private static final String TO = "629584407@qq.com"; // 收信人
	private static final String SUBJECT = "邮箱验证"; // "邮件主题";
	String USERNAME = "chenyong6301567@163.com";// "用户名";
	String PASSWORD = "ccs13650833856";// "密码";

	/**
	 * 获取当前登录用户基本信息
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getUserBaseInfo
	 * @respbody {"code":1,"message":"成功","data":{"id":1,"account":"15700191306","realName":"陈勇","sex":1,"contactPhone":"15700191306","email":"629584407@qq.com","whetherRealName":1,"wheatherGetMoney":1,"refereeQualification":1,"agentCode":"abc123","directRecommendationAccount":"15700191293","indirectRecommendationAccount":"15700191294","certificateType":1,"certificateNumber":"1","certificateFront":"1","certificateBack":"1","addressPic":"1","myReferinfoMationVO":{"starDegree":"1","sumMoney":10.0,"directRewardRate":"1%","indirectRewardRate":"0.5%"},"derectCustomerReferInfoMationVOList":[{"id":1,"directRecommendationName":"张平","contractNum":1},{"id":2,"directRecommendationName":"张平","contractNum":1}],"inDerectCustomerReferInfoMationVOList":[{"id":1,"indirectRecommendationName":"admin","contractNum":1},{"id":2,"indirectRecommendationName":"admin","contractNum":1}]},"error":false,"success":true}
	 * @author cy
	 * @Description 获取用户基本信息
	 * @date 2018/1/1 15:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getUserBaseInfo")
	public Result getUserBaseInfo(HttpServletRequest request) {
		User user = TokenAccessUtils.getUserInfo(request);
		UserBaseInfoVO userBaseInfoVO = null;
		try {
			userBaseInfoVO = ObjectUtils.convert(user, UserBaseInfoVO.class);
			referralInformationManager.getReferInfomation(userBaseInfoVO);
		} catch (Exception e) {
			LOGGER.error("getUserBaseInfo对象转换异常", e);
			return Result.errorReponse("花落去用户基本信息错误");
		}
		return Result.normalResponse(userBaseInfoVO);
	}

	/**
	 * 根据id获取用户基本信息
	 * 
	 * @param id 用户id|int|必填
	 * @Title getUserBaseInfoById
	 * @respbody {"code":1,"message":"成功","data":{"id":1,"account":"15700191306","realName":"陈勇","sex":1,"contactPhone":"15700191306","email":"629584407@qq.com","whetherRealName":1,"wheatherGetMoney":1,"refereeQualification":1,"agentCode":"abc123","directRecommendationAccount":"15700191293","indirectRecommendationAccount":"15700191294","certificateType":1,"certificateNumber":"1","certificateFront":"1","certificateBack":"1","addressPic":"1","myReferinfoMationVO":{"starDegree":"1","sumMoney":10.0,"directRewardRate":"1%","indirectRewardRate":"0.5%"},"derectCustomerReferInfoMationVOList":[{"id":1,"directRecommendationName":"张平","contractNum":1},{"id":2,"directRecommendationName":"张平","contractNum":1}],"inDerectCustomerReferInfoMationVOList":[{"id":1,"indirectRecommendationName":"admin","contractNum":1},{"id":2,"indirectRecommendationName":"admin","contractNum":1}]},"error":false,"success":true}
	 * @author cy
	 * @Description 获取用户基本信息
	 * @date 2018/1/28 12:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getUserBaseInfoById")
	public Result getUserBaseInfoById(HttpServletRequest request, @RequestParam(required = true) Integer id) {
		User user = userManager.getUserById(id);
		UserBaseInfoVO userBaseInfoVO = null;
		try {
			userBaseInfoVO = ObjectUtils.convert(user, UserBaseInfoVO.class);
			referralInformationManager.getReferInfomation(userBaseInfoVO);
		} catch (Exception e) {
			LOGGER.error("getUserBaseInfo对象转换异常", e);
			return Result.errorReponse("花落去用户基本信息错误");
		}
		return Result.normalResponse(userBaseInfoVO);
	}

	/**修改用户基本信息
	 * 
	 * @param account                       注册账号|string|必填
	 * @param realName                      真实姓名|string|必填
	 * @param sex                           性别1,男2,女  |byte|必填
	 * @param contactPhone                  联系方式 |string|必填
	 * @param email                         邮箱账号|string|必填
	 * @param whetherRealName               是否实名(0否，1是)|string|必填
	 * @param wheatherGetMoney              是否入金(0否，1是)|string|必填
	 * @param refereeQualification          推荐人资质(0否，1是)|string|必填
	 * @param agentCode                     负责代理商编号|string|必填 
	 * @param directRecommendationAccount   直接推荐人账号|string|必填
	 * @param indirectRecommendationAccount 间接推荐人账号|string|必填
	 * @Title updateUserBaseInfo
	 * @respbody 
	 * @author cy
	 * @Description 获取用户基本信息
	 * @date 2018/1/1 15:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/updateUserBaseInfo")
	public Result updateUserBaseInfo(HttpServletRequest request, @RequestParam(required = true) String account,
			String realName, Byte sex, String contactPhone, String email, Byte whetherRealName, Byte wheatherGetMoney,
			Byte refereeQualification, String agentCode, String directRecommendationAccount,
			String indirectRecommendationAccount) {
		Integer userd = TokenAccessUtils.getLoginUserId(request);
		if (userd < 0) {
			throw new RuntimeException("请先登录再修改用戶基本信息");
		}
		userManager.updateUserBaseInfo(account, realName, sex, contactPhone, email, whetherRealName, wheatherGetMoney,
				refereeQualification, agentCode, directRecommendationAccount, indirectRecommendationAccount);
		return Result.normalResponse();
	}

	/**
	 * 实名验证(上传图片)
	 * 
	 * @param account                       注册账号|string|必填
	 * @param file                          上传图片
	 * @param picType                       图片类型（1，正面，2方面，3居住地)|byte|必填
	 * @Title uploadPic
	 * @respbody 
	 * @author cy
	 * @Description 上传图片
	 * @date 2018/1/1 16:23
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/uploadPic")
	public Result uploadPic(HttpServletRequest request, @RequestParam(required = true) String account,
			@RequestParam(value = "file", required = false) MultipartFile file, Byte picType)
			throws IllegalStateException, IOException {
		// String realPath =
		// request.getServletContext().getRealPath("/upload/certificate/");
		if (file != null) {// 判断上传的文件是否为空
			String fileName = file.getOriginalFilename();// 文件原名称
			String type = fileName.indexOf(".") != -1
					? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (!("GIF".equalsIgnoreCase(type) || "PNG".equalsIgnoreCase(type) || "JPG".equalsIgnoreCase(type))) {
				return Result.errorReponse("不支持[" + type + "]文件上传");
			}
			String trueFileName = account + "." + type;
			String path = REALPATH + trueFileName;
			LOGGER.info("存放图片文件的路径===========================:" + path);
			File file_ = new File(path);
			if (!file_.exists()) {
				file_.getParentFile().mkdirs();
				file_.createNewFile();
			}
			file.transferTo(file_);
			LOGGER.info("图片访问路径=============================" + SERVERPATH + path);
			userManager.updateUsePic(SERVERPATH + path, picType, account);
			return Result.normalResponse(path);
		}
		return Result.errorReponse("上传文件不能为空");
	}

	/**
	 * 实名验证
	 * 
	 * @param account                       注册账号|string|必填
	 * @param realName                      真实姓名|string|必填
	 * @param certificateType               证件类型(1.身份证；2 护照；3港澳通行证；4其他)|byte|必填
	 * @param certificateNumber             证件号码 |string|必填
	 * @param file                          上传图片
	 * @Title updateUserBaseInfo
	 * @respbody 
	 * @author cy
	 * @Description 实名验证
	 * @date 2018/1/1 15:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/checkRealName")
	public Result checkRealName(HttpServletRequest request, @RequestParam(required = true) String realName,
			Byte certificateType, String certificateNumber, @RequestParam(required = true) String account) {
		userManager.checkRealName(realName, certificateType, certificateNumber, account);
		return Result.normalResponse();
	}

	/**
	 * 用户添加
	 * 
	 * @param account                       注册账号|string|必填
	 * @param userName                      真实姓名|string|必填
	 * @param contactPhone                  联系方式 |string|必填
	 * @param userType                      用户性质1代理商 2客户 3管理员|Byte|必填
	 * @param whetherFreeze                 0 未冻结，1冻结|string|必填
	 * @param freezeDate                    冻结日期|string|必填
	 * @param agentName                     代理商名称(代理商必填)|string|必填 
	 * @param agentCode                     代理商编码(代理商必填)|String|必填
	 * @param pwd                           密码(默认123456)|string|必填
	 * @Title addUser
	 * @respbody 
	 * @author cy
	 * @Description 用户添加
	 * @date 2018/1/1 16:41
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/addUser")
	public Result addUser(HttpServletRequest request, String userName, String contactPhone,
			@RequestParam(required = true) Byte userType, Byte whetherFreeze,
			@RequestParam(required = true) String account, Date freezeDate, String agentName, String agentCode,
			@RequestParam(defaultValue = Constants.DEFAULTPWD) String pwd) {
		if (userType.equals(UserType.AGENT.getValue())) {
			if (StringUtils.isEmpty(agentName) || StringUtils.isEmpty(agentCode)) {
				return Result.errorReponse("代理商编码或名称不能为空");
			}
		}
		userManager.addUser(account, userName, contactPhone, userType, agentName, whetherFreeze, freezeDate, pwd);
		return Result.normalResponse();
	}

	/**用户管理列表
	 * 
	 * @param account                       注册账号|string
	 * @param userName                      用户名称|string
	 * @param userType                      用户性质1代理商 2客户 3管理员|byte
	 * @param whetherFreeze                 是否冻结0 未冻结，1冻结|byte
	 * @param contactPhone                  联系方式|string
	 * @param directRecommendationAccount   直接推荐人手机号|string
	 * @param gmtCreateBegin                註冊開始日期|string
	 * @param gmtCreateEnd                  注册截止日期|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title getUserList
	 * @respbody 
	 * @author cy
	 * @Description 用户管理列表
	 * @date 2018/1/1 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getUserList")
	public Result getUserList(String account, String userName, Byte userType, Byte whetherFreeze, String contactPhone,
			String directRecommendationAccount, Date gmtCreateBegin, Date gmtCreateEnd,
			@RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<UserListVO> page = userManager.getUserList(account, userName, userType, whetherFreeze, contactPhone,
				directRecommendationAccount, gmtCreateBegin, gmtCreateEnd, pageNum, pageSize);
		return Result.normalResponse(page);
	}

	/**客户推荐表查询
	 * 
	 * @param account                       注册账号|string
	 * @param realName                      真实姓名|string
	 * @param whetherGetMoney               是否入金0 未，1是|byte
	 * @param refereeQualification          推荐人资质0 未，1是|string
	 * @param directRecommendationAccount   直接推荐人账号|string
	 * @param indirectRecommendationAccount 间接推荐人账号|string
	 * @param gmtCreateBegin                注册开始止日期|string
	 * @param gmtCreateEnd                  注册截止日期|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title getCustomerRecommandVOList
	 * @respbody {"code":1,"message":"成功","data":{"pageNum":1,"pageSize":50,"startRow":0,"pages":1,"total":2,"list":[{"id":7,"account":"157****1293","realName":null,"contactPhone":null,"sexName":"男","gmtCreate":"2018-01-13 20:51:50","email":null,"whetherRealName":"否","wheatherGetMoney":"否","refereeQualification":"否","agentName":null,"directRecommendationAccount":"157*********","indirectRecommendationAccount":"157*********","sumMoney":0.0},{"id":1,"account":"157****1306","realName":"陈勇","contactPhone":"157****1306","sexName":"男","gmtCreate":"2018-01-07 15:05:28","email":"629584407@qq.com","whetherRealName":"是","wheatherGetMoney":"是","refereeQualification":"是","agentName":"abc123","directRecommendationAccount":"157*********","indirectRecommendationAccount":"157*********","sumMoney":0.0}],"hasPrePage":false,"hasNextPage":false},"error":false,"success":true}
	 * @author cy
	 * @Description 用户管理列表
	 * @date 2018/1/1 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getCustomerRecommandVOList")
	public Result getCustomerRecommandVOList(String account, String realName, Byte whetherGetMoney,
			Byte refereeQualification, String indirectRecommendationAccount, String directRecommendationAccount,
			Date gmtCreateBegin, Date gmtCreateEnd, @RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.PAGESIZE) int pageSize) {
		Page<CustomerRecommandVO> page = userManager.getCustomerRecommandVOList(account, realName, whetherGetMoney,
				refereeQualification, indirectRecommendationAccount, directRecommendationAccount, gmtCreateBegin,
				gmtCreateEnd, pageNum, pageSize);
		return Result.normalResponse(page);
	}

	/**客户推荐表导出excel
	 * 
	 * @param account                       注册账号|string
	 * @param realName                      真实姓名|string
	 * @param whetherGetMoney               是否入金0 未，1是|byte
	 * @param refereeQualification          推荐人资质0 未，1是|string
	 * @param directRecommendationAccount   直接推荐人账号|string
	 * @param indirectRecommendationAccount 间接推荐人账号|string
	 * @param gmtCreateBegin                注册开始止日期|string
	 * @param gmtCreateEnd                  注册截止日期|string
	 * @param pageNum                       页数|int|必填
	 * @param pageSize                      每页多少|int|必填
	 * @Title getCustomerRecommandVOList
	 * @respbody 
	 * @author cy
	 * @Description 客户推荐表导出excel
	 * @date 2018/1/14 20:29
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getCustomerRecommandVOListExcel")
	public Result getCustomerRecommandVOListExcel(String account, String realName, Byte whetherGetMoney,
			Byte refereeQualification, String indirectRecommendationAccount, String directRecommendationAccount,
			Date gmtCreateBegin, Date gmtCreateEnd, @RequestParam(defaultValue = Constants.PAGENUM) int pageNum,
			@RequestParam(defaultValue = Constants.MAXPAGESIZE) int pageSize, HttpServletRequest request,
			HttpServletResponse response) {
		Page<CustomerRecommandVO> page = userManager.getCustomerRecommandVOList(account, realName, whetherGetMoney,
				refereeQualification, indirectRecommendationAccount, directRecommendationAccount, gmtCreateBegin,
				gmtCreateEnd, pageNum, pageSize);
		List<CustomerRecommandVO> userTradeVOList = page.getlist();
		String[] fieldNames = { "account", "realName", "contactPhone", "sexName", "gmtCreate", "whetherRealName",
				"wheatherGetMoney", "sumMoney", "refereeQualification", "email", "agentName",
				"directRecommendationAccount", "indirectRecommendationAccount" };
		String[] fieldRealNames = { "注册账号", "真实姓名", "联系方式", "性别", "注册日期", "是否实名", "是否入金", "入金金额", "推荐人资质", "邮箱地址",
				"负责代理商", "直推人账号", "间推人账号" };
		String sheetName = "客户推荐表";
		String downLoadFileName = "客户推荐表";
		try {
			ExcelUtils.writeExcel2OutputStream(request, response, userTradeVOList, fieldNames, fieldRealNames,
					downLoadFileName, sheetName);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.errorReponse("导出excel错误");
		}
		return Result.normalResponse();
	}

	/**发送验证邮件
	 * 
	 * @param  email   邮箱号|string|必填
	 * @Title sendcheckEmail
	 * @respbody 
	 * @author cy
	 * @Description 发送验证邮件
	 * @date 2018/1/25 22:15
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/sendcheckEmail")
	public Result sendcheckEmail(@RequestParam(required = true) String email) {
		if (!DataFormatVaildate.vaildEmail(email)) {
			return Result.errorReponse("邮箱格式不正确");
		}

		String content = sendEmailManager.sendEmail(email);
		Boolean result = MailUtil.send(SMTP, FROM, TO, SUBJECT + email, content, USERNAME, PASSWORD);
		if (result) {
			return Result.normalResponse();
		} else {
			return Result.errorReponse("发送邮件失败");
		}

	}

	/**点击链接验证邮件
	 * 
	 * @param  email   邮箱号|string|必填
	 * @Title  checkEmail
	 * @respbody 
	 * @author cy
	 * @Description 点击链接验证邮件
	 * @date 2018/1/25 22:15
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/checkEmail")
	public Result checkEmail(@RequestParam(required = true) String code) {
		boolean result = sendEmailManager.checkEmail(code);
		if (result) {
			return Result.normalResponse("邮箱验证成功");
		} else {
			return Result.normalResponse("邮箱验证失败");
		}

	}

	/**获取图片展示
	 * 
	 * @param  path   图片路径|string|必填
	 * @Title  getpic
	 * @respbody 
	 * @author cy
	 * @Description 获取图片展示
	 * @date 2018/1/27 22:15
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "user/getpic")
	public void getpic(@RequestParam(required = true) String path, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedInputStream bufferedInputStream = null;
		OutputStream outputStream = null;
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			FileInputStream fileInputStream = new FileInputStream(new File(path));
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte[] buffer = new byte[1024];
			response.reset();
			response.setCharacterEncoding("UTF-8");
			// 不同类型的文件对应不同的MIME类型
			response.setContentType("image/png");
			response.setContentLength(bufferedInputStream.available());
			outputStream = response.getOutputStream();
			int n;
			while ((n = bufferedInputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, n);
			}
			outputStream.flush();
		} catch (Exception e) {
			LOGGER.error("获取图片出错", e);
			throw new RuntimeException("获取图片出错");
		} finally {
			try {
				if (null != bufferedInputStream) {
					bufferedInputStream.close();
				}
				if (null != outputStream) {
					outputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error("获取图片出错", e);
				throw new RuntimeException("获取图片出错");
			}
		}
	}

}
