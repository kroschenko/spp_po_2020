package main.controllers;

import db.DAOExtension;
import db.EntityTransaction;
import db.ReaderDAO;
import db.ReaderHistoryDAO;
import entity.Reader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import connection.PgsqlFactory;
import connection.WrapperConnection;
import main.models.ReaderData;

import java.sql.Connection;
import java.util.List;

public class ReaderController {

    @FXML
    private TableView<ReaderData> readerTable;
    @FXML
    private TableColumn<ReaderData, String> FIOColumn;
    @FXML
    private TableColumn<ReaderData, String> readerCardColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label middleNameLabel;
    @FXML
    private Label readerCardIdLabel;

    @FXML
    private TextField findTextField;

    private ReaderData currentReaderData;

    public ReaderController() { }

    @FXML
    private void initialize() throws Exception {
        // Инициализация таблицы адресатов с двумя столбцами.
        FIOColumn.setCellValueFactory(cellData -> cellData.getValue().FIOProperty() );
        readerCardColumn.setCellValueFactory(cellData -> cellData.getValue().readerCardIdProperty());

        refresh();

        showPersonDetails(null);

        readerTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    public ReaderData getCurrentReaderData() {
        return currentReaderData;
    }

    public void setCurrentReaderData(ReaderData currentReaderData) {
        this.currentReaderData = currentReaderData;
    }

    public void initializeTable(boolean search) throws Exception{
        ObservableList<ReaderData> personData = FXCollections.observableArrayList();

        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderDAO readerDAO = new ReaderDAO(conn);
        ReaderHistoryDAO readerHistoryDAO = new ReaderHistoryDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerDAO, readerHistoryDAO);

        // 3. query execution
        try {
            List<Reader> readers = readerDAO.findAll();
            transaction.commit();
            for (Reader reader : readers) {
                if(search) {
                    if((reader.getSurname() + reader.getName() + reader.getMiddleName()).contains(findTextField.getText())) {
                        personData.add(new ReaderData(reader.getId(), reader.getName(), reader.getSurname(),
                                reader.getMiddleName(), reader.getReaderCard()));
                    }
                }
                else {
                    personData.add(new ReaderData(reader.getId(), reader.getName(), reader.getSurname(),
                            reader.getMiddleName(), reader.getReaderCard()));
                }
            }
        } catch (DAOExtension e) {
            transaction.rollback();
            throw new Exception(e);
        } finally {
            // 4. transaction closing
            transaction.endTransaction();
        }

        conn.close();

        readerTable.setItems(personData);
    }

    private void refresh() throws Exception {
        initializeTable(false);
    }

    private void showPersonDetails(ReaderData readerData) {
        setCurrentReaderData(readerData);
        if (readerData != null) {
            nameLabel.setText(readerData.getName());
            surnameLabel.setText(readerData.getSurname());
            middleNameLabel.setText(readerData.getMiddleName());
            readerCardIdLabel.setText(readerData.getReaderCardId());
        } else {
            nameLabel.setText("");
            surnameLabel.setText("");
            middleNameLabel.setText("");
            readerCardIdLabel.setText("");
        }
    }

    public void deleteSelectedReader() throws Exception{
        PgsqlFactory.createDataConnection();
        Connection conn = WrapperConnection.createConnection();

        // 1. init DAO
        ReaderDAO readerDAO = new ReaderDAO(conn);

        // 2. transaction initialization for DAO objects
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(readerDAO);

        // 3. query execution
        try {
            readerDAO.deleteEntityById(currentReaderData.getReaderId());
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

    public void findReaders() throws Exception{
        initializeTable(true);
    }

    public void openReaderCardForm() {
        try {
            ReaderCardController.currentReaderData = new ReaderData(currentReaderData.getReaderId(), currentReaderData.getName(),
                    currentReaderData.getSurname(), currentReaderData.getMiddleName(), currentReaderData.getReaderCardId());

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../assets/readerCard.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createReader() {
        ReaderFormController.setSTATE(false);
        ReaderFormController.setReader(null);
        openReaderForm();
    }

    public void updateReader() {
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
}
