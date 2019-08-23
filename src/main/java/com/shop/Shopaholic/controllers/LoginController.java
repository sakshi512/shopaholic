package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String getLoginForm(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "loginForm";
    }

    @PostMapping("/loginUser")
    public String loginUser(@ModelAttribute("user") UserEntity loginUser)
    {
        if(loginService.validateUser(loginUser))
            return "loginSuccessPage";
        else
            return "redirect:login";
    }

}
