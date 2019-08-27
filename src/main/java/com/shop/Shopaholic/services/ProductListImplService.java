package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductListImplService implements ProductsService {

    ProductRepository productRepository;

    @Autowired
    public ProductListImplService(ProductRepository productRepository) {
         this.productRepository = productRepository;
    }

    @Override
    public List<ProductsEntity> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(ProductsEntity productsEntity)
    {
        LocalDate now = LocalDate.now();
        productsEntity.setProductCreationDate(now);
        productRepository.save(productsEntity);
    }
}
