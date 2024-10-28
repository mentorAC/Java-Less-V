package com.ExtraShop.Shop.utils;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHandler {
    public static String hashPassword(String password)throws Exception{
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    public static boolean checkPassword(String hash, String password)throws Exception{
        return hash.equals(hashPassword(password));
    }
}
