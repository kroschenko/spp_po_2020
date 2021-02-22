package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person extends Entity{
    private String name;
    private String surname;
    private String middleName;

    public Person() { }

    public Person(int id, String name, String surname, String middleName) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public Person(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public void setResultSet(ResultSet rs) throws SQLException {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
