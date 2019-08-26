package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.SignupService;
import com.shop.Shopaholic.utilities.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SignUpController
{
    @Autowired
    private SignupService signupService;

//    public SignUpController(SignupService signupService) {
//        this.signupService = signupService;
//    }

    @GetMapping("/signup")
    public String signupUser(Model model)
    {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String welcomeUser(@ModelAttribute("user") UserEntity user) throws Exception{
        try {
            signupService.addUser(user);
            System.out.println("in Welcome");

        }
        catch (Exception e)
        {
            System.out.println(ErrorCodes.SIGN_UP_CONTROLLER.getErrorDescription());
        }
        //return "redirect:userprofile";
        return "redirect:index";
    }
}
