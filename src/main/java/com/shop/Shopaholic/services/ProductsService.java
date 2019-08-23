package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.ProductsEntity;

import java.util.List;

public interface ProductsService {
    public List<ProductsEntity> findAllProducts();
}
