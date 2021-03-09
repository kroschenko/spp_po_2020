package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderHistory extends Entity{
    private String dateOfIssue;
    private String dateOfDelivery;
    private int readerId;

    public ReaderHistory() { }

    public ReaderHistory(int id, int readerId) {
        super(id);
        this.readerId = readerId;
    }

    public ReaderHistory(int id, String dateOfIssue, String dateOfDelivery, int readerId) {
        super(id);
        this.dateOfIssue = dateOfIssue;
        this.dateOfDelivery = dateOfDelivery;
        this.readerId = readerId;
    }

    public ReaderHistory(int readerId) {
        this.readerId = readerId;
    }

    public ReaderHistory(String dateOfIssue, String dateOfDelivery, int readerId) {
        this.dateOfIssue = dateOfIssue;
        this.dateOfDelivery = dateOfDelivery;
        this.readerId = readerId;
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setId(rs.getInt("library_card_id"));
            this.setDateOfIssue(rs.getString("date_of_issue"));
            this.setDateOfDelivery(rs.getString("date_of_delivery"));
            this.setReaderId(rs.getInt("reader_id"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "ReaderCard{" +
                "id='" + super.getId() + '\'' +
                "dateOfIssues=" + dateOfIssue +
                ", dateOfDeliveries=" + dateOfDelivery +
                ", reader_id=" + readerId +
                '}';
    }
}
