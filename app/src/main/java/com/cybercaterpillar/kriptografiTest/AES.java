package com.cybercaterpillar.kriptografiTest;

import com.scottyab.aescrypt.AESCrypt;

import java.security.GeneralSecurityException;

public class AES {
    public static String enkripsi(int idData, String pesan, String key) {
        final long startTime = System.nanoTime();
        int idskenario = idData;
        String password = key;
        String message = pesan;
        try {
            String encryptedMsg = AESCrypt.encrypt(password, message);
            final long endTime = System.nanoTime();
            System.out.println("@AESEN ID: " + idskenario + " Total execution time: " + (endTime - startTime));
            return encryptedMsg;
        } catch (GeneralSecurityException e) {
            return "ERROR:" + e.getMessage();
        }

    }

    public static String dekripsi(String chiperText, String key) {
        String password = key;
        String encryptedMsg = chiperText;
        final long startTime = System.nanoTime();
        try {
            String messageAfterDecrypt = AESCrypt.decrypt(password, encryptedMsg);
            final long endTime = System.nanoTime();
            System.out.println("@AESDE Total execution time: " + (endTime - startTime));
            System.out.println("Pesan :"+messageAfterDecrypt);
            return messageAfterDecrypt;
        } catch (GeneralSecurityException e) {
            return "ERROR";
            //handle error - could be due to incorrect password or tampered encryptedMsg
        }
    }
}
