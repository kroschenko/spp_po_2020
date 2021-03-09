package db;

import connection.WrapperConnection;
import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO extends AbstractDAO<Author> {
    private static final Class<? extends Author> ctor = Author.class;
    private String sqlSelectAuthorId;

    public AuthorDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlSelectAll = "SELECT * FROM select_all_from_authors();";
        sqlSelectById = "SELECT * FROM select_by_id_from_authors(?);";
        sqlInsert = "SELECT insert_into_authors(?, ?, ?);";
        sqlUpdateById = "SELECT update_authors(?, ?, ?, ?);";
        sqlDeleteById = "SELECT delete_from_authors(?);";
        sqlSelectAuthorId = "SELECT get_author_id_from_authors(?, ?, ?)";
    }

    public int findAuthorId(String name, String surname, String middleName) throws DAOExtension  {
        int authorId = -1;
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectAuthorId);
            prStatement.setString(1, name);
            prStatement.setString(2, surname);
            prStatement.setString(3, middleName);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                authorId = rs.getInt(1);
            }
            rs.close();
            prStatement.close();
            return authorId;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authorId;
    }

    @Override
    public void setEntityCreateParams(Author entity, PreparedStatement pr) throws SQLException {
        prStatement.setString(1, entity.getName());
        prStatement.setString(2, entity.getSurname());
        prStatement.setString(3, entity.getMiddleName());
    }

    @Override
    public void setEntityUpdateParams(Author entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getId());
        prStatement.setString(2, entity.getName());
        prStatement.setString(3, entity.getSurname());
        prStatement.setString(4, entity.getMiddleName());
    }
}
