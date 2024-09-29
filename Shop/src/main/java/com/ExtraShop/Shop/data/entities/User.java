package com.ExtraShop.Shop.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String email;
    private String phone;

    public User(String username, String password, String email, String phone){
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getId(){return id;}
    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public String getPhone(){return phone;}
    public String getPassword(){ return password;}



}
