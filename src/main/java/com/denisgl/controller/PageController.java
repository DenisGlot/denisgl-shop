package com.denisgl.controller;


import com.denisgl.dto.ICategory;
import com.denisgl.filter.CategoryFilter;
import com.denisgl.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private ICatalogService catalogService;

    @RequestMapping(value = {"/", "/home", "/index"})
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home page");
        mv.addObject("jsActiveMenu", "home");
        mv.addObject("userClickHome", true);

        CategoryFilter filter = new CategoryFilter();
        List<ICategory> categories = catalogService.getCategories(filter);
        mv.addObject("categories", categories);
        return mv;
    }

    @RequestMapping(value = "about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("jsActiveMenu", "about");
        mv.addObject("userClickAbout", true);

        CategoryFilter filter = new CategoryFilter();
        List<ICategory> categories = catalogService.getCategories(filter);
        mv.addObject("categories", categories);

        return mv;
    }

    @RequestMapping(value = "contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("jsActiveMenu", "contact");
        mv.addObject("userClickContact", true);

        CategoryFilter filter = new CategoryFilter();
        List<ICategory> categories = catalogService.getCategories(filter);
        mv.addObject("categories", categories);
        return mv;
    }

    @RequestMapping(value = "category/{id}")
    public ModelAndView categoryProducts(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView("page");
        ICategory category = catalogService.getCategory(id);

        mv.addObject("jsActiveMenu", category.getName());
        mv.addObject("userClickListProducts", true);
        mv.addObject("userClickCategoryProducts", true);
        mv.addObject("category", category);
        mv.addObject("title", category.getName());

        CategoryFilter filter = new CategoryFilter();
        List<ICategory> categories = catalogService.getCategories(filter);
        mv.addObject("categories", categories);

        return mv;
    }
}
