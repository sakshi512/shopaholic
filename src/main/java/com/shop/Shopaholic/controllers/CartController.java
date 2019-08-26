package com.shop.Shopaholic.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CartController {

    @RequestMapping(value = "/api/addCart")
    public String addProductToCart(@RequestParam String productId,@RequestParam String userId)
    {
        // add product to cartTable
        return "Product:"+productId+" User:"+userId;
    }
}
