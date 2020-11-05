package com.company;

class Book{
    private String author;
    private String title;
    private int year;
    private int numberOfBooks;
    private int numberOfPages;
    private String readerFIO;
    private String dateOfDelivery;
    private boolean isTaken;
    public Book(String author, String title, int year, int numberOfBooks, int numberOfPages,String readerFIO, String date, boolean isTaken){
        this.author = author;
        this.title= title;
        this.year = year;
        this.numberOfBooks = numberOfBooks;
        this.numberOfPages = numberOfPages;
        this.readerFIO = readerFIO;
        this.dateOfDelivery = date;
        this.isTaken = isTaken;
    }
    public int getYear(){
        return year;
    }
    public boolean isTaken() {
        return isTaken;
    }

    public String allBooks(){
        return "Author: " + author + '\n' +
                "Title: " + title + '\n' +
                "Year: " + year + '\n' +
                "number of books: " + numberOfBooks + '\n' +
                "number Of Pages: " + numberOfPages + '\n';
    }
    @Override
    public String toString() {
        String str_taken;
        if (isTaken) str_taken = "Book is taken";
        else str_taken = "Book is not taken";
        return "Author: " + author + '\n' +
                "Title: " + title + '\n' +
                "Year: " + year + '\n' +
                "number of books: " + numberOfBooks + '\n' +
                "number Of Pages: " + numberOfPages + '\n' +
                "reader FIO: " + readerFIO + '\n' +
                "Date of delivery: " + dateOfDelivery + '\n' +
                "Is book Taken: " + str_taken + '\n';
    }
}
