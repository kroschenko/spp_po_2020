package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        printMenu();
        ArrayList <Book> books = readInfo("./file.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            String ch = sc.nextLine();
            switch (ch) {
                case "1":
                    AllBooks(books);
                    break;
                case "2":

                    System.out.println("Enter the year:");
                    int year = Integer.parseInt(sc.nextLine());
                    BooksOlderThanN(books, year);
                    break;
                case "3":
                    BooksTakenForReading(books);
                    break;
                case "4":
                    BooksTakenForReadingWithReaderInformation(books);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Enter again:");
                    continue;
            }
            break;
        }
    }

    private static void AllBooks (ArrayList<Book> books) {
        for (Book book: books) {
            System.out.println(book.allBooks());
        }
    }
    private static void BooksTakenForReading (ArrayList<Book> books) {
        for (Book book: books) {
            if (book.isTaken()) {
                System.out.println(book.allBooks());
            }
        }
    }
    private static void BooksOlderThanN (ArrayList<Book> books, int n) {
        for (Book book: books) {
            if (book.getYear() > n) {
                System.out.println(book.allBooks());
            }
        }
    }
    private static void BooksTakenForReadingWithReaderInformation (ArrayList<Book> books) {
        for (Book book: books) {
            if (book.isTaken()) {
                System.out.println(book.toString());
            }
        }
    }

    private static void printMenu() {
        System.out.println("information about all books - 1");
        System.out.println("Books older than n years - 2");
        System.out.println("Books taken for reading - 3");
        System.out.println("Books taken for reading(and reader information) - 4")
        ;
        System.out.println("Exit - 0");
    }
    private static ArrayList<Book> readInfo(String fileName) throws
            IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String sCurrentLine;
        ArrayList<Book> books = new ArrayList<Book>();
        while (((sCurrentLine = br.readLine()) != null) &&
                !sCurrentLine.equals("")) {
            String author = sCurrentLine;
            String title = br.readLine();
            int year = Integer.parseInt(br.readLine());
            int numberOfBooks = Integer.parseInt(br.readLine());
            int numberOfPages = Integer.parseInt(br.readLine());
            String readerFIO = br.readLine();
            String date = br.readLine();
            boolean isTaken = Boolean.parseBoolean(br.readLine());
            Book book = new Book(author, title, year, numberOfBooks, numberOfPages, readerFIO, date, isTaken);
            books.add(book);
        }
        return books;
    }
}
