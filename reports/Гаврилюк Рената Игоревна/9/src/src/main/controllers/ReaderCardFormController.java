package main.controllers;

import connection.PgsqlFactory;
import connection.WrapperConnection;
import db.*;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReaderCardFormController {
    @FXML
    private Label titleLabel;
    @FXML
    private ComboBox bookComboBox;
    @FXML
    private DatePicker dateOfIssueDatePicker;
    @FXML
    private DatePicker dateOfDeliveryDatePicker;
    @FXML
    private Button addEditButton;

    public static Reader reader;
    public static ReaderHistory readerHistory;
    public static boolean STATE; //true - update, false - insert

    private ObservableList<String> getBooks() throws Exception {
        ObservableList<String> containers = FXCollections.observableArrayList();

        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        BookDAO bookDAO = new BookDAO(conn);
        ReaderCard_BooksDAO readerCardBooks = new ReaderCard_BooksDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(bookDAO, readerCardBooks);

        int bookId = 0;

        List<Book> books;
        // 3. query execution
        try {
            books = bookDAO.findAll();
            if(STATE) {
                bookId = readerCardBooks.findEntityByReaderCardId(readerHistory.getId()).get(0).getBookId();
            }
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        containers.add(0, "Новая книга");
        for (Book book : books) {
            containers.add(book.getName() +" (" + book.getDataOfRelease() + "г., " + book.getNumberOfPages() + "стр.)");
            if(STATE) {
                if(book.getId() == bookId) {
                    bookComboBox.setValue(containers.get(containers.size() - 1));
                }
            }
        }
        return containers;
    }

    @FXML
    void initialize() throws Exception {
        bookComboBox.setItems(getBooks());

        if(STATE) {
            titleLabel.setText("Редактировать книгу");
            addEditButton.setText("Редактировать");
            dateOfIssueDatePicker.setValue(LocalDate.parse(readerHistory.getDateOfIssue()));
            dateOfDeliveryDatePicker.setValue(LocalDate.parse(readerHistory.getDateOfDelivery()));
        }

        bookComboBox.valueProperty().addListener(
                observable -> {
                    try {
                        checkSelectedBook();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void checkSelectedBook() throws Exception {
        if (bookComboBox.getValue() != null) {
            String selectedValue = bookComboBox.getValue().toString();
            if (selectedValue.equals("Новая книга")) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/book.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                bookComboBox.getItems().clear();
                bookComboBox.setItems(getBooks());
                bookComboBox.setValue(getBooks().get(getBooks().size() - 1));
            }
        }
    }

    public void createOrUpdateBook() throws Exception {
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderHistoryDAO readerHistoryDAO = new ReaderHistoryDAO(conn);
        ReaderCard_BooksDAO readerCardBooksDAO = new ReaderCard_BooksDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerHistoryDAO);

        // 3. query execution
        try {
            if(STATE) {
                System.out.println(readerHistory.getId());
                System.out.println(dateOfIssueDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                System.out.println(dateOfDeliveryDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                readerHistoryDAO.updateEntity(new ReaderHistory(readerHistory.getId(), dateOfIssueDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        dateOfDeliveryDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), readerHistory.getReaderId()));
            } else {
                System.out.println(reader.getId());
                readerHistoryDAO.createEntity(new ReaderHistory(dateOfIssueDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        dateOfDeliveryDatePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), reader.getId()));
            }
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();

            // 2. transaction initialization for DAO objects
            transaction.initTransaction(readerCardBooksDAO);
            // 3. query execution
            try {
                if(!STATE) {
                    readerCardBooksDAO.createEntity(new ReaderCard_Books(getReaderCardId(), getBookId()));
                }
            } catch (DAOExtension e) {
                transaction.rollback();
                throw new Exception(e);
            } finally {
                // 4. transaction closing
                transaction.endTransaction();
            }
        }

        conn.close();
        closeWindow();
    }

    public int getReaderCardId() throws Exception {
        int readerCardId = 0;
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderHistoryDAO readerHistoryDAO = new ReaderHistoryDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerHistoryDAO);

        // 3. query execution
        try {
            readerCardId = readerHistoryDAO.findAll().get(readerHistoryDAO.findAll().size() - 1).getId();
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();
        closeWindow();
        return readerCardId;
    }

    public int getBookId() throws Exception {
        int bookId = 0;
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        BookDAO bookDAO = new BookDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(bookDAO);

        String bookInfo = bookComboBox.getValue().toString();

        String bookName = bookInfo.substring(0, bookInfo.indexOf(' '));
        int dateOfRelease = Integer.parseInt(bookInfo.substring(bookInfo.indexOf('(') + 1, bookInfo.lastIndexOf("г., ")));
        int numberOfPages = Integer.parseInt(bookInfo.substring(bookInfo.lastIndexOf("г., ") + 4, bookInfo.lastIndexOf("стр.)")));

        // 3. query execution
        try {
            bookId = bookDAO.findBookId(bookName, dateOfRelease, numberOfPages);
            System.out.println(bookName + dateOfRelease + numberOfPages + "-");
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();
        closeWindow();
        return bookId;
    }

    public void cancelChanges() {
        closeWindow();
    }

    public void closeWindow() {
        Stage stage = (Stage) titleLabel.getScene().getWindow();
        stage.close();
    }

}
