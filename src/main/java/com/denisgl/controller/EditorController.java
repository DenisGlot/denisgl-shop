package com.denisgl.controller;

import com.denisgl.dto.ICategory;
import com.denisgl.dto.IProduct;
import com.denisgl.dtoimpl.HibernateProduct;
import com.denisgl.service.ICatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("editor")
public class EditorController {

    private final static Logger LOG = LoggerFactory.getLogger(EditorController.class);

    @Autowired
    private ICatalogService catalogService;

    @ModelAttribute("categories")
    public List<ICategory>  getCategories() {
        return catalogService.getCategories();
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public ModelAndView editorProducts(@RequestParam(name = "operation", required = false) String operation) {
        ModelAndView mv = new ModelAndView("page");

        mv.addObject("userClickEditorProducts", true);
        mv.addObject("title", "Manage products");

        HibernateProduct product = new HibernateProduct();
        product.setActive(true);
        mv.addObject("product", product);

        if ("product".equals(operation)) {
            mv.addObject("message", "Product was saved successfully");
        }

        return mv;
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") HibernateProduct product) {
        product.setId(0);
        IProduct savedProduct = catalogService.saveProduct(product);

        LOG.info("Product was merged with id = " + savedProduct.getId() + "name = " + savedProduct.getName());

        return "redirect:/editor/product?operation=product";
    }

}
