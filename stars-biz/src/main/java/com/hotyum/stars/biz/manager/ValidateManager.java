package com.hotyum.stars.biz.manager;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
* @author limuxian
* @version 创建时间：2017年6月10日 下午1:44:47
* 类说明
*/
public interface ValidateManager {

	public String validateBiz(@NotBlank(message="不能为空")String accountId,@NotEmpty(message="id集合为空")List<String> list);
}
