package com.shop.Shopaholic.entities;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "product")
public class ProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int productId;

    @Column(name = "p_catid")
    private int productCategoryId;

    @Column(name = "p_name")
    private String productName;git

    @Column(name = "p_description")
    private String productDescription;

    @Column(name = "p_price")
    private double productPrice;

    @Column(name = "p_discount")
    private int productDiscount;

    @Column(name = "p_image")
    private String productImage;

    @Column(name = "p_color")
    private String productColor;

    @Column(name = "p_creationdate")
    private LocalDate productCreationDate;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public LocalDate getProductCreationDate() {
        return productCreationDate;
    }

    public void setProductCreationDate(LocalDate productCreationDate) {
        this.productCreationDate = productCreationDate;
    }






}
