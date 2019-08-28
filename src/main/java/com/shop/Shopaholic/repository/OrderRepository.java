package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Query("FROM OrderEntity WHERE productId = ?1 AND userId=?2 AND o_status=?3")
    OrderEntity findCartProduct(Integer productId, Integer userId, String status);
}
