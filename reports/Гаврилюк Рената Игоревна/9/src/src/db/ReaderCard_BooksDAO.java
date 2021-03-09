package db;

import entity.ReaderCard_Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ReaderCard_BooksDAO extends AbstratDoubleDAO<ReaderCard_Books> {
    private static final Class<? extends ReaderCard_Books> ctor = ReaderCard_Books.class;

    public ReaderCard_BooksDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlInsert = "SELECT insert_into_library_card_books(?, ?);";
    }

    public List<ReaderCard_Books> findEntityByBookId(int bookId) throws DAOExtension {
        sqlSelectById = "SELECT * FROM select_by_book_id_from_card_books(?);";
        return findEntityById(bookId);
    }

    public List<ReaderCard_Books> findEntityByReaderCardId(int readerCardId) throws DAOExtension {
        sqlSelectById = "SELECT * FROM select_by_library_card_id_from_card_books(?);";
        return findEntityById(readerCardId);
    }

    @Override
    public void setEntityCreateParams(ReaderCard_Books entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getBookId());
        prStatement.setInt(2, entity.getReaderCardId());
    }
}
