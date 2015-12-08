/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionmatriz.util;

/**
 *
 * @author YESM
 */
import org.apache.log4j.Logger;
import org.bouncycastle.crypto.*;
import org.bouncycastle.crypto.paddings.*;
import org.bouncycastle.crypto.engines.*;
import org.bouncycastle.crypto.modes.*;
import org.bouncycastle.crypto.params.*;


public class EncriptionSource {
    
	private static final Logger log=Logger.getLogger(EncriptionSource.class);
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
            log.error("Error en Encrypt: "+ce.getMessage());
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
            log.error("Error en Decrypt: "+ce.getMessage());
        }
        return new String(rv).trim();
    }
}
