package db;

import connection.WrapperConnection;
import entity.Book;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookDAO extends AbstractDAO<Book>{
    private static final Class<? extends Book> ctor = Book.class;
    private String sqlSelectBookId;

    public BookDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlSelectAll = "SELECT * FROM select_all_from_books();";
        sqlSelectById = "SELECT * FROM select_by_id_from_books(?);";
        sqlInsert = "SELECT insert_into_books(?, ?, ?);";
        sqlUpdateById = "SELECT update_books(?, ?, ?, ?);";
        sqlDeleteById = "SELECT delete_from_books(?);";
        sqlSelectBookId = "SELECT get_book_id_from_books(?, ?, ?)";
    }

    public int findBookId(String name, int dateOfRelease, int numOfPages) throws DAOExtension  {
        int bookId = -1;
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectBookId);
            prStatement.setString(1, name);
            prStatement.setInt(2, numOfPages);
            prStatement.setInt(3, dateOfRelease);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                bookId = rs.getInt(1);
            }
            rs.close();
            prStatement.close();
            return bookId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookId;
    }

    @Override
    public void setEntityCreateParams(Book entity, PreparedStatement pr) throws SQLException {
        prStatement.setString(1, entity.getName());
        prStatement.setInt(2, entity.getNumberOfPages());
        prStatement.setInt(3, entity.getDataOfRelease());
    }

    @Override
    public void setEntityUpdateParams(Book entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getId());
        prStatement.setString(2, entity.getName());
        prStatement.setInt(3, entity.getNumberOfPages());
        prStatement.setInt(4, entity.getDataOfRelease());
    }
}
