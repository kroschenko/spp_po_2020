package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static String fileReader(String filename) {
        String text = "";
        try(FileReader reader = new FileReader(filename))
        {
            int c;
            while((c=reader.read())!=-1){
                text += (char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public static void fileWriter(String filename, String str){
            try {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(str);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }

    public static void task1() {
        String nouns = fileReader("/Users/valeriadmitruk/Desktop/SPP/src/com/company/nouns.txt");
        String adjectives = fileReader("/Users/valeriadmitruk/Desktop/SPP/src/com/company/adjectives.txt");
        String verbs = fileReader("/Users/valeriadmitruk/Desktop/SPP/src/com/company/verbs.txt");
        String prepositions = fileReader("/Users/valeriadmitruk/Desktop/SPP/src/com/company/prepositions.txt");

        String[] nounsArray = nouns.split(" ");
        String[] adjectivesArray = adjectives.split(" ");
        String[] verbsArray = verbs.split(" ");
        String[] prepositionsArray = prepositions.split(" ");

        String result = "";
        for(int i=0; i<20; i++) {
            String noun = nounsArray[(int) (Math.random()*nounsArray.length)];
            result += noun.substring(0, 1).toUpperCase() + noun.substring(1) + " ";
            String verb = verbsArray[(int) (Math.random()*verbsArray.length)];
            result += verb + " ";
            String preposition = prepositionsArray[(int) (Math.random()*prepositionsArray.length)];
            result += preposition + " ";
            String adjective = adjectivesArray[(int) (Math.random()*adjectivesArray.length)];
            result += adjective + " ";
            String nounLast = nounsArray[(int) (Math.random()*nounsArray.length)];
            result += nounLast + ".";
            System.out.println(result);
            result = "";
        }
    }

    public static Boolean compareStrings(String[] str1, String[] str2, int val1, int val2) {
        return str1[val1].equals(str2[val2]);
    }

    public static void join(String values,
                             String filepathOne,
                             String filepathTwo,
                             String filepathThree
    ) {
        Scanner in = new Scanner(System.in);
        if (filepathOne == "-" && filepathTwo == "-" ) {
            System.out.print("Ошибка ввода!!!");
        } else {
            if (filepathOne == "-") {
                System.out.print("Введите путь к первому файлу: ");
                filepathOne = in.nextLine();
            }
            if (filepathTwo == "-") {
                System.out.print("Введите путь ко второму файлу: ");
                filepathTwo = in.nextLine();
            }
            int val1=0;
            int val2=0;
            String[] val = values.split(" ");
            if (val.length>0) {
                if (val.length == 2) {
                    if (val[0].equals("-1")) {
                        val1 = Integer.parseInt(val[1]) - 1;
                    } else if (val[0].equals("-2")){
                        val2 = Integer.parseInt(val[1]) - 1;
                    }
                } else if (val.length == 4) {
                    if (val[0].equals("-1")) {
                        val1 = Integer.parseInt(val[1]) - 1;
                    }
                    if (val[2].equals("-2")) {
                        val2 =  Integer.parseInt(val[3]) - 1;
                    }
                }

                if(val1>2 || val1<0) { val1 = 0; }
                if(val2>2 || val2<0) { val2 = 0; }
            }

            int oppositeOne = 0;
            int oppositeTwo = 0;
            if (val1 == 0) { oppositeOne = 1; } else { oppositeOne = 0; }
            if (val2 == 0) { oppositeTwo = 1; } else { oppositeTwo = 0; }
            String answer = "";
            //считываем 2 файла
            String one = fileReader(filepathOne);
            String two = fileReader(filepathTwo);
            //переводим в 2 массива строк
            String[] str1 = one.split("\n");
            String[] str2 = two.split("\n");
            // в цикле разбиваем на сплит и сравниваем
            for(int i=0; i<str1.length; i++) {
                for(int j=0; j<str2.length; j++) {
                    String[] str11 = str1[i].split(" ");
                    String[] str22 = str2[j].split(" ");
                    if(compareStrings(str11, str22, val1,val2) == true) {
                        answer += str11[val1];
                        answer += " ";
                        answer += str11[oppositeOne];
                        answer += " ";
                        answer += str22[oppositeTwo];
                        answer += "\n";
                    }
                }
            }
            fileWriter(filepathThree,answer);
        }
    }

    public static void main(String[] args) {
        join("",
                "/Users/valeriadmitruk/Desktop/SPP/out/production/SPP/com/company/b.txt",
                "/Users/valeriadmitruk/Desktop/SPP/out/production/SPP/com/company/a.txt",
                "answer.txt");
    }
}
//
///Users/valeriadmitruk/Desktop/SPP/out/production/SPP/com/company/b.txt
