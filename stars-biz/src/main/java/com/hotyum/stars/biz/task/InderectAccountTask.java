package com.hotyum.stars.biz.task;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hotyum.stars.biz.manager.UserManager;
import com.hotyum.stars.dal.model.User;

@Component
public class InderectAccountTask {

	@Autowired
	private UserManager userManager;

	private static final Logger LOGGER = LoggerFactory.getLogger(InderectAccountTask.class);

	@Scheduled(cron = "0 0 2 * * ? ")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void InderectAccountTask() {
		// 查询间接推荐人为空的用户列表
		List<User> userList = userManager.getUserListAndInderectIsNullAndDerectIsNotNull();
		for (User user : userList) {
			LOGGER.info("定时更新间接人" + user.getAccount());
			if (StringUtils.isNotEmpty(user.getDirectRecommendationAccount())) {
				User derectUser = userManager.getUserByPhone(user.getDirectRecommendationAccount());
				if (null != derectUser) {
					user.setIndirectRecommendationAccount(user.getDirectRecommendationAccount());
					userManager.updateUserInfo(user);
				}
			}
		}

	}

}
