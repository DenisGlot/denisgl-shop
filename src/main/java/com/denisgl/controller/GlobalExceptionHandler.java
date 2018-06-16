package com.denisgl.controller;

import com.denisgl.exception.CategoryNotFoundException;
import com.denisgl.exception.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handlerNoHandlerFoundException() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "The page is not constructed!");
        mv.addObject("errorDescription", "The page you are looking for is not available now!");
        mv.addObject("title", "404 Error page");

        return mv;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handlerProductNotFoundException() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "Product doesn't exist anymore!");
        mv.addObject("errorDescription", "The product you are looking for are not available!");
        mv.addObject("title", "Product is unavailable!");

        return mv;
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ModelAndView handlerCategoryNotFoundException() {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errorTitle", "Category doesn't exist anymore!");
        mv.addObject("errorDescription", "The category you are looking for are not available!");
        mv.addObject("title", "Category is unavailable!");

        return mv;
    }

}
