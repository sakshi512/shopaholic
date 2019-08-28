package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity,Integer>{

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE ProductsEntity SET productImage =?1 WHERE productId =?2")
    void updateImage(String imageName, int productId);

}





