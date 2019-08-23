package com.shop.Shopaholic.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="shopaholic_user")
public class UserEntity
{
    @Id
    @Column(name="su_id")
    private int Id;

    @Column(name="su_email")
    private  String email;

    @Column(name="su_firstname")
    private String firstName;

    @Column(name="su_lastname")
    private String lastName;

    @Column(name="su_addressline1")
    private String addressLine1;

    @Column(name="su_addressline2")
    private String addressLine2;

    @Column(name="su_city")
    private String city;

    @Column(name="su_pin")
    private int pin;

    @Column(name="su_phone")
    private String phone;

    @Column(name="su_password")
    private String password;

    @Column(name="su_dob")
    private Date dob;

    @Column(name="su_creationdate")
    private Date creationDate;

//    @Column(name="su_status")
//    private String status;

    // foreign key cons
    @Column(name="su_role")
    private int roleId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
