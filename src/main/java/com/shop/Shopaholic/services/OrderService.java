package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

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
        }else{
            orderRepository.save(objOrderEntity);
        }
    }

    public List<OrderEntity> findAllCartItem() {

        return orderRepository.findAll();
    }

    public void deleteCartItem(Integer cartId)
    {
        orderRepository.deleteById(cartId);
    }

    public Integer countUserCart(Integer userId)
    {
        Integer totalCartItem = 0;
        List<OrderEntity> orderEntityList = orderRepository.userCartCount(userId);
        totalCartItem = orderEntityList.size();
        return totalCartItem;
    }
}
