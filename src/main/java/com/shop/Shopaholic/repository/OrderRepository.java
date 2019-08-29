package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.OrderEntity;
import com.shop.Shopaholic.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Query("FROM OrderEntity WHERE productId = ?1 AND userId=?2 AND o_status=?3")
    OrderEntity findCartProduct(Integer productId, Integer userId, String status);

    @Query("FROM OrderEntity WHERE userId=?1")
    List<OrderEntity> userCartCount(Integer userId);

    @Query("SELECT SUM (totalPrice) FROM OrderEntity WHERE userId=?1")
    Double getCartTotal(Integer userId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE OrderEntity SET status =?1,orderDate =?2  WHERE userId=?3")
    void updateOrderStatusAndDate(String status,Date date,Integer userId);

    @Query("FROM OrderEntity WHERE userId=?1")
    List<OrderEntity> findCartItemWithUser(Integer userId);

//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("UPDATE OrderEntity SET orderDate =?1 WHERE userId=?2 AND status =?3")
//    orderRepository.updateOrderDate(date,status,userId);
}
