package com.denisgl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Home page");
        modelAndView.addObject("jsActiveMenu", "home");
        modelAndView.addObject("userClickHome", true);
        return modelAndView;
    }

    @RequestMapping(value = "about")
    public ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "About Us");
        modelAndView.addObject("jsActiveMenu", "about");
        modelAndView.addObject("userClickAbout", true);
        return modelAndView;
    }

    @RequestMapping(value = "contact")
    public ModelAndView contact() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Contact Us");
        modelAndView.addObject("jsActiveMenu", "contact");
        modelAndView.addObject("userClickContact", true);
        return modelAndView;
    }

    @RequestMapping(value = "listProducts")
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("title", "Products List");
        modelAndView.addObject("jsActiveMenu", "listProducts");
        modelAndView.addObject("userClickListProducts", true);
        return modelAndView;
    }
}
