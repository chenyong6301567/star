package com.hotyum.stars.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotyum.stars.biz.manager.SysNoticeManager;
import com.hotyum.stars.biz.model.SysNoticeVO;
import com.hotyum.stars.web.model.Result;

/**
* 系统通知
* 
* @Title: 系统通知  
* @Description: 系统通知      
* @author cy
* @date 2018年1月4日 下午13:43:29 
*/
@RestController
public class SysNoticeController {

	@Autowired
	private SysNoticeManager sysNoticeManager;

	/**
	 * 系统公告发布
	 * 
	 * @param toType          发送给谁: 1代理商 2客户 3管理员;4全部|byte|必填
	 * @param sysType         通知类型: 1:系统内通知；2短信通知;3 全部|byte|必填
	 * @param noticeContent   通知内容|String|必填
	 * @Title 
	 * @respbody 
	 * @author cy
	 * @Description  系统公告发布
	 * @date 2018/1/4 15:55
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "sysNotice/sendNotice")
	public Result sendNotice(@RequestParam(required = true) Byte toType, @RequestParam(required = true) Byte sysType,
			@RequestParam(required = true) String noticeContent) {
		sysNoticeManager.sendNotice(toType, sysType, noticeContent);
		return Result.normalResponse();
	}

	/**
	 * 已经发布的系统公告列表
	 * 
	 * @Title 
	 * @respbody {"code":1,"message":"成功","data":[{"id":1,"toType":4,"sysType":3,"noticeContent":"测试通知11111111111111111","gmtCreate":"2018-01-07 22:07:11"}],"error":false,"success":true}
	 * @author cy
	 * @Description  已经发布的系统公告列表
	 * @date 2018/1/4 15:55
	 * @return Result
	 * @throws  
	 */
	@RequestMapping(value = "sysNotice/getSysNoticeList")
	public Result getSysNoticeList() {
		List<SysNoticeVO> sysNoticeVOList = sysNoticeManager.getSysNoticeList();
		return Result.normalResponse(sysNoticeVOList);
	}

}
