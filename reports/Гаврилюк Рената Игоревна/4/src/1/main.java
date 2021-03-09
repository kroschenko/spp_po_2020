class Laba4{
    public static void main(String[] args) {
        //task 1
        Catalog catalog = new Catalog();
        catalog.addBook("book 1", "12.03.2000", "reader 1");
        catalog.addBook("book 2", "13.04.2001", "reader 2");
        catalog.addBook("book 3", "14.05.2002", "reader 3");
        catalog.addBook("book 4", "15.06.2003", "reader 4");
        catalog.addBook("book 5", "16.07.2004", "reader 5");
        catalog.showBooks();
    }
}