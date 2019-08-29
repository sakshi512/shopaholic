package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.OrderService;
import com.shop.Shopaholic.services.ProductListImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@SessionAttributes({"loggedInUserId", "user"})
public class IndexController {

    ProductListImplService productListImplService ;
    OrderService orderService;

    @Autowired
    public IndexController(ProductListImplService productListImplService, OrderService orderService) {
        this.productListImplService = productListImplService;
        this.orderService = orderService;
    }

    private static String UPLOADED_FOLDER = System.getProperty("user.home")+ "/ShopaholicProductImages/";
//    @Autowired
//    public IndexController(ProductListImplService productListImplService, ) {
//        this.productListImplService = productListImplService;
//    }

     @GetMapping("/index")
     public String getHomePage(Model model, HttpSession httpSession) {
        model.addAttribute("products",productListImplService.findAllProducts());
        model.addAttribute("imagepath", UPLOADED_FOLDER);
        // get cart count
         UserEntity loggedInUser = (UserEntity) httpSession.getAttribute("user");
         if(loggedInUser != null)
         {
             //System.out.println("Total Item: "+orderService.countUserCart(loggedInUser.getId()));
             model.addAttribute("totalCartItem",orderService.countUserCart(loggedInUser.getId()));
         }
         else
             {
             model.addAttribute("totalCartItem",0);
         }

         return "index";

     }

//    @GetMapping("/showProductList")
//    public List<ProductsEntity> findAll() {
//    return productListImplService.findAllProducts();

//}



}
