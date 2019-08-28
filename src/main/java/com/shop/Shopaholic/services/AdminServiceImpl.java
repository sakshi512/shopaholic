package com.shop.Shopaholic.services;

import com.shop.Shopaholic.entities.CategoryEntity;
import com.shop.Shopaholic.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    CategoryRepository categoryRepository;

    @Autowired
    public AdminServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> findAllProductCategories()
    {
        return categoryRepository.findAll();
    }


}
