package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book extends Entity{
    private String name;
    private int dataOfRelease;
    private int numberOfPages;

    public Book() { }

    public Book(int id, String name, int dataOfRelease, int numberOfPages) {
        super(id);
        this.name = name;
        this.dataOfRelease = dataOfRelease;
        this.numberOfPages = numberOfPages;
    }

    public Book(String name, int dataOfRelease, int numberOfPages) {
        this.name = name;
        this.dataOfRelease = dataOfRelease;
        this.numberOfPages = numberOfPages;
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setId(rs.getInt("book_id"));
            this.setName(rs.getString("name"));
            this.setNumberOfPages(rs.getInt("number_of_pages"));
            this.setDataOfRelease(rs.getInt("date_of_release"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDataOfRelease() {
        return dataOfRelease;
    }

    public void setDataOfRelease(int dataOfRelease) {
        this.dataOfRelease = dataOfRelease;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + super.getId() + '\'' +
                "name='" + name + '\'' +
                ", dataOfRelease='" + dataOfRelease + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
