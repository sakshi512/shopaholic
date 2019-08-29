package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.entities.UserEntity;
import com.shop.Shopaholic.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public String addProductToCart(OrderEntity objOrderEntity)
    {
        String msg;
        OrderEntity objC =  orderRepository.findCartProduct(objOrderEntity.getProductId(), objOrderEntity.getUserId(),objOrderEntity.getStatus());
        if(objC != null)
        {
            //orderRepository.save(objC);
            msg ="F";
        }else{
            msg ="S";
            orderRepository.save(objOrderEntity);
        }
        return msg;
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

    public double findCartTotal(Integer userId) {
        Double totalPrice;
        totalPrice = orderRepository.getCartTotal(userId);
        return totalPrice;
    }

    public void updateOrderStatusAndDate(String status, Date date, Integer userId) {
        orderRepository.updateOrderStatusAndDate(status,date,userId);
    }

    public List<OrderEntity> findCartItemWithUser(Integer userId) {
        return orderRepository.findCartItemWithUser(userId);
    }

//    public void updateOrderDate(String status, Integer userId, Date date) {
//        orderRepository.updateOrderDate(status,userId,date);
//    }
}
