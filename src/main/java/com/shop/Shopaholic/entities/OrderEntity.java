package com.shop.Shopaholic.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="o_id")
    private int id;

    @Column(name="o_p_id")
    private Integer productId;

    @Column(name="o_su_id")
    private Integer userId;

    @Column(name="o_date")
    private Date orderDate;

    @Column(name="o_qty")
    private Integer orderQty;

    @Column(name="o_totalprice")
    private Float totalPrice;

    @Column(name="o_status")
    private String status;

    @Column(name="p_name")
    private String productName;

    public String getProductName()
    {
        return productName;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
