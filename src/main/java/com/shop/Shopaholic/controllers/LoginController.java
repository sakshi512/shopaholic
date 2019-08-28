package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.LoginEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.LoginService;
import com.shop.Shopaholic.utilities.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String doUserLogin(@ModelAttribute("user") LoginEntity user, HttpSession httpSession, RedirectAttributes attributes) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Optional<UserEntity> validUser = loginService.validateUser(user);
        if(!validUser.isPresent()){
            attributes.addFlashAttribute("errorMsg", ErrorCodes.INVALID_CREDENTIALS.getErrorDescription());
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

    @GetMapping("/logout")
    public String doUserLogout(HttpSession httpSession){
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "redirect:index";
    }

}
