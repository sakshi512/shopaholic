package com.shop.Shopaholic.controllers;
import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.services.AdminService;
import com.shop.Shopaholic.services.ProductsService;
import com.shop.Shopaholic.utilities.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/addproduct")
    public String adminFetchProductCategory(Model model) {

        ProductsEntity productsEntity = new ProductsEntity();
        model.addAttribute("productItem", productsEntity);
        CategoryEntity categoryEntity = new CategoryEntity();
        model.addAttribute("categories", adminService.findAllProductCategories());
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute("productItem") ProductsEntity productsEntity, @ModelAttribute MultipartFile file) {

        if (file.isEmpty())
        {
            System.out.println("File not uploaded");
            return "redirect:addproduct";
        }

        try {
            productsService.addProduct(productsEntity);
            productsService.saveImageFile(productsEntity,file);
            System.out.println("File uploaded: " + file.getOriginalFilename());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:admin";
    }

    @GetMapping("/admin")
    public String getAdminHomePage(){
        return "admin";
    }


    @GetMapping("/sendMail")
    public String sendMail(RedirectAttributes attributes) throws MessagingException, IOException {
        Email email = new Email();
        email.sendImage();
        attributes.addFlashAttribute("message","Email Sent!!");
        return "redirect:admin";
    }

    @GetMapping("/email")
    public String getEmailPage(){
        return "email_order_summary";
    }
}
