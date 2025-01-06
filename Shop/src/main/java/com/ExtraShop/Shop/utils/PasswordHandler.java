package com.ExtraShop.Shop.utils;

import com.ExtraShop.Shop.models.PasswordHashingResult;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHandler {
    public static PasswordHashingResult hashPassword(String password)throws Exception{
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return new PasswordHashingResult(
                Base64.getEncoder().encodeToString(hashedPassword),
                Base64.getEncoder().encodeToString(salt) );
    }

    public static boolean checkPassword(String hash, String salt, String password)throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update( Base64.getDecoder().decode(salt));
        byte[] hashedPassword = md.digest(password.getBytes());
        var currentHash = Base64.getEncoder().encodeToString(hashedPassword);


        return currentHash .equals(hash);
    }
}
