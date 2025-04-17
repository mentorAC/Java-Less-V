package com.ExtraShop.Shop.models;

import java.util.LinkedList;

public class LoginResponse {
    private String token;

    public LoginResponse(String token, LinkedList<String> roles){
        this.token = token;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    private LinkedList<String> roles;


    public LinkedList<String> getRoles() {
        return roles;
    }

    public void setRoles(LinkedList<String> roles) {
        this.roles = roles;
    }
}

