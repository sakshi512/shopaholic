package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    OrderService orderService;


    @GetMapping("/cart")
    public String cart(Model model, HttpSession httpSession)
    {
       // if (httpSession == null) {
       //     return "redirect:index";
        //}
        model.addAttribute("cartItems",orderService.findAllCartItem());

        return "cart";

    }
}
