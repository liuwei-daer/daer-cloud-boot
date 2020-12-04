package com.daer.cloud.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author liuwei
 * @date 2019-11-11
 * 403 授权拒绝
 */
@NoArgsConstructor
public class CustDeniedException extends RuntimeException {

	private static final long serialVersionUID = -3659850694312618787L;

	public CustDeniedException(String message) {
		super(message);
	}

	public CustDeniedException(Throwable cause) {
		super(cause);
	}

	public CustDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
