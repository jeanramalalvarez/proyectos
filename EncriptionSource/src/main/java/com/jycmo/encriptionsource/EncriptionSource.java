/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycmo.encriptionsource;

/**
 *
 * @author YESM
 */
import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.paddings.*;
import org.bouncycastle.crypto.engines.*;
import org.bouncycastle.crypto.modes.*;
import org.bouncycastle.crypto.params.*;


public class EncriptionSource {
    
    private BlockCipher engine = new DESedeEngine();

    public byte[] Encrypt(byte[] key, String plainText) {
        byte[] ptBytes = plainText.getBytes();
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
        cipher.init(true, new KeyParameter(key));
        byte[] rv = new byte[cipher.getOutputSize(ptBytes.length)];
        int tam = cipher.processBytes(ptBytes, 0, ptBytes.length, rv, 0);
        try {
            cipher.doFinal(rv, tam);
        } catch (Exception ce) {
            System.out.println("Error en Encrypt: "+ce.getMessage());
        }
        return rv;
    }

    public String Decrypt(byte[] key, byte[] cipherText) {
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
        cipher.init(false, new KeyParameter(key));
        byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
        int tam = cipher.processBytes(cipherText, 0, cipherText.length, rv, 0);
        try {
            cipher.doFinal(rv, tam);
        } catch (Exception ce) {
            System.out.println("Error en Decrypt: "+ce.getMessage());
        }
        return new String(rv).trim();
    }
    
    
    public static void main(String[] args) throws Exception {
        EncriptionSource esource = new EncriptionSource();
        String key = "5DFA4D4E60660A7B9238A4BDA19C3857";
        String cad = "";
//          String cad = "jargourmet";
        byte[] keyb = FunctionByte.hex2byte(key);
        System.out.println("Cadena Ingreso: " + cad);
        String enc = FunctionByte.toHEX1(esource.Encrypt(keyb, cad));
        System.out.println("Encripta: " + enc);
        String des = esource.Decrypt(keyb, FunctionByte.hex2byte(enc));
        des = esource.Decrypt(keyb, FunctionByte.hex2byte("741B00D69BB603A9"));
        System.out.println("Desencripta: " + des);
    }
    
}
