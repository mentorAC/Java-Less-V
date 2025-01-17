package com.ExtraShop.Shop.models;

public class Product {
    private double price;
    private int quantity;
    private String name;
    private int id;
    private String photoURL;
    private String description;

    public Product(int id, String name, String photoURL, double price,int quantity, String description){
        this.id= id;
        this.name = name;
        this.photoURL = photoURL;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
    public Product(){}
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(int userid) {
    }
}
