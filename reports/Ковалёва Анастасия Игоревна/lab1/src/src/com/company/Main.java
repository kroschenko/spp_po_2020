package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        task1(args);
        task2();
        task3();
    }

    public static void task1(String[] args) {
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        int step = Integer.parseInt(args[2]);

        for (int i = start; i <= end; i += step) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void task2() {
        double[] newArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (double d: subarray(newArr, 3, 8)) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static double[] subarray(double[] array, int startIndex, int endIndex) {
        double[] newArr = new double[endIndex - startIndex + 1];
        int k = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            newArr[k] += array[i];
            k++;
        }
        return newArr;
    }

    public static String shiftRight(String str, int shift) {
        char [] charStr = str.toCharArray();
        char [] temp = new char[str.length()];
        int k = 0;
        for (int i = shift; i < str.length(); i++) {
            temp[k] = charStr[i];
            k++;
        }

        for (int i = 0; i < shift; i++) {
            temp[k] = charStr[i];
            k++;
        }

        StringBuffer sb = new StringBuffer(String.valueOf(temp));
        return sb.toString();
    }

    public static void task3() {
        String str = shiftRight("abcd", 2);
        System.out.println(str);
    }
}
