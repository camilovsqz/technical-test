package com.capitole.technicaltest.infrastructure.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capitole.technicaltest.application.constant.ErrorConstant;
import com.capitole.technicaltest.application.dto.ErrorMessageDto;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionRestInterceptorAdvice {
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDto> defaultExceptionHandler(Exception ex) {
        log.error(ErrorConstant.SYSTEM_EXCEPTION, ex);
        var error = new ErrorMessageDto();
        error.setErrorType(ErrorConstant.UNCONTROLLED_EXCEPTION);
        error.setMessage(ErrorConstant.UNCONTROLLED_EXCEPTION_MESSAGE);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessageDto> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        log.error(ErrorConstant.SYSTEM_EXCEPTION, ex);
        var error = new ErrorMessageDto();
        error.setErrorType(ErrorConstant.VALIDATION_EXCEPTION);
        error.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
