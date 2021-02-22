package main.controllers;

import connection.PgsqlFactory;
import connection.WrapperConnection;
import db.*;
import entity.Author;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;

public class AuthorController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField middleNameTextField;

    public void createAuthor() throws Exception {
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        AuthorDAO authorDAO = new AuthorDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(authorDAO);

        // 3. query execution
        try {
            authorDAO.createEntity(new Author(nameTextField.getText(), surnameTextField.getText(),
                    middleNameTextField.getText()));
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        closeWindow();
    }

    public void cancelChanges() {
        closeWindow();
    }

    public void closeWindow() {
        Stage stage = (Stage) nameTextField.getScene().getWindow();
        stage.close();
    }
}
