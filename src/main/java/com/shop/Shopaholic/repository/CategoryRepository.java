package com.shop.Shopaholic.repository;

import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}