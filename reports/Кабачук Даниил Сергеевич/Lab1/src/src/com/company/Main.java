package com.company;

public class Main {

    public static void main(String[] args) {
        task1(args);
        task2(5);
        task3("danik pryanik");
    }

    public static void task1(String[] args) {
        System.out.println("Task1");
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Integer.parseInt(args[i]);
        }
        int counter = 0;
        double average = (double) sum / (double) args.length;
        for (int i = 0; i < args.length; i++) {
            if (Double.parseDouble(args[i]) > average) {
                counter++;
            }
        }
        double result = (double) counter / (double) args.length * 100;
        System.out.println(result + "\n");
    }

    public static void task2(Integer size) {
        System.out.println("Task2");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(single(size)[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void task3(String str) {
        System.out.println("Task3");
        System.out.print(capitalize(str) + "\n");
    }


    public static double[][] single(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public static String capitalize(String str) {
        String[] arr = str.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1) + " ";
        }
        return result;
    }
}
