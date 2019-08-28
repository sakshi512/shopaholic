package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.ProductsEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductsService
{
    public List<ProductsEntity> findAllProducts();
    public void addProduct(ProductsEntity productsEntity);
    public void saveImageFile(ProductsEntity productsEntity , MultipartFile imageFile) throws Exception;

}


