package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.services.ProductListImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.Shopaholic.entities.ProductsEntity;

import java.io.IOException;
import java.util.List;

@RestController
public class IndexController {


    ProductListImplService productListImplService ;


    @Autowired
    public IndexController(ProductListImplService productListImplService) {
        this.productListImplService = productListImplService;
    }
    //  @GetMapping("/index")
//public String getHomePage(Model model) {
//    model.addAttribute("products",productList.findAllProducts());
//    System.out.println(productList.findAllProducts());
//    return "index";
  //  }


    @GetMapping("/showProductList")
    public List<ProductsEntity> findAll() {
    return productListImplService.findAllProducts();

}



}
