package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
public class CartController {

    @Autowired
    OrderService orderService;


    @GetMapping("/cart")
    public String cart(Model model, HttpSession httpSession)
    {
        UserEntity loggedInUser = (UserEntity) httpSession.getAttribute("user");
        // if (loggedInUser == null) {
       //     return "redirect:index";
        //}
        model.addAttribute("cartItems",orderService.findAllCartItem());

        return "cart";

    }

    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession httpSession)
    {
        UserEntity loggedInUser = (UserEntity) httpSession.getAttribute("user");
        Date date = Date.valueOf(LocalDate.now());

        System.out.println("LoggedInUser "+loggedInUser.getId()+"Date"+date);
        model.addAttribute("cartItems",orderService.findCartItemWithUser(loggedInUser.getId()));
        model.addAttribute("cartTotal",orderService.findCartTotal(loggedInUser.getId()));
        model.addAttribute("user",loggedInUser);
        System.out.println("Logged In user data:  "+ loggedInUser.getFirstName()+" "+loggedInUser.getLastName());
        String status = "Completed";
        orderService.updateOrderStatusAndDate(status, date,loggedInUser.getId());
       // orderService.updateOrderDate(status,loggedInUser.getId(), date);
        return "checkout";

    }
}
