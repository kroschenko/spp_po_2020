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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import main.models.ReaderCardData;
import main.models.ReaderData;

import java.sql.Connection;
import java.util.List;

public class ReaderCardController {

    @FXML
    private TableView<ReaderCardData> readerCardTable;
    @FXML
    private TableColumn<ReaderCardData, String> bookColumn;
    @FXML
    private TableColumn<ReaderCardData, String> dateOfIssueColumn;
    @FXML
    private TableColumn<ReaderCardData, String> dateOfDeliveryColumn;

    @FXML
    private Label readerCardIdLabel;
    @FXML
    private Label readerNameLabel;
    @FXML
    private Label readerSurnameLabel;
    @FXML
    private Label readerMiddleNameLabel;


    @FXML
    private Label bookNameLabel;
    @FXML
    private Label authorLabel;
    @FXML
    private Label numOfPagesLabel;
    @FXML
    private Label yearOfReleaseLabel;
    @FXML
    private Label dateOfIssueLabel;
    @FXML
    private Label dateOfDeliveryLabel;

    private ReaderCardData currentReaderCardData;

    public static ReaderData currentReaderData;

    public ReaderCardController() {
        
    }

    @FXML
    private void initialize() throws Exception {
        // Инициализация таблицы адресатов с тремя столбцами.
        bookColumn.setCellValueFactory(cellData -> cellData.getValue().bookNameProperty() );
        dateOfIssueColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfIssueProperty());
        dateOfDeliveryColumn.setCellValueFactory(cellData -> cellData.getValue().dateOfDeliveryProperty());

        refresh();

        showReaderDetails();
        showReaderCardDetails(null);

        readerCardTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showReaderCardDetails(newValue));
    }

    public ReaderCardData getCurrentReaderData() {
        return currentReaderCardData;
    }

    public void setCurrentReaderCardData(ReaderCardData currentReaderCardData) {
        this.currentReaderCardData = currentReaderCardData;
    }

    public void setCurrentReaderData(ReaderData currentReaderData) {
        this.currentReaderData = currentReaderData;
    }

    private void refresh() throws Exception {
        showReaderDetails();
        ObservableList<ReaderCardData> readerCardData = FXCollections.observableArrayList();

        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderHistoryDAO readerHistoryDAO = new ReaderHistoryDAO(conn);
        ReaderCard_BooksDAO readerCardBooksDAO = new ReaderCard_BooksDAO(conn);
        Book_AuthorsDAO bookAuthorsDAO = new Book_AuthorsDAO(conn);
        BookDAO bookDAO = new BookDAO(conn);
        AuthorDAO authorDAO = new AuthorDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerHistoryDAO, readerCardBooksDAO, bookAuthorsDAO, bookDAO, authorDAO);

        // 3. query execution
        try {
            List<ReaderHistory> entries = readerHistoryDAO.findEntitiesByReaderId(currentReaderData.getReaderId());
            for (ReaderHistory entry : entries) {
                int bookId = readerCardBooksDAO.findEntityByReaderCardId(entry.getId()).get(0).getBookId();
                int authorId = bookAuthorsDAO.findEntitiesByBookId(bookId).get(0).getAuthorId();

                Book book = bookDAO.findEntityById(bookId);
                Author author = authorDAO.findEntityById(authorId);

                readerCardData.add(new ReaderCardData(entry.getId(), bookId, authorId, book.getName(), author.getSurname() + author.getName() + author.getMiddleName(),
                        String.valueOf(book.getDataOfRelease()), String.valueOf(book.getNumberOfPages()), entry.getDateOfIssue(), entry.getDateOfDelivery()));
            }
            transaction.commit();
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        readerCardTable.setItems(readerCardData);
    }

    private void showReaderCardDetails(ReaderCardData readerCardData) {
        setCurrentReaderCardData(readerCardData);
        if (readerCardData != null) {
            bookNameLabel.setText(readerCardData.getBookName());
            authorLabel.setText(readerCardData.getAuthorName());
            numOfPagesLabel.setText(readerCardData.getNumOfPages());
            yearOfReleaseLabel.setText(readerCardData.getDateOfRelease());
            dateOfIssueLabel.setText(readerCardData.getDateOfIssue());
            dateOfDeliveryLabel.setText(readerCardData.getDateOfDelivery());
        } else {
            bookNameLabel.setText("");
            authorLabel.setText("");
            numOfPagesLabel.setText("");
            yearOfReleaseLabel.setText("");
            dateOfIssueLabel.setText("");
            dateOfDeliveryLabel.setText("");
        }
    }

    private void showReaderDetails() {
        setCurrentReaderData(currentReaderData);
        if (currentReaderData != null) {
            readerNameLabel.setText(currentReaderData.getName());
            readerSurnameLabel.setText(currentReaderData.getSurname());
            readerMiddleNameLabel.setText(currentReaderData.getMiddleName());
            readerCardIdLabel.setText(currentReaderData.getReaderCardId());
        } else {
            readerNameLabel.setText("");
            readerSurnameLabel.setText("");
            readerMiddleNameLabel.setText("");
            readerCardIdLabel.setText("");
        }
    }

    public void addBookToReaderCard() {
        try {
            ReaderCardFormController.reader = new Reader(currentReaderData.getReaderId(), currentReaderData.getName(),
                    currentReaderData.getSurname(), currentReaderData.getMiddleName(), currentReaderData.getReaderCardId());
            ReaderCardFormController.STATE = false;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/readerCardForm.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSelectedBookFromReaderCard() throws Exception {
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderHistoryDAO readerHistoryDAO = new ReaderHistoryDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerHistoryDAO);

        // 3. query execution
        try {
            readerHistoryDAO.deleteEntityById(currentReaderCardData.getReaderCardId());
            transaction.commit();
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        refresh();
    }

    public void editReader() {
        ReaderFormController.setSTATE(true);
        ReaderFormController.setReader(new Reader(currentReaderData.getReaderId(), currentReaderData.getName(),
                currentReaderData.getSurname(), currentReaderData.getMiddleName(), currentReaderData.getReaderCardId()));
        openReaderForm();
    }

    private void openReaderForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/readerForm.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editBook() {
        try {
            BookController.STATE = true;
            BookController.book = new Book(currentReaderCardData.getBookId(), currentReaderCardData.getBookName(),
                    Integer.parseInt(currentReaderCardData.getDateOfRelease()),
                    Integer.parseInt(currentReaderCardData.getNumOfPages()));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/book.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editSelectedEntryInReaderCard() {
        try {
            ReaderCardFormController.reader = new Reader(currentReaderData.getReaderId(), currentReaderData.getName(),
                    currentReaderData.getSurname(), currentReaderData.getMiddleName(),
                    currentReaderData.getReaderCardId());
            ReaderCardFormController.readerHistory = new ReaderHistory(currentReaderCardData.getReaderCardId(),
                    currentReaderCardData.getDateOfIssue(), currentReaderCardData.getDateOfDelivery(),
                    currentReaderData.getReaderId());
            ReaderCardFormController.STATE = true;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/readerCardForm.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
