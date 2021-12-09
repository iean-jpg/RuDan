package com.liyue.utils;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {
    public static String encrypt(String password){
        byte[] bytes = null;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            bytes = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String result = new BigInteger(1,bytes).toString(16);
        for(int i=0;i<32-result.length();i++){
            result="0"+result;
        }
        return result;
    }
    public static String convert(String password){
        char[] a = password.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }
    @Test
    public void test(){
        String password = "12345";
        String p = encrypt(password);
        System.out.println(p);
    }
}
