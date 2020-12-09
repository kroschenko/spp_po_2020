package com.company;

public class MoveLetterAlgorithm implements EncryptionAlgorithm {
    @Override
    public String encryptData(String plainText) { StringBuffer result = new StringBuffer();
        for (int i = 0; i < plainText.length(); i++) {
            if (Character.isUpperCase(plainText.charAt(i))) {
                char ch = (char) (((int) plainText.charAt(i) + 4 - 65) % 26 + 65); result.append(ch);
            } else {
                char ch = (char) (((int) plainText.charAt(i) + 4 - 97) % 26 + 97); result.append(ch);
            }
        }
        return result.toString();
    }
}
