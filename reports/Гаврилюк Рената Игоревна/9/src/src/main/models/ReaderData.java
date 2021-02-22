package main.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReaderData {
    private StringProperty FIO;
    private final int readerId;
    private final StringProperty name;
    private final StringProperty surname;
    private final StringProperty middleName;
    private final StringProperty readerCardId;

    public ReaderData() {
        this(0, null, null, null, null);
    }

    public ReaderData(int readerId, String name, String surname, String middleName, String readerCardId) {
        this.readerId = readerId;
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.middleName = new SimpleStringProperty(middleName);
        this.FIO = new SimpleStringProperty(surname + " " + name + " " + middleName);
        this.readerCardId = new SimpleStringProperty(readerCardId);
    }

    public StringProperty FIOProperty() {
        return FIO;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getReaderCardId() {
        return readerCardId.get();
    }

    public StringProperty readerCardIdProperty() {
        return readerCardId;
    }

    public void setReaderCardId(String readerCardId) {
        this.readerCardId.set(readerCardId);
    }

    public String getFIO() {
        return FIO.get();
    }

    public void setFIO(String FIO) {
        this.FIO.set(FIO);
    }

    public int getReaderId() {
        return readerId;
    }
}
