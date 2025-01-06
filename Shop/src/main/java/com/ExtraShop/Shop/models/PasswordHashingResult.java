package com.ExtraShop.Shop.models;


public class PasswordHashingResult {
    private final String hash;
    private final String salt;

    public PasswordHashingResult(String hash, String salt){
        this.hash = hash;
        this.salt = salt;
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }
}
