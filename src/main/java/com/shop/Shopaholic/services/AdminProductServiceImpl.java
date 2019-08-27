package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.entities.ProductsEntity;
import com.shop.Shopaholic.repository.CategoryRepository;
import com.shop.Shopaholic.repository.ProductRepository;
import com.shop.Shopaholic.utilities.Password;
import com.shop.Shopaholic.utilities.RoleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    CategoryRepository categoryRepository;

    @Autowired
    public AdminProductServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> findAllProductCategories()
    {
        return categoryRepository.findAll();
    }


}
