package main.controllers;

import connection.PgsqlFactory;
import connection.WrapperConnection;
import db.*;
import entity.Author;
import entity.Book;
import entity.Book_Authors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.util.List;

public class BookController {
    @FXML
    private Label titleLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox authorComboBox;
    @FXML
    private TextField dateOfReleaseTextField;
    @FXML
    private TextField numOfPagesTextField;
    @FXML
    private Button createUpdateButton;

    public static Book book;
    public static boolean STATE; //true - update, false - insert

    private ObservableList<String> getAuthors() throws Exception {
        ObservableList<String> containers = FXCollections.observableArrayList();

        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        AuthorDAO authorDAO = new AuthorDAO(conn);
        Book_AuthorsDAO bookAuthorsDAO = new Book_AuthorsDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(authorDAO, bookAuthorsDAO);

        int authorId = 0;

        List<Author> authors;
        // 3. query execution
        try {
            authors = authorDAO.findAll();
            if(STATE) {
                authorId = bookAuthorsDAO.findEntitiesByBookId(book.getId()).get(0).getAuthorId();
            }
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        containers.add(0, "Новый автор");
        for (Author author : authors) {
            containers.add(author.getSurname() + " " + author.getName() + " " + author.getMiddleName());
            if(STATE) {
                if(author.getId() == authorId) {
                    authorComboBox.setValue(containers.get(containers.size() - 1));
                }
            }
        }
        return containers;
    }

    @FXML
    void initialize() throws Exception {
        authorComboBox.setItems(getAuthors());

        if(STATE) {
            titleLabel.setText("Редактировать книгу");
            createUpdateButton.setText("Редактировать");
            nameTextField.setText(book.getName());
            dateOfReleaseTextField.setText(String.valueOf(book.getDataOfRelease()));
            numOfPagesTextField.setText(String.valueOf(book.getNumberOfPages()));
        }

        authorComboBox.valueProperty().addListener(
                observable -> {
                    try {
                        checkSelectedAuthor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void checkSelectedAuthor() throws Exception {
        if (authorComboBox.getValue() != null) {
            String selectedValue = authorComboBox.getValue().toString();
            if (selectedValue.equals("Новый автор")) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/author.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
                authorComboBox.getItems().clear();
                authorComboBox.setItems(getAuthors());
                authorComboBox.setValue(getAuthors().get(getAuthors().size() - 1));
            }
        }
    }

    public void createOrUpdateBook() throws Exception {
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        BookDAO bookDAO = new BookDAO(conn);
        Book_AuthorsDAO bookAuthorsDAO = new Book_AuthorsDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(bookDAO);

        // 3. query execution
        try {
            if(STATE) {
                bookDAO.updateEntity(new Book(book.getId(), nameTextField.getText(), Integer.parseInt(numOfPagesTextField.getText()),
                        Integer.parseInt(dateOfReleaseTextField.getText())));
            } else {
                bookDAO.createEntity(new Book(nameTextField.getText(), Integer.parseInt(numOfPagesTextField.getText()),
                        Integer.parseInt(dateOfReleaseTextField.getText())));
            }
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();

            // 2. transaction initialization for DAO objects
            transaction.initTransaction(bookAuthorsDAO);
            // 3. query execution
            try {
                bookAuthorsDAO.createEntity(new Book_Authors(getBookId(), getAuthorId()));
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

    public int getBookId() throws Exception {
        int bookId = 0;
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        BookDAO bookDAO = new BookDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(bookDAO);

        // 3. query execution
        try {
            bookId = bookDAO.findBookId(nameTextField.getText(), Integer.parseInt(numOfPagesTextField.getText()),
                    Integer.parseInt(dateOfReleaseTextField.getText()));
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

    public int getAuthorId() throws Exception {
        int authorId = 0;
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        AuthorDAO authorDAO = new AuthorDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(authorDAO);

        String NSM = authorComboBox.getValue().toString();

        String surname = NSM.substring(0, NSM.indexOf(' '));
        String name = NSM.substring(NSM.indexOf(' ') + 1, NSM.lastIndexOf(' '));
        String middleName = NSM.substring(NSM.lastIndexOf(' ') + 1);

        // 3. query execution
        try {
            authorId = authorDAO.findAuthorId(name, surname, middleName);
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        closeWindow();
        return authorId;
    }

    public void cancelChanges() {
        closeWindow();
    }

    public void closeWindow() {
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
}
