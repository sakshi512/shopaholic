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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SignUpController
{
    @Autowired
    private SignupService signupService;

    @GetMapping("/signup")
    public String signupUser(Model model)
    {
        UserEntity user = new UserEntity();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String welcomeUser(@ModelAttribute("user") UserEntity user, HttpSession httpSession, RedirectAttributes attributes) throws Exception{
        try {
            signupService.addUser(user);
            httpSession.setAttribute("user",user);
        }
        catch (Exception e)
        {
            System.out.println(ErrorCodes.SIGN_UP_CONTROLLER_INVALID_INPUT.getErrorDescription());
            attributes.addFlashAttribute("errorMsg",ErrorCodes.SIGN_UP_CONTROLLER_INVALID_INPUT.getErrorDescription());
            return "redirect:signup";
        }
        return "redirect:index";
    }
}
