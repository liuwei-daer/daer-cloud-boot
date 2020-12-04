package com.daer.cloud.common.core.util;

import com.daer.cloud.common.core.constant.CommonConstants;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * @author liuwei
 * @date 2019-11-11
 * 响应信息主体
 *
 * @param <T>
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private boolean success = true;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private T data;

	public static <T> Result<T> ok() {
		return restResult(null,true, CommonConstants.SUCCESS, null);
	}

	public static <T> Result<T> ok(T data) {
		return restResult(data, true, CommonConstants.SUCCESS, null);
	}

	public static <T> Result<T> ok(T data, String message) {
		return restResult(data, true, CommonConstants.SUCCESS, message);
	}

	public static <T> Result<T> failed() {
		return restResult(null, false, CommonConstants.FAIL, null);
	}

	public static <T> Result<T> failed(String message) {
		return restResult(null, false, CommonConstants.FAIL, message);
	}

	public static <T> Result<T> failed(T data) {
		return restResult(data, false, CommonConstants.FAIL, null);
	}

	public static <T> Result<T> failed(T data, String message) {
		return restResult(data, false, CommonConstants.FAIL, message);
	}

	private static <T> Result<T> restResult(T data, boolean flag,int code, String message) {
		Result<T> result = new Result<>();
		result.setSuccess(flag);
		result.setCode(code);
		result.setData(data);
		result.setMessage(message);
		return result;
	}
}

