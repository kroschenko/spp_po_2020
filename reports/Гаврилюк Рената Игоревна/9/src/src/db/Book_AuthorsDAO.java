package db;

import entity.Book_Authors;
import entity.ReaderCard_Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Book_AuthorsDAO extends AbstratDoubleDAO<Book_Authors> {
    private static final Class<Book_Authors> ctor = Book_Authors.class;

    public Book_AuthorsDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlInsert = "SELECT insert_into_book_authors(?, ?);";
    }

    public List<Book_Authors> findEntitiesByBookId(int bookId) throws DAOExtension {
        sqlSelectById = "SELECT * FROM select_by_book_id_from_book_authors(?);";
        return findEntityById(bookId);
    }

    public List<Book_Authors> findEntitiesByAuthorId(int authorId) throws DAOExtension {
        sqlSelectById = "SELECT * FROM select_by_author_id_from_book_authors(?);";
        return findEntityById(authorId);
    }

    @Override
    public void setEntityCreateParams(Book_Authors entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getBookId());
        prStatement.setInt(2, entity.getAuthorId());
    }
}
