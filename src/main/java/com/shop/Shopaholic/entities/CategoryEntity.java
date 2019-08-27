package com.shop.Shopaholic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class CategoryEntity
{
    @Id
    @Column(name = "pc_catid")
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
    return categoryName;
}

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "pc_categoryname")
    private String categoryName;
}
