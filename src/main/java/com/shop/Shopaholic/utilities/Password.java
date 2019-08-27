package com.shop.Shopaholic.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public static String hashPassword(String password) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//        return hashedPassword;
//        String password1 = password;
//        //String salt = BCrypt.gensalt(4);
//        String salt = "$2a$04$H4TQWhkOXTZr86Fczzjyde";
//        System.out.println("salt === "+salt);
//        String hashed_password = BCrypt.hashpw(password1, salt);
//        System.out.println("hashed_password=="+hashed_password);
//        return(hashed_password);

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes("iso-8859-1"), 0, password.length());
        byte[] sha1hash = md.digest();

        return convertToHex(sha1hash);
    }

    public static boolean isPasswordValid(String password_plaintext, String stored_hash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String hashPassword = hashPassword(password_plaintext);
        if(hashPassword.compareTo(stored_hash) != 0)
        {
            return false;
        }
        return true;
//        boolean password_verified = false;
//        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
//        return(password_verified);
    }

    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte)
                        : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        System.out.println("=======>"+buf.toString());
        return buf.toString();
    }
}
