package com.ExtraShop.Shop.models;

public class Order {
    private int id;
    private int userId;
    private double statusAmount;
    private int statusId;
    private String deliveryAddress;
    private String email;
    private int paymentTypeId;
    private String phone;


public Order(int id, int userId, double statusAmount, int statusId, String deliveryAddress, String email, int paymentTypeId, String phone){
    this.id= id;
    this.userId = userId;
    this.statusAmount = statusAmount;
    this.statusId = statusId;
    this.deliveryAddress = deliveryAddress;
    this.email = email;
    this.paymentTypeId = paymentTypeId;
    this.phone = phone;
}
    public Order(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getStatusAmount() {
        return statusAmount;
    }

    public void setStatusAmount(int statusAmount) {
        this.statusAmount = statusAmount;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}







