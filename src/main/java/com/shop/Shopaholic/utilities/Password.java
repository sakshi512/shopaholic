package com.shop.Shopaholic.utilities;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.security.MessageDigest.getInstance;

public class Password {
    public static String encryptThisString(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encryptThisStringWithSameSalt(String password) throws NoSuchAlgorithmException
    {
        //String password = "123456";

        MessageDigest md = getInstance("SHA-1");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        //System.out.println(sb.toString());

        return sb.toString();
    }
    public static boolean isPasswordMatching(String passwordEnteredByUser, String passwordFromDatabase) throws NoSuchAlgorithmException {
        String hashPassword = encryptThisStringWithSameSalt(passwordEnteredByUser);
        if(hashPassword.compareTo(passwordFromDatabase) != 0)
        {
            return false;
        }
        return true;
    }

}
