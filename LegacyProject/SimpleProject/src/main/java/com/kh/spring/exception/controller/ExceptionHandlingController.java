package com.kh.spring.exception.controller;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.exception.AuthorizationException;
import com.kh.spring.exception.InvalidParameterException;
import com.kh.spring.exception.TooLargeValueException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {
	
	private ModelAndView createErrorResponse(RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage()).setViewName("include/error_page");
		return mv;		
	}
	
	@ExceptionHandler(TooLargeValueException.class)
	protected ModelAndView tooLargeValueException(TooLargeValueException e) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", e.getMessage()).setViewName("include/error_page");
//		return mv;
		return createErrorResponse(e);
	}
	
	@ExceptionHandler(InvalidParameterException.class)
	protected ModelAndView invalidParameterError(InvalidParameterException e) {
//		log.info("{}", e.getMessage());
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", e.getMessage()).setViewName("include/error_page");
//		return mv;
		return createErrorResponse(e);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	protected ModelAndView AuthorizationException(AuthorizationException e) {
//		log.info("{}", e.getMessage());
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", e.getMessage()).setViewName("include/error_page");
//		return mv;
		return createErrorResponse(e);
	}
	
}
