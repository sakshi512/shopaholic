package com.shop.Shopaholic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
public String getHomePage()
{
   return "index" ;
}

}
