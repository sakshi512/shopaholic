package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String getLoginForm(Model model){
        LoginEntity user = new LoginEntity();
        model.addAttribute("user", user);
        return "loginForm";
    }

    @PostMapping("/login")
    public String doUserLogin(@ModelAttribute("user") LoginEntity user, HttpSession httpSession)
    {
        Optional<UserEntity> loggedInUser = loginService.validateUser(user);

        if(loggedInUser.isPresent()) {
            httpSession.setAttribute("user",loggedInUser.get());
            httpSession.setAttribute("loggedInUserId",loggedInUser.get().getId());
            return (loggedInUser.get().getRoleId()==2)?"adminLoginSuccess" : "redirect:index";
        } else{
            return "redirect:login";
        }

    }

    @GetMapping("/logout")
    public String doUserLogout(HttpSession httpSession){
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "redirect:index";
    }

}
