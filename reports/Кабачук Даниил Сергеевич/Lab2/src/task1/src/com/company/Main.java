package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(final String[] args) {
        readTheFile("/Users/daniil_kabachuk/Desktop/3 курс/SPP/spp laba2/src/com/company/text");
    }

    private static void readTheFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            List<String> inputData = stream.map((line) -> line
                    .replace(",", "")
                    .replace(".", "")
                    .split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());
            Collections.sort(inputData);
            Set<String> setOfDistinctData = new LinkedHashSet<String>();
            setOfDistinctData.addAll(inputData);
            System.out.println(setOfDistinctData.toString());
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
