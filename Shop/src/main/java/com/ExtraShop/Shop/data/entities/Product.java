package com.ExtraShop.Shop.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double price;
    private int quantity;
    private String name;
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

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhotoURL() {
        return photoURL;
    }
}
