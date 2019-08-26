package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.services.ProductListImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes("loggedInUserId")
public class IndexController {

    ProductListImplService productListImplService ;

    @Autowired
    public IndexController(ProductListImplService productListImplService) {
        this.productListImplService = productListImplService;
    }

     @GetMapping("/index")
     public String getHomePage(Model model) {
        model.addAttribute("products",productListImplService.findAllProducts());
        if(!model.containsAttribute("loggedInUserId"))
            model.addAttribute("loggedInUserId", null);
        return "index";
     }


//    @GetMapping("/showProductList")
//    public List<ProductsEntity> findAll() {
//    return productListImplService.findAllProducts();

//}



}
