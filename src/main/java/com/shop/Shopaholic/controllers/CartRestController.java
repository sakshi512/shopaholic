package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.repository.OrderRepository;
import com.shop.Shopaholic.services.OrderService;
import com.shop.Shopaholic.services.ProductListImplService;
import com.shop.Shopaholic.utilities.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class CartRestController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductListImplService productListImplService;

    @RequestMapping(value = "/api/addCart")
    public String addProductToCart(@RequestParam String productId,@RequestParam String userId, @RequestParam Integer qty, @RequestParam Float price) throws Exception
    {

        String result="";
        try {

            Optional<ProductsEntity> productsEntity = productListImplService.findProductbyId(Integer.parseInt(productId));

           OrderEntity orderObj = new OrderEntity();

           //Float totalPrice = qty * price;
           Float totalPrice = price;
           String status = "In-Cart";

           orderObj.setProductId(Integer.parseInt(productId));
           orderObj.setUserId(Integer.parseInt(userId));
           orderObj.setTotalPrice(totalPrice);
           orderObj.setOrderQty(qty);
           orderObj.setStatus(status);
           orderObj.setProductName(productsEntity.get().getProductName());


          result = orderService.addProductToCart(orderObj);


       }catch (Exception e)
       {
           System.out.println(ErrorCodes.CART_CONTROLLER.getErrorDescription());
       }
        //return "Product:" + productId + " User:" + userId;
       return  result;
    }

    @RequestMapping(value = "/api/delCart")
    public String deleteCart(@RequestParam String cartId)
    {
        String msg;
        try {
            orderService.deleteCartItem(Integer.parseInt(cartId));
            msg= "Success";
        }catch (Exception e)
        {
            System.out.println(ErrorCodes.CART_CONTROLLER.getErrorDescription());
        }
        return msg= "Error";
    }
}
