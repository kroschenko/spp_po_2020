package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book_Authors extends Entity{
    private int bookId;
    private int authorId;

    public Book_Authors() { }

    public Book_Authors(int bookId, int authorId) {
        this.bookId = bookId;
        this.authorId = authorId;
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setBookId(rs.getInt("book_id"));
            this.setAuthorId(rs.getInt("author_id"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Book_Authors{" +
                "bookId=" + bookId +
                ", authorId=" + authorId +
                '}';
    }
}
