package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Заданеи1 Напишите программу, которая cчитывает текст и печатает таблицу, показывающую,
// сколько раз в этом тексте встречаются однобуквенные слова, двухбуквенные слова, трехбуквенные слова и т.д.

//Задание2 Утилита head выводит несколько (по умолчанию 10) первых строк из файла.
//        Формат использования: head [ -n] file
//
//        Ключ -n <line numbers> (или просто <line numbers>) позволяет изменить количество выводи-
//        мых строк.
//
//        Пример использования:
//        head -n 20 app.log
//        head 20 app.log
//        Выводит 20 первых строк из файла app.log.
//        Для решения задачи подойдет класс java.io.RandomAccessFile , реализующий произвольный
//        доступ к файлу (чтение и запись с любой позиции в файле).

public class Main {

    public static void main(String[] args) {
	    getWordsCount();

	    String[] line = {"head", "2", "text.txt"};
        headCustom(line);
    }

    public static void getWordsCount() {
        try{
            Scanner sc = new Scanner(new File("text.txt"));
            ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>();
            while(sc.hasNext()){
                String[] str = sc.next().split(" ");
                for(int i = 0; i < str.length; i++){
                    int lengthOfTheWord = str[i].split("").length;
                    System.out.println(str[i] + " - " + lengthOfTheWord);
                    arrayOfNumbers.add(lengthOfTheWord);
                }
            }
            int count;
            Collections.sort(arrayOfNumbers);
            for(int i = 0 ; i < arrayOfNumbers.size(); i++){
                count = 0;
                for(int j = 0 ; j < arrayOfNumbers.size(); j++){
                    if(arrayOfNumbers.get(i) == arrayOfNumbers.get(j)){
                        count++;
                    }
                }
                if(i == arrayOfNumbers.size()-
                        1 || arrayOfNumbers.get(i) != arrayOfNumbers.get(i+1))
                    System.out.println(arrayOfNumbers.get(i) + " - " + count);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void headCustom(String[] args) {
        int count = 0;
        String file = "";
        if(args[0].equals("head")){
            if(args.length == 3){
                if(checkFile(args[2])){
                    try {
                        count = Integer.parseInt(args[1]);
                    }
                    catch(Exception e) {
                        System.out.println("Check all!");
                        System.exit(0);
                    }
                    checkNumber(count);
                    file = args[2];
                    print(file, count);
                }
            }
            if(args.length > 3 && args[1].equals("-n")){
                try{
                    if(checkFile(args[3])){
                        count = Integer.parseInt(args[2]);
                        checkNumber(count);
                        file = args[3];
                        print(file, count);
                    }
                    else{
                        System.out.println("Check the name of the file!");
                    }
                }
                catch(Exception e){
                    System.out.println("Try again!");
                }
            }
            if(args.length == 2){
                try{
                    if(checkFile(args[1])){
                        count = 10;
                        file = args[1];
                        print(file, count);
                    }else{
                        System.out.println("Check the name of the file!");
                    }
                }
                catch(Exception e){
                    System.out.println("Try again!");
                }
            }
        }
        else System.out.println("Check the first parameter!");
    }

    public static boolean checkFile(String argument){
        if(argument.split("\\.")[1].equals("txt")) return true;
        else return false;
    }

    public static void checkNumber(int number){
        if(number < 0) {
            System.out.println("Check your number!");
            System.exit(0);
        }
    }

    public static void print(String file, int number){
        try{
            Scanner sc = new Scanner(new File(file));
            while(sc.hasNext() && number != 0){
                System.out.println(sc.next());
                number--;
            }
        }
        catch(Exception e){
            System.out.println("There is not any files!");
        }
    }
}