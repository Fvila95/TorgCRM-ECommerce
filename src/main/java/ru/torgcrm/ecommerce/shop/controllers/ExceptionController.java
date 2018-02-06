package ru.torgcrm.ecommerce.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.torgcrm.ecommerce.shop.config.RequestDataHolder;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    @Autowired
    RequestDataHolder requestDataHolder;

    @ExceptionHandler(Exception.class)
    public ModelAndView errorHandler(HttpServletRequest request, Exception e) {
        String template = request.getAttribute("template").toString();
        return new ModelAndView(template + "/500");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView pageNotFoundExceptionHandler(HttpServletRequest request, Exception e) {
        String template = request.getAttribute("template").toString();
        return new ModelAndView(template + "/404");
    }
}
