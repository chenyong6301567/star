package com.hotyum.stars.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.croky.util.ObjectUtils;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.UserBaseInfoVO;
import com.hotyum.stars.dal.model.User;
import com.hotyum.stars.utils.enums.PicType;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * 获取用户基本信息
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getUserBaseInfo
	 * @respbody 
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
		userManager.updateUserBaseInfo(account, realName, sex, contactPhone, email, whetherRealName, wheatherGetMoney,
				refereeQualification, agentCode, directRecommendationAccount, indirectRecommendationAccount);
		return Result.normalResponse();
	}

	/**
	 * 实名验证
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
		String realPath = request.getServletContext().getRealPath("/upload/certificate/");
		if (file != null) {// 判断上传的文件是否为空
			String fileName = file.getOriginalFilename();// 文件原名称
			String type = fileName.indexOf(".") != -1
					? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
			if (!("GIF".equalsIgnoreCase(type) || "PNG".equalsIgnoreCase(type) || "JPG".equalsIgnoreCase(type))) {
				return Result.errorReponse("不支持[" + type + "]文件上传");
			}
			String trueFileName = account + "." + type;
			String path = realPath + trueFileName;
			LOGGER.info("存放图片文件的路径:" + path);

			File file_ = new File(path);
			if (!file_.exists()) {
				file_.getParentFile().mkdirs();
				file_.createNewFile();
			}
			file.transferTo(file_);
			userManager.updateUsePic(path, picType, account);
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

}
