package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Query("FROM OrderEntity WHERE productId = ?1 AND userId=?2 AND o_status=?3")
    OrderEntity findCartProduct(Integer productId, Integer userId, String status);

    @Query("FROM OrderEntity WHERE userId=?1")
    List<OrderEntity> userCartCount(Integer userId);


}
