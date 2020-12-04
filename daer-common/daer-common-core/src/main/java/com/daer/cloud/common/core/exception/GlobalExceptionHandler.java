package com.daer.cloud.common.core.exception;

import com.daer.cloud.common.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-11
 * 全局的的异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 全局异常.
	 *
	 * @param e the e
	 * @return Result
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result exception(Exception e) {
		log.error("全局异常信息 ex={}", e.getMessage(), e);
		return Result.failed(e);
	}

	/**
	 * validation Exception
	 *
	 * @param exception
	 * @return Result
	 */
	@ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		log.warn(fieldErrors.get(0).getDefaultMessage());
		return Result.failed(fieldErrors.get(0).getDefaultMessage());
	}

}
