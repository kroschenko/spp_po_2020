package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderCard_Books extends Entity{
    private int readerCardId;
    private int bookId;

    public ReaderCard_Books() { }

    public ReaderCard_Books(int readerCardId, int bookId) {
        this.readerCardId = readerCardId;
        this.bookId = bookId;
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setBookId(rs.getInt("book_id"));
            this.setReaderCardId(rs.getInt("library_card_id"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getReaderCardId() {
        return readerCardId;
    }

    public void setReaderCardId(int readerCardId) {
        this.readerCardId = readerCardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "ReaderCard_Books{" +
                "readerCardId=" + readerCardId +
                ", bookId=" + bookId +
                '}';
    }
}
