package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        String[][] string = Files.lines(Paths.get("/Users/daniil_kabacuk/Desktop/spp laba2/src/com/company/text"))
                .map(line -> line.split("\\s")).toArray(String[][]::new);

        for(int i = 0; i < string.length; i++) {
            for(int j = 0; j < string[i].length; j++) {
                if(isRepeated(string, i, j)) {
                    System.out.println(string[i][j]);
                }
            }
        }
    }

    public static Boolean isRepeated(String[][] string, int elem1, int elem2) {
        for(int i = elem1; i < string.length; i++) {
            for(int j = elem2 + 1; j < string[i].length; j++) {
                if(string[elem1][elem2].equals(string[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
