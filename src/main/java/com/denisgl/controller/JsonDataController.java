package com.denisgl.controller;

import com.denisgl.dto.IProduct;
import com.denisgl.filter.ProductFilter;
import com.denisgl.filter.ProductFilterSQL;
import com.denisgl.service.ICatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("json/data")
public class JsonDataController {

    @Autowired
    private ICatalogService catalogService;

    @RequestMapping("all/products")
    @ResponseBody
    public List<IProduct> getAllProducts() {
        return catalogService.getProducts();
    }

    @RequestMapping("category/{id}")
    @ResponseBody
    public List<IProduct> getAllProductsByCategory(@PathVariable("id") int id) {
        ProductFilterSQL filter = new ProductFilterSQL();
        filter.setCategoryId(id);
        return catalogService.getProducts(filter);
    }

}
