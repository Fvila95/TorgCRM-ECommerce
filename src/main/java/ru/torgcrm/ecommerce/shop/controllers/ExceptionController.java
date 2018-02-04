package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView errorHandler(HttpServletRequest request, Exception e) {
        return new ModelAndView("500");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView pageNotFoundExceptionHandler(HttpServletRequest request, Exception e) {
        return new ModelAndView("404");
    }
}
