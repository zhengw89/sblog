package com.sblog.web.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(Exception e)   {
            ModelAndView mv = new ModelAndView("404");
            mv.addObject("exception", e);  
            return mv;
    }
	
//	@ExceptionHandler(Exception.class)
//	public ModelAndView handleError500(Exception e) {
//		ModelAndView mv = new ModelAndView("500");
//		mv.addObject("ex", e);
//		return mv;
//	}
}
