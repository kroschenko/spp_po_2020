package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class Encryptor {
    private EncryptionAlgorithm algorithm;
    public Encryptor(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    public void encryptFile(String filePath, String outputFile) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(filePath));
        List<String> encryptedStrings = new ArrayList<>();
        for (String string : strings) {
            encryptedStrings.add(algorithm.encryptData(string));
        }
        Files.write(Paths.get(outputFile), encryptedStrings); }
}
