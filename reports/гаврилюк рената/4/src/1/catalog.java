import java.util.ArrayList;

class Catalog{
    public class Book{
        private String mNameBook;
        private String mDate;
        private String mReader;

        public Book(String nameBook, String date, String reader){
            this.mNameBook = nameBook;
            this.mDate = date;
            this.mReader = reader;
        }

        public String getNameBook(){
            return this.mNameBook;
        }
        
        public String getDate(){
            return this.mDate;
        }
        
        public String setReader(){
            return this.mReader;
        }

        public void setNameBook(String nameBook){
            this.mNameBook = nameBook;
        }
        
        public void getDate(String date){
            this.mDate = date;
        }
        
        public void getReader(String reader){
            this.mReader = reader;
        }

        public String toString(){
            return "Book: " + mNameBook +
            "\nDate: " + mDate +
            "\nReader: " + mReader;
        }
    }

    private ArrayList<Catalog.Book> books;

    public Catalog(){
        books = new ArrayList<>();
    }

    public void addBook(String nameBook, String date, String reader){
        Book book = new Book(nameBook, date, reader);
        books.add(book);
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void showBooks(){
        for(Book book : books){
            System.out.println(book.toString());
        }
    }
}