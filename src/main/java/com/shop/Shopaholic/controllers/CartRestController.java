package com.shop.Shopaholic.controllers;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.repository.OrderRepository;
import com.shop.Shopaholic.services.OrderService;
import com.shop.Shopaholic.utilities.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CartRestController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/api/addCart")
    public String addProductToCart(@RequestParam String productId,@RequestParam String userId, @RequestParam Integer qty, @RequestParam Float price) throws Exception
    {

       try {
           OrderEntity orderObj = new OrderEntity();

           Float totalPrice = qty * price;
           String status = "In-Cart";
           //check if product already exist
           // done checking
           //OrderEntity obj1 =

           // select * from orders where o_p_id = productId and o_su_id = userId and status = 'In_car'

           orderObj.setProductId(Integer.parseInt(productId));
           orderObj.setUserId(Integer.parseInt(userId));
           orderObj.setTotalPrice(totalPrice);
           orderObj.setOrderQty(qty);
           orderObj.setStatus(status);

           //orderRepository.save(orderObj);
           orderService.addProductToCart(orderObj);


       }catch (Exception e)
       {
           System.out.println(ErrorCodes.CART_CONTROLLER.getErrorDescription());
       }
        return "Product:" + productId + " User:" + userId;
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
