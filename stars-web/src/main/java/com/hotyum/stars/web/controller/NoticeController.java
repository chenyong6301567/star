package com.hotyum.stars.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.NoticeManager;
import com.hotyum.stars.biz.model.NoticeVO;
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
	private NoticeManager registerNoticeManager;

	/**
	 * 获取我通知的数目
	 * 
	 * @Title getMyNoticeCount
	 * @respbody {"code":1,"message":"成功","data":1,"error":false,"success":true}
	 * @author cy
	 * @Description 获取我通知的数目
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "notice/getMyNoticeCount")
	public Result getMyNoticeCount(HttpServletRequest request) {
		Integer userId = TokenAccessUtils.getLoginUserId(request);
		long count = registerNoticeManager.getMyNoticeCount(userId);
		return Result.normalResponse(count);

	}

	/**
	 * 获取通知列表(包括注册和系统通知)
	 * 
	 * @Title getRegisterNotice
	 * @respbody {"code":1,"message":"成功","data":[{"id":1,"noticeContent":"测试通知11111111111111111","gmtCreate":"2018-01-07 22:39:05"}],"error":false,"success":true}
	 * @author cy
	 * @Description 获取我的通知
	 * @date 2018/1/1 13:49
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "notice/getNoticeList")
	public Result getNoticeList(HttpServletRequest request) {
		Integer userId = TokenAccessUtils.getLoginUserId(request);
		List<NoticeVO> noticeVOList = registerNoticeManager.getNoticeByUserId(userId);
		return Result.normalResponse(noticeVOList);

	}

}
