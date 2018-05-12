package com.denisgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("greeting", "Welcome to spring mvc");
        return modelAndView;
    }
}
