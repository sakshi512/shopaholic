package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void addProductToCart(OrderEntity objOrderEntity)
    {
        OrderEntity objC =  orderRepository.findCartProduct(objOrderEntity.getProductId(), objOrderEntity.getUserId(),objOrderEntity.getStatus());
        if(objC != null)
        {
            orderRepository.save(objC);
            //System.out.println("Cart updated: "+objC.getId());
        }else{
            orderRepository.save(objOrderEntity);
           // System.out.println("New Cart: ");
        }
    }
}
