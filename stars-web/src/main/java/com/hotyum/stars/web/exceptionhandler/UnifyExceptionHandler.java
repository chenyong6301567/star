package com.hotyum.stars.web.exceptionhandler;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotyum.stars.web.model.Result;

@ControllerAdvice
public class UnifyExceptionHandler {

	/**
	 * 捕获Controller层抛出的所有的校验参数异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseBody
	public Result handleBizExp(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		StringBuilder strBuilder = new StringBuilder();
		for (ConstraintViolation<?> violation : violations) {
			strBuilder.append(violation.getMessage() + ",");
		}
		return Result.errorReponse(strBuilder.toString());
	}

}
