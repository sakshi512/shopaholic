package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.entities.UserEntity;

import java.util.List;


public interface AdminProductService
{
    public List<CategoryEntity> findAllProductCategories();



}
