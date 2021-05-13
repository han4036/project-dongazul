package com.dongazul.myapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor

@ControllerAdvice
public class CommonExceptionHandler {
	// 어떤 컨트롤러 메소드에서든, 지정된 예외(여기서는, BindExcption)가 발생하면,
	// 이 메소드가 예외처리 메소드로 동작한다고 지정하는 어노테이션이 @ExceptionHandler임!!
	
		@ExceptionHandler(Exception.class)
		public String Exception(Exception e, Model model) {
			log.debug("Exception() invoked.");
			
			log.error("1. Exception Type: " + e.getClass().getName());
			log.error("2. Exception Message: " + e.getMessage());
			model.addAttribute("EXCEPTION", e);  
			
			return "/error/404Page";
		
	} // NoHandlerFoundException
	
} // end class
