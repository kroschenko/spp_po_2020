package com.company;

import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Encryptor encryptorOne = new Encryptor(new DeleteLetterAlgorithm());
        encryptorOne.encryptFile("/Users/valeriadmitruk/Desktop/SPP/lab63/File.txt", "deleteletter.txt");
        Encryptor encryptorTwo = new Encryptor(new MoveLetterAlgorithm());
        encryptorTwo.encryptFile("/Users/valeriadmitruk/Desktop/SPP/lab63/File.txt", "moveletter.txt");
        Encryptor encryptorThree = new Encryptor(new XorAlgorithm());
        encryptorThree.encryptFile("/Users/valeriadmitruk/Desktop/SPP/lab63/File.txt", "xorletter.txt");
        System.out.println("Encryption is done. Please check files.");
    }
}
