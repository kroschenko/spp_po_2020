package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static String PATH = "/Users/anastasiakovaleva/Desktop/lab-2/src/com/company/file";

    public static void main(String[] args) throws IOException {

        System.out.println(shuffle(getWords(PATH)));

    }


    public static List<String[]> getWords(String path) throws IOException {
        return Files
                .lines(Paths.get(path), StandardCharsets.UTF_8)
                .map((x) -> x.replaceAll("[!:,.?!''(+)-]", ""))
                .map(x -> x.split("\\s+"))
                .collect(Collectors.toList());
    }

    public static String shuffle(List<String []> list){
        StringBuilder stringBuilder = new StringBuilder();

        for (String[] arrStr : list) {
            for (String str : arrStr) {
                stringBuilder.append(shuffleString(str)).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        StringBuilder builder = new StringBuilder();
        for (String letter : letters) {
            builder.append(letter);
        }
        return builder.toString();
    }
}


