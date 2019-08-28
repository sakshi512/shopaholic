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
import java.io.File;
import javax.servlet.http.HttpSession;

@Controller
public class AdminProductController {
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
    public String addProduct(@ModelAttribute("productItem") ProductsEntity productsEntity) throws Exception {
        try
        {

//            File file=new File(productsEntity.getProductImage());
//            File renamedFile=new File("file.jpg");
//            //System.out.println("Image"+productsEntity.getProductImage());
//            file.renameTo(renamedFile);
//            productsEntity.setProductImage(file);
            productsService.addProduct(productsEntity);
//            httpSession.setAttribute("user",user);
//            httpSession.setAttribute("loggedInUserId",user.getId());

        }
        catch (Exception e)
        {
            System.out.println(ErrorCodes.SIGN_UP_CONTROLLER_INVALID_INPUT.getErrorDescription());
        }
        return "redirect:Success";
    }
}
