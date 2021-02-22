package db;

import entity.Reader;

import java.sql.*;

public class ReaderDAO extends AbstractDAO<Reader> {
    private static final Class<? extends Reader> ctor = Reader.class;

    public ReaderDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlSelectAll = "SELECT * FROM select_all_from_readers();";
        sqlSelectById = "SELECT * FROM select_by_id_from_readers(?);";
        sqlInsert = "SELECT insert_into_readers(?, ?, ?, ?);";
        sqlUpdateById = "SELECT update_readers(?, ?, ?, ?, ?);";
        sqlDeleteById = "SELECT delete_from_readers(?);";
    }

    @Override
    public void setEntityCreateParams(Reader entity, PreparedStatement pr) throws SQLException {
        prStatement.setString(1, entity.getName());
        prStatement.setString(2, entity.getSurname());
        prStatement.setString(3, entity.getMiddleName());
        prStatement.setString(4, entity.getReaderCard());
    }

    @Override
    public void setEntityUpdateParams(Reader entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getId());
        prStatement.setString(2, entity.getName());
        prStatement.setString(3, entity.getSurname());
        prStatement.setString(4, entity.getMiddleName());
        prStatement.setString(5, entity.getReaderCard());
    }
}
