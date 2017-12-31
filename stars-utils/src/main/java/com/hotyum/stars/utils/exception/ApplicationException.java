package com.hotyum.stars.utils.exception;

/**
 * @author cy
 * @Description 
 * @date 2017年12月31日下午8:21:07 
 */
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 默认的错误码
	 */
	private static final int ERROR_CODE_DEFAULT = -1;

	/**
	 * 错误码
	 */
	private int errorCode = ERROR_CODE_DEFAULT;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	protected ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
