package com.hotyum.stars.web.controller;

import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.croky.util.StringUtils;
import com.hotyum.stars.biz.manager.RegisterNoticeManager;
import com.hotyum.stars.biz.manager.SmsManager;
import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.biz.model.RegisterNoticeVO;
import com.hotyum.stars.biz.model.TokenInfoVO;
import com.hotyum.stars.utils.Assert;
import com.hotyum.stars.utils.Constants;
import com.hotyum.stars.utils.RandomUtil;
import com.hotyum.stars.web.model.Result;
import com.hotyum.stars.web.util.TokenAccessUtils;

/**
* 系统通知
* 
* @Title: 系统通知  
* @Description: 系统通知      
* @author cy
* @date 2018年1月1日 下午13:43:29 
*/
@RestController
public class NoticeController {

	@Autowired
	private RegisterNoticeManager registerNoticeManager;

	/**
	 * 获取我推荐的人注册通知
	 * 
	 * @param a 不用普通参数，带令牌token|string|必填
	 * @Title getRegisterNotice
	 * @respbody 
	 * @author cy
	 * @Description 获取我推荐的人注册通知
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "notice/getRegisterNotice")
	public Result getRegisterNotice(HttpServletRequest request) {
		Integer userId = TokenAccessUtils.getLoginUserId(request);
		List<RegisterNoticeVO> registerNoticeVOList = registerNoticeManager.getRegisterNoticeByUserId(userId);
		return Result.normalResponse(registerNoticeVOList);

	}

}
