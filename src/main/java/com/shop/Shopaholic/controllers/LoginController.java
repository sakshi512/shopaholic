package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    public String doUserLogin(@ModelAttribute("user") LoginEntity user, HttpSession httpSession, ModelMap modelMap) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Optional<UserEntity> validUser = loginService.validateUser(user);
        if(!validUser.isPresent()){
            modelMap.addAttribute("errorMsg","Invalid Credentials!! Kindly check username/password");
            return "redirect:login";
        }

        UserEntity loggedInUser = validUser.get();

        if(loginService.isAdminUser(loggedInUser.getRoleId())){
            httpSession.setAttribute("admin",loggedInUser);
            return "redirect:admin";
        } else {
            httpSession.setAttribute("user",loggedInUser);
            return "redirect:index";
        }

    }

    @GetMapping("/admin")
    public String getAdminHomePage(){
        return "admin";
    }

    @GetMapping("/logout")
    public String doUserLogout(HttpSession httpSession){
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "redirect:index";
    }

}
