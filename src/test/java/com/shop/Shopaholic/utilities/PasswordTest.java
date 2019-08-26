package com.shop.Shopaholic.utilities;


import org.junit.Test;

import static com.shop.Shopaholic.utilities.Password.encryptThisString;
import static com.shop.Shopaholic.utilities.Password.isPasswordMatching;
import static org.junit.Assert.assertEquals;

public class TestPassword {
    @Test
    public void shouldReturnEncryptThisString() {
        String encrptedPassword = encryptThisString("123");
        assertEquals("40bd001563085fc35165329ea1ff5c5ecbdbbeef",encrptedPassword);
    }
    @Test
    public void shouldReturnIfPasswordMatch(){
        boolean isPasswordMatch = isPasswordMatching("123","40bd001563085fc35165329ea1ff5c5ecbdbbeef");
        assertEquals(true,isPasswordMatch);
    }

}
