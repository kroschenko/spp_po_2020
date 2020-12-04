package com.company;

public class XorAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encryptData(String plainText) {
        String key = "010101";
        byte[] bytes = plainText.getBytes(); byte[] keys = key.getBytes();
        byte[] out = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            out[i] = (byte) (bytes[i] ^ keys[i % keys.length]);
        }
        return new String(out);
    }
}
