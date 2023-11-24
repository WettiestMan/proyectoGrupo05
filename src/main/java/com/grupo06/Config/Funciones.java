/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Marcos Alvarado
 */
public class Funciones {
 
    /**
     *
     * @param password
     * @return an encrypted Password using SHA-256
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            byte[] var4 = hashedBytes;
            int var5 = hashedBytes.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                byte b = var4[var6];
                stringBuilder.append(String.format("%02x", b));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
            return null;
        }
        
    }
    
    public static boolean hasText(String in) {
        return !(null == in || in.isEmpty() || in.isBlank());
    }
    
}
