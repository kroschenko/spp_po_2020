package com.company;

public class DeleteLetterAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encryptData(String plainText) {
        return plainText.replaceAll("[AEIOUaeiou]", "");
    }
}
