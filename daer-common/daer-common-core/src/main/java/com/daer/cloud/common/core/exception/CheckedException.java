package com.daer.cloud.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author liuwei
 * @date 2019-11-11
 */
@NoArgsConstructor
public class CheckedException extends RuntimeException {

	private static final long serialVersionUID = 8078261738440781578L;

	public CheckedException(String message) {
		super(message);
	}

	public CheckedException(Throwable cause) {
		super(cause);
	}

	public CheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
