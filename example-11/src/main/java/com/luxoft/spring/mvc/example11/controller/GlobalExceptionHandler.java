package com.luxoft.spring.mvc.example11.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Global exception handler
 */
@ControllerAdvice                               // this annotation binds these methods to all @Controllers
public class GlobalExceptionHandler {

    // TODO: see 'exception.html' and open 'http://localhost:8080/indexEx' in your browser

    @ExceptionHandler(Exception.class)          // this method handles Exception
    public ModelAndView handleNpe(
        Exception e                             // exception object
    ) {
        ModelAndView modelAndView
            = new ModelAndView("exception");    // logical name of 'exception.html' View
        modelAndView.addObject(
            "message", e.getMessage()           // to show exception's message at the page
        );
        return modelAndView;
    }
}
