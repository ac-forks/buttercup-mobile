package com.buttercup;

import com.buttercup.BCCrypto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perry on 10/10/17.
 */
public class BCCryptoTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void generateIV_generatesCorrectLength() throws Exception {
        String iv = BCCrypto.generateIV();
        assertEquals(32, iv.length());
    }

    @Test
    public void generateIV_generatesCorrectFormat() throws Exception {
        String iv = BCCrypto.generateIV();
        assertTrue(iv.matches("^[a-f0-9]+$"));
    }

    @Test
    public void generateRandomString_generatesCorrectLength() throws Exception {
        String str1 = BCCrypto.generateRandomString(12);
        String str2 = BCCrypto.generateRandomString(21);
        assertEquals(12, str1.length());
        assertEquals(21, str2.length());
    }

    @Test
    public void generateRandomString_generatesDifferentStrings() throws Exception {
        String str1 = BCCrypto.generateRandomString(5);
        String str2 = BCCrypto.generateRandomString(5);
        assertNotEquals(str1, str2);
    }

    @Test
    public void generateSalt_generatesCorrectLength() throws Exception {
        String salt = BCCrypto.generateSalt(18);
        assertEquals(18, salt.length());
    }

    @Test
    public void generateSalt_generatesCorrectFormat() throws Exception {
        String salt = BCCrypto.generateSalt(16);
        assertTrue(salt.matches("^[a-f0-9]+$"));
    }

}