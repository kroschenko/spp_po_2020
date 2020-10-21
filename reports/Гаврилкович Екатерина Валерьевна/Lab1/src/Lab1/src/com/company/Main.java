package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

//Здание1: Вывод размаха последовательности (разницы между максимальным и минимальным числом)
//Задание2: Напишите метод long[] removeElement(long[] array, long element), который ищет и удаляет из массива указанный элемент.
//Задание3: Написать функцию String randomString(int lenght, boolean asciiOnly) для генерации слу-чайных строк заданного размера.
            // Функция должна принимать флаг asciiOnly, определяющий,должны ли в итоговой строке быть только ASCII символы.
public class Main {

    public static void main(String[] args) {
	// write your code here

        // Задание1
        differenceBetweenMinMax(args);

        // Задание2
        long[] array = new long[] {1,2,3,4,5,6,};
        long element = 5;
        System.out.println(Arrays.toString(removeElement(array, element)));

        // Задание3
        int n = 20;
        System.out.println(randomString(n, false));
    }

    public static void differenceBetweenMinMax(String[] array) {

        int[] arr= Stream.of(array).mapToInt(Integer::parseInt).toArray();

        if (arr.length < 2) {
            System.out.println("Too small input elements");
        } else {
            int indexOfMax = 0;
            int indexOfMin = 0;

            for (int i = 1; i < arr.length; i++) {
                if (  arr[i] > arr[indexOfMax]) {
                    indexOfMax = i;
                } else if (arr[i] > arr[indexOfMin]) {
                    indexOfMin = i;
                }
            }
            int difference = arr[indexOfMax] - arr[indexOfMin];
            System.out.println(difference);
        }
    }

    public static long[] removeElement(long[] array, long element) {
        System.out.println(Arrays.toString(array));

        long[] result = new long[array.length -1];
        int indexOfRemoveElement = 0;

        for (int i = 1; i< array.length; i++) {
            if (array[i] == element) {
                indexOfRemoveElement = i;
                break;
            } else {
                indexOfRemoveElement = -1;
            }
        }
        if (indexOfRemoveElement == -1) {
            System.out.println("No removed element");
            return array;
        } else {
            System.arraycopy(array,0, result,0,indexOfRemoveElement);
            System.arraycopy(array,indexOfRemoveElement+1, result, indexOfRemoveElement, array.length - indexOfRemoveElement - 1);
            return  result;
        }
    }

    private static String randomString(int lenght, boolean asciiOnly) {
        Random random = new Random();

        String result = "";

        if (asciiOnly == true) {
            for (int i=0; i<= lenght; i++) {
                int num = 33 + random.nextInt(127 - 33);
                result += new String(Character.toChars(num));
            }
        } else {
            for (int i=0; i<=lenght; i++) {
                int num = random.nextInt(65000);
                result += new String(Character.toChars(num));
            }
        }
        return  result;
    }
}
