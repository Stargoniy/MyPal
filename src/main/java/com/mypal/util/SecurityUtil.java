package com.mypal.util;

import java.security.MessageDigest;

public class SecurityUtil {

    public static String passwordEncoder(String plainPassword) {
        MessageDigest md5 = null;
        StringBuffer  hexString = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("md5");
        } catch (Exception e) { }

        md5.reset();
        md5.update(plainPassword.getBytes());

        byte messageDigest[] = md5.digest();

        for (int i = 0; i < messageDigest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
        }

        return hexString.toString();
    }
}
