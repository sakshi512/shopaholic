package com.shop.Shopaholic.entities;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table(name="shopaholic_user")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="su_id")
    private int id;

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
    private Integer pin;

    @Column(name="su_phone")
    private String phone;

    @Column(name="su_password")
    private String password;

    @Column(name="su_dob")
    private LocalDate dob;

    @Column(name="su_creationdate")
    private LocalDate creationDate;

    // foreign key cons
    @Column(name="su_role")
    private int roleId;

    @Email
    @Column(name="su_email")
    private  String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }

    public String getFirstName() {
        System.out.println("in first name getter");
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("in first name setter");
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

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob)
    {

        this.dob = dob;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {

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
