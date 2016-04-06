package com.cybercaterpillar.kriptografiTest;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Blowfish {
    public static String enkripsi(int idData, String pesan, String key) {
        final long startTime = System.currentTimeMillis();
        try {
            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, KS);
            byte[] encrypted = cipher.doFinal(pesan.getBytes());
            final long endTime = System.currentTimeMillis();
            System.out.println("_enBlowfish ID: " + idData + " Total execution time: " + (endTime - startTime));
            return Base64.encodeToString(encrypted, Base64.NO_PADDING);
        } catch (Exception e) {
            return "ERROR:" + e.getMessage();
        }
    }

    public static String dekripsi(String chiperText, String key) {
        final long startTime = System.currentTimeMillis();
        try {

            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, KS);
            byte[] decrypted = cipher.doFinal(Base64.decode(chiperText, Base64.NO_PADDING));
            final long endTime = System.currentTimeMillis();
            System.out.println("crypTAGdekripsiBlowfish Total execution time: " + (endTime - startTime));
            System.out.println("crypTAGdekripsiBlowfish Pesan :"+decrypted);
            return new String(decrypted);
        } catch (Exception e) {
            return "ERROR";
        }
    }


}