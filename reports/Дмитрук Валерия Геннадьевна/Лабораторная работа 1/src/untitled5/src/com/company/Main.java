package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void task2(int shift, int ...nums) {
        int shift1 = -shift;
        for (int i = 0; i< nums.length; i++) {
            System.out.print(" "+nums[i]);
        }
        for (int i = 0; i > shift1; i--) {
            int buffer = nums[nums.length - 1];
            nums[nums.length - 1] = nums[0];
            for (int j = 1; j < nums.length - 1; j++) {
                nums[j - 1] = nums[j];
            }
            nums[nums.length - 2] = buffer;
        }
        System.out.println();
        for (int i = 0; i< nums.length; i++) {
            System.out.print(" "+nums[i]);
        }
    }

  static String xor(String str1, String str2){
        String xor = "";
        int length = str1.length() > str2.length() ? str2.length() : str1.length();
         char[] str1c = str1.toCharArray();
         char[] str2c = str2.toCharArray();
         for (int x = 0; x < length; x++){
             if (str1c[x] == str2c[x]) xor = xor + "0"; else xor = xor + "1";
         }
         return xor;
    }

    public static void main(String[] args) {



        //Task3
//        String xor = "";
//        int length = args[0].length() > args[1].length() ? args[1].length() : args[0].length();
//        char[] str1c = args[0].toCharArray();
//        char[] str2c = args[1].toCharArray();
//        for (int x = 0; x < length; x++){
//            if (str1c[x] == str2c[x]) xor = xor + "0"; else xor = xor + "1";
//        }
//
//        System.out.println(xor);
//    }

        //Task2
        int[] arr = new int[args.length];
        for(int i=0; i<args.length; i++) {
            try {
                arr[i] = Integer.parseInt(args[i]);
            } catch(Exception e) {
                System.out.print("Try again!");
                System.out.println(e);
            }
        }

        int n = Arrays.stream(arr).max().getAsInt();
        int count = 1;
        while(n/10 !=0) {
            n /= 10;
            count ++;
        }
        int[] array = new int[count];
        count = 0;
        for (int i=0; i<array.length; i++) {
            array[i] = 0;
        }
        for(int j : arr) {
            count = 1;
            while(j/10 != 0) {
                j /= 10;
                count ++;
            }
            array[count-1] += 1;
        }
        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]+"----"+(i+1)+" numbers");
        }

        //Task 1
//        int[] arr = new int[args.length];
//        for(int i=0; i<args.length; i++) {
//            try {
//                arr[i] = Integer.parseInt(args[i]);
//            } catch(Exception e) {
//                System.out.print("Try again!");
//                System.out.println(e);
//            }
//        }
//
//        int n = Arrays.stream(arr).max().getAsInt();
//        int count = 1;
//        while(n/10 !=0) {
//            n /= 10;
//            count ++;
//        }
//        int[] array = new int[count];
//        count = 0;
//        for (int i=0; i<array.length; i++) {
//            array[i] = 0;
//        }
//        for(int j : arr) {
//            count = 1;
//            while(j/10 != 0) {
//                j /= 10;
//                count ++;
//            }
//            array[count-1] += 1;
//        }
//        for (int i=0; i<array.length; i++) {
//            System.out.println(array[i]+"----"+(i+1)+" numbers");
//        }

    }
}
