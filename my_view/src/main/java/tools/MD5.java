package main.java.tools;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    // 使用jdk自带的java.security.MessageDigest实现
    public static String md5(String s) {
        String md5code = "";
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(s.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }

        return md5code;
    }
    public static void main(String[] args) {
        System.out.println(md5("admin"));
    }

}
