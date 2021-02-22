package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reader extends Person {
    private String readerCard;

    public Reader() { }

    public Reader(int id, String name, String surname, String middleName, String readerCard) {
        super(id, name, surname, middleName);
        this.readerCard = readerCard;
    }

    public Reader(String name, String surname, String middleName, String readerCard) {
        super(name, surname, middleName);
        this.readerCard = readerCard;
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setId(rs.getInt("reader_id"));
            this.setName(rs.getString("name"));
            this.setSurname(rs.getString("surname"));
            this.setMiddleName(rs.getString("middle_name"));
            this.setReaderCard(rs.getString("reader_card"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getReaderCard() {
        return readerCard;
    }

    public void setReaderCard(String readerCard) {
        this.readerCard = readerCard;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id='" + String.valueOf(super.getId()) + '\'' +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", middleName='" + super.getMiddleName() + '\'' +
                '}';
    }
}
