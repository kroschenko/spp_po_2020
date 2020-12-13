import java.util.*;
import java.text.*;


public class task3 {

    public static void main(String[] args) {

        String[] bookNames = { "Master and Margarita", "Dead Souls", "Anna Karenina" };

        Library library = new Library();

        //create books

        Book[] books = { new Book(bookNames[0], "Bulgakov", 3), new Book(bookNames[1], "Gogol", 5),
                new Book(bookNames[2], "Tolstoy", 1) };

        //create readers

        Reader[] readers = { new Reader("Ivan Ivanov", "24.05.2019"), new Reader("Ivan Petrov", "04.12.2019"), 
                    new Reader("Ivan Sergeev", "01.12.2019") , new Reader("Ivan Semenov", "05.12.2019")};

        //add books in arrayList
       

        for (Book book : books) {
            library.addBook(book);
        }
        //add readers in arrayList

        for (Reader reader : readers) {
            library.addReader(reader);
        }

        library.showAll();

        // System.out.println("\nTry to add Bulgakov to Ivan Ivanov\n");

       library.createOrder(readers[0], books[0]);
       
    //    System.out.println("\nTry to add Gogol to Ivan Ivanov\n");

       library.createOrder(readers[0], books[1]);



    //    System.out.println("\nTry to add Tolstoi to Ivan Petrov\n");
       
       library.createOrder(readers[1], books[2]);


    //    System.out.println("\nTry to add Tolstoi to Ivan Sergeev\n");

       library.createOrder(readers[2], books[2]);

    //    System.out.println("\nTry to add Gogol to Ivan Sergeev\n");
       
       library.createOrder(readers[2], books[1]);

    //    System.out.println("\nTry to add Tolstoi to Ivan Semenov\n");

       library.createOrder(readers[3], books[2]);

      for(Reader reader: readers){
          System.out.println("Reader name: " + reader.getName() 
                            + "\nDate: " + reader.getDate() + "\n");
          reader.showAll();
      }

      library.showBlackList();
      
    }
}

interface Show{
    void showAll();
}

class Library implements Show{

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();
    private ArrayList<Reader> blackList = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void createOrder(Reader reader, Book book) {

        if(reader.checkDate(new Date(), reader.getDate()) > 20){
            blackList.add(reader);
            return;
        }

        for(Book currentBook : books){

            if(currentBook.getId() == book.getId() && currentBook.getNumber() > 0){
                Order order = new Order(book.getId(), reader.getName(), book.getTitle());
                orders.add(order);
                order.showAll();
                removeBook(currentBook);
                reader.addBook(currentBook);
                removeOrder(order);
            }

        }   
        

    }

    public void showBlackList(){
        System.out.println("\nBlack list\n");
        for(Reader reader: blackList){
            System.out.println("\nReader name: " + reader.getName() 
                                + "\nDate: " + reader.getDate());
        }
    }

    public void showAll(){
        System.out.println("\nAll books in the library:\n");
        for(Book book: books){
            System.out.println("\nBooks title: " + book.getTitle() 
                                + "\nAuthor: " + book.getAuthor()
                                + "\nCount: " + book.getNumber() + "\n");
        }
    }

    public void removeBook(Book book){
        book.setNumber(book.getNumber()-1);
        
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public void addReader(Reader reader){
        readers.add(reader);
    }
}

class Book {
    private int id;
    private String title;
    private String author;
    private int number;

    private static int booksCount = 1;

    public Book(String title, String author, int number) {
        id = booksCount++;

        setTitle(title);
        setAuthor(author);
        setNumber(number);
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class Reader implements Show{

    private int id;
    private String name;
    private Date bookDate = null;
    private ArrayList<Book>books = new ArrayList<>();

    private static int readersCount = 1;

    public Reader(String name, String date) {
        id = readersCount++;

        setName(name);
        setDate(date);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try{
            bookDate = format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getDate(){
        return bookDate;
    }

    public long checkDate(Date date, Date bookDate){
        long difference = date.getTime() - bookDate.getTime();
        long days =  difference / (24 * 60 * 60 * 1000);
        return days;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void showAll(){
        for(Book book: books){
            if(books.size() == 0) {System.out.println("There is not any books");}
            else {
              System.out.println("Book name: " + book.getTitle() + "\n" +
                      "Author: " + book.getAuthor() + "\n");
            } 
        }
    }
}

class Order implements Show{
    private int id;
    private int bookId;
    private String readerName;
    private String bookTitle;

    private static int ordersCount = 1;

    public Order(int bookId, String readerName, String bookTitle) {
        id = ordersCount++;

        setBookId(bookId);
        setReaderName(readerName);
        setBookTitle(bookTitle);
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public String getBookTitle(){
       return bookTitle;
    }
    public void showAll(){
        System.out.println("Try to add " + bookTitle + " to" + readerName);
    }
}