package com.capitole.technicaltest.infrastructure.interceptor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.capitole.technicaltest.application.dto.ErrorMessageDto;

@ExtendWith(MockitoExtension.class)
public class ExceptionRestInterceptorAdviceTest {
	@Mock
	private Exception exception;

	@Mock
	private MethodArgumentNotValidException methodArgumentNotValidException;

	@InjectMocks
	private ExceptionRestInterceptorAdvice exceptionRestInterceptor;

	@Test
	public void ifValidExceptionClass_ReturnErrorMessage() {
		ResponseEntity<ErrorMessageDto> exeptionResponse = exceptionRestInterceptor.defaultExceptionHandler(exception);
		Assertions.assertNotNull(exeptionResponse);
	}
	
	@Test
	public void ifValidMethodArgumentNotValidException_ReturnErrorMessage() {
		BindingResult error = Mockito.mock(BindingResult.class);
		Mockito.when(methodArgumentNotValidException.getBindingResult()).thenReturn(error);
		Mockito.when(error.getFieldError()).thenReturn(new FieldError("","",""));
		ResponseEntity<ErrorMessageDto> exeptionResponse = exceptionRestInterceptor.methodArgumentNotValidExceptionExceptionHandler(methodArgumentNotValidException);
		Assertions.assertNotNull(exeptionResponse);
	}
	
}
