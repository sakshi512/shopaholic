package com.shop.Shopaholic.controllers;
import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.services.AdminProductService;
import com.shop.Shopaholic.services.ProductsService;
import com.shop.Shopaholic.utilities.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpSession;

@Controller
public class AdminProductController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/Users/anamsami/Desktop/Project/Shopaholic/src/main/resources/static/images/";


///Users/anamsami/Desktop/Project/Shopaholic/src/main/resources/static/images/


    @Autowired
    private AdminProductService adminProductService;

    @Autowired
    private ProductsService productsService;

    @GetMapping("/addproduct")
    public String adminFetchProductCategory(Model model) {

        ProductsEntity productsEntity = new ProductsEntity();
        model.addAttribute("productItem", productsEntity);
        CategoryEntity categoryEntity = new CategoryEntity();
        model.addAttribute("categories", adminProductService.findAllProductCategories());


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

//            String fileName = productsEntity.getProductId()+".jpg";
//
//            byte[] bytes = file.getBytes();
//            System.out.println("File Read");
//
//            //Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
//            Path path = Paths.get(UPLOADED_FOLDER+fileName);
//
//            System.out.println("Path "+path);
//            Files.write(path, bytes);
//
//            productsEntity.setProductImage(fileName);




            productsService.addProduct(productsEntity);
            productsService.saveImageFile(productsEntity,file);

            System.out.println("File uploaded: " + file.getOriginalFilename());

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


        return "redirect:Success";
    }
}
