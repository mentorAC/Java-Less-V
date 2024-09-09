package com.ExtraShop.Shop.models;

public class Product {
    private double price;
    private int quantity;
    private String name;
    private int id;
    private String photoURL;
    public Product(int id, String name, String photoURL, double price,int quantity){
        this.id= id;
        this.name = name;
        this.photoURL = photoURL;
        this.price = price;
        this.quantity = quantity;
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
}
