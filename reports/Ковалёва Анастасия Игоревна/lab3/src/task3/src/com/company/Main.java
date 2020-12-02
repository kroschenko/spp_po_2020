package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Car[] cars = new Car[getNumRows()];
            File file = new File("/Users/anastasiakovaleva/Desktop/Учеба 5 сем/СПП/lab3-3/CarInfo.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                String[] subStr;
                subStr = line.split(" ");
                cars[i] = new Car(Integer.parseInt(subStr[0]),subStr[1],subStr[2],Integer.parseInt(subStr[3]), subStr[4],Integer.parseInt(subStr[5]),subStr[6],subStr[7],subStr[8],Integer.parseInt(subStr[9]));
                line = reader.readLine();
                i++;
            }
            print(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(Car[] mass) {
        int num = 0;
        while (num != 6) {
            Scanner in = new Scanner(System.in);
            System.out.println(
                    "1: Все автомобили\n" +
                    "2: Автомобили заданной марки\n" +
                    "3: Автомобили заданной модели, которые эксплуатируются больше n лет \n" +
                    "4: Автомобили заданнго года выпуска, цена которых выше указанной\n" +
                    "5: Автомобили взятые на прокат\n" +
                    "6: Выход");
            System.out.print("Выберите пункт меню: ");
            num = in.nextInt();
            in.nextLine();
            if (num == 1) {
                for (int i = 0; i < mass.length; i++) {
                    mass[i].print_car();
                }
            }
            if (num == 2) {
                System.out.print("Введите марку автомобиля: ");
                String Buff_mark = in.nextLine();
                for (int i = 0; i < mass.length; i++) {
                    if (Buff_mark.equals(mass[i].mark)) {
                        mass[i].print_car();
                    }
                }
            }
            if (num == 3) {
                System.out.print("Введите модель автомобиля: ");
                String Buff_model = in.nextLine();
                System.out.print("Введите количество лет: ");
                int n = in.nextInt();
                for (int i = 0; i < mass.length; i++) {
                    int year = getCurrentYear();
                    if (Buff_model.equals(mass[i].model) && year - mass[i].year > n)
                        mass[i].print_car();
                }
            }
            if (num == 4) {
                System.out.print("Введите год выпуска: ");
                int Buff_year = in.nextInt();
                System.out.print("Введите цену: ");
                int Buff_price = in.nextInt();
                for (int i = 0; i < mass.length; i++) {
                    if (Buff_year == mass[i].year && mass[i].price > Buff_price) {
                        mass[i].print_car();
                    }
                }
            }
            if (num == 5) {
                for (int i = 0; i < mass.length; i++) {
                    if (!mass[i].full_name.equals("Not")) {
                        mass[i].print_car();
                    }
                }
            }
            System.out.println();
        }
    }

    private static int getCurrentYear() {
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        return calendar.get(java.util.Calendar.YEAR);
    }
    private static int getNumRows() throws IOException {
        File file = new File("/Users/anastasiakovaleva/Desktop/Учеба 5 сем/СПП/lab3-3/CarInfo.txt");
        FileReader fr = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fr);
        int lineNumber = 0;
        while (lineNumberReader.readLine() != null){
            lineNumber++;
        }
        return lineNumber;
    }
}

class Car {
    int id;
    String mark;
    String model;
    int year;
    String color;
    int price;
    String reg_num;
    String car_num;
    String full_name;
    int pass_id;
    Car(){
        id = 0;
        mark = "mark";
        model = "model";
        year = 0;
        color = "color";
        price = 0;
        reg_num = "reg_num"; car_num = "car_num";
        full_name = "full_name";
        pass_id = 0;
    }

    Car(int id_new, String mark_new, String model_new, int year_new, String color_new, int price_new, String reg_num_new, String car_num_new, String full_name_new, int pass_id_new){
        id = id_new;
        mark = mark_new;
        model = model_new;
        year = year_new;
        color = color_new;
        price = price_new;
        reg_num = reg_num_new;
        car_num = car_num_new;
        full_name = full_name_new;
        pass_id = pass_id_new;
    }

    public void print_car(){
        System.out.println(
                "id: " + this.id + "\n" +
                "mark: " + this.mark + "\n" +
                "model: " + this.model + "\n" +
                "year: " + this.year + "\n" +
                "color: " + this.color + "\n" +
                "price: " + this.price + "\n" +
                "reg_num: " + this.reg_num + "\n" +
                "car_num: " + this.car_num);
        if(!this.full_name.equals("Not")) System.out.println("full_name: " +
                this.full_name.replaceAll("_"," "));
        if(this.pass_id != 0) System.out.println("pass_id: " + this.pass_id);
    }
}
