package com.denisgl.controller;


import com.denisgl.dto.ICategory;
import com.denisgl.dto.IProduct;
import com.denisgl.dtoimpl.HibernateProduct;
import com.denisgl.exception.CategoryNotFoundException;
import com.denisgl.exception.ProductNotFoundException;
import com.denisgl.filter.CategoryFilter;
import com.denisgl.service.ICatalogService;
import com.denisgl.util.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    public static final Logger LOG = LoggerFactory.getLogger(PageController.class);

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

        List<ICategory> categories = catalogService.getCategories();
        mv.addObject("categories", categories);

        return mv;
    }

    @RequestMapping(value = "contact")
    public ModelAndView contact() {
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("jsActiveMenu", "contact");
        mv.addObject("userClickContact", true);

        List<ICategory> categories = catalogService.getCategories();
        mv.addObject("categories", categories);
        return mv;
    }

    @RequestMapping(value = "category/{id}")
    public ModelAndView categoryProducts(@PathVariable("id") String id) throws CategoryNotFoundException {
        ModelAndView mv = new ModelAndView("page");

        int parsedId = NumberUtils.parsePositiveStringNumber(id);
        if (parsedId == -1) throw new CategoryNotFoundException();

        ICategory category = catalogService.getCategory(parsedId);

        if (category == null) throw new CategoryNotFoundException();

        mv.addObject("jsActiveMenu", category.getName());
        mv.addObject("userClickListProducts", true);
        mv.addObject("userClickCategoryProducts", true);
        mv.addObject("category", category);
        mv.addObject("title", category.getName());

        List<ICategory> categories = catalogService.getCategories();
        mv.addObject("categories", categories);

        return mv;
    }

    @RequestMapping(value = "product/{id}")
    public ModelAndView product(@PathVariable("id") String id) throws ProductNotFoundException {
        ModelAndView mv = new ModelAndView("page");

        int parsedId = NumberUtils.parsePositiveStringNumber(id);
        if (parsedId == -1) throw new ProductNotFoundException();

        IProduct product = catalogService.getProduct(parsedId);

        if (product == null) throw new ProductNotFoundException();

        mv.addObject("userClickProduct", true);
        mv.addObject("product", product);
        mv.addObject("title", product.getName());

        ((HibernateProduct) product).setViews(product.getViews() + 1);
        catalogService.saveProduct(product);

        LOG.info("product " + product.getName() + " with id = " + product.getId());

        return mv;
    }
}
