package main.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReaderCardData {
    private int readerCardId;
    private int bookId;
    private int authorId;
    private StringProperty bookName;
    private StringProperty authorName;
    private StringProperty dateOfRelease;
    private StringProperty numOfPages;
    private StringProperty dateOfIssue;
    private StringProperty dateOfDelivery;

    public ReaderCardData(int readerCardId, int bookId, int authorId, String bookName, String authorName, String dateOfRelease,
                          String numOfPages, String dateOfIssue, String dateOfDelivery) {
        this.readerCardId = readerCardId;
        this.bookId = bookId;
        this.authorId = authorId;
        this.bookName = new SimpleStringProperty(bookName);
        this.authorName = new SimpleStringProperty(authorName);
        this.dateOfRelease = new SimpleStringProperty(dateOfRelease);
        this.numOfPages = new SimpleStringProperty(numOfPages);
        this.dateOfIssue = new SimpleStringProperty(dateOfIssue);
        this.dateOfDelivery = new SimpleStringProperty(dateOfDelivery);
    }

    public int getReaderCardId() {
        return readerCardId;
    }

    public void setReaderCardId(int readerCardId) {
        this.readerCardId = readerCardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getBookName() {
        return bookName.get();
    }

    public StringProperty bookNameProperty() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public String getAuthorName() {
        return authorName.get();
    }

    public StringProperty authorNameProperty() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName.set(authorName);
    }

    public String getDateOfRelease() {
        return dateOfRelease.get();
    }

    public StringProperty dateOfReleaseProperty() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease.set(dateOfRelease);
    }

    public String getNumOfPages() {
        return numOfPages.get();
    }

    public StringProperty numOfPagesProperty() {
        return numOfPages;
    }

    public void setNumOfPages(String numOfPages) {
        this.numOfPages.set(numOfPages);
    }

    public String getDateOfIssue() {
        return dateOfIssue.get();
    }

    public StringProperty dateOfIssueProperty() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue.set(dateOfIssue);
    }

    public String getDateOfDelivery() {
        return dateOfDelivery.get();
    }

    public StringProperty dateOfDeliveryProperty() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery.set(dateOfDelivery);
    }
}
