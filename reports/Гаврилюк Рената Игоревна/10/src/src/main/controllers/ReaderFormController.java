package main.controllers;

import db.DAOExtension;
import db.EntityTransaction;
import db.ReaderDAO;
import entity.Reader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import connection.PgsqlFactory;
import connection.WrapperConnection;
import main.models.ReaderData;

import java.sql.Connection;

public class ReaderFormController {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField middleNameTextField;
    @FXML
    private TextField numberCardTextField;
    @FXML
    private Button createUpdateButton;
    @FXML
    private Label titleLabel;

    private static Reader reader;
    private static boolean STATE; //true - update, false - insert

    public static void setReader(Reader reader) {
        ReaderFormController.reader = reader;
    }

    public static void setSTATE(boolean STATE) {
        ReaderFormController.STATE = STATE;
    }

    @FXML
    public void initialize() {
        if (STATE) {
            nameTextField.setText(reader.getName());
            surnameTextField.setText(reader.getSurname());
            middleNameTextField.setText(reader.getMiddleName());
            numberCardTextField.setText(reader.getReaderCard());
            createUpdateButton.setText("Редактировать");
            titleLabel.setText("Редактировать читателя");
        }
    }

    public void createOrUpdateReader() throws Exception {
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderDAO readerDAO = new ReaderDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerDAO);

        // 3. query execution
        try {
            if (STATE) {
                readerDAO.updateEntity(new Reader(reader.getId(), nameTextField.getText(), surnameTextField.getText(),
                        middleNameTextField.getText(), numberCardTextField.getText()));

                ReaderCardController.currentReaderData = new ReaderData(reader.getId(), nameTextField.getText(), surnameTextField.getText(),
                        middleNameTextField.getText(), numberCardTextField.getText());
            }
            else {
                readerDAO.createEntity(new Reader(nameTextField.getText(), surnameTextField.getText(),
                        middleNameTextField.getText(), numberCardTextField.getText()));
            }
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
        Stage stage = (Stage) numberCardTextField.getScene().getWindow();
        stage.close();
    }
}
