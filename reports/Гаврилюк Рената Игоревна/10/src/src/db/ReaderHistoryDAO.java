package db;

import entity.ReaderHistory;
import connection.WrapperConnection;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReaderHistoryDAO extends AbstractDAO<ReaderHistory>{
    private static final Class<? extends ReaderHistory> ctor = ReaderHistory.class;

    public ReaderHistoryDAO(Connection connection) throws NoSuchMethodException {
        super(connection, ctor);
        sqlSelectAll = "SELECT * FROM select_all_from_library_cards();";
        sqlSelectById = "SELECT * FROM select_by_id_from_library_cards(?);";
        sqlInsert = "SELECT insert_into_library_cards(?, ?, ?);";
        sqlUpdateById = "SELECT update_library_cards(?, ?, ?);";
        sqlDeleteById = "SELECT delete_from_library_cards(?);";
    }

    @Override
    public void setEntityCreateParams(ReaderHistory entity, PreparedStatement pr) throws SQLException {
        prStatement.setDate(1, java.sql.Date.valueOf(entity.getDateOfIssue()));
        prStatement.setDate(2, java.sql.Date.valueOf(entity.getDateOfDelivery()));
        prStatement.setInt(3, entity.getReaderId());
    }

    @Override
    public void setEntityUpdateParams(ReaderHistory entity, PreparedStatement pr) throws SQLException {
        prStatement.setInt(1, entity.getId());
        prStatement.setDate(2, java.sql.Date.valueOf(entity.getDateOfIssue()));
        prStatement.setDate(3, java.sql.Date.valueOf(entity.getDateOfDelivery()));
    }

    public List<ReaderHistory> findEntitiesByReaderId(int id) throws DAOExtension {
        List<ReaderHistory> readerHistories = new ArrayList<>();
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectById);
            prStatement.setInt(1, id);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                ReaderHistory readerHistory = new ReaderHistory();
                readerHistory.setResultSet(rs);
                readerHistories.add(readerHistory);
            }
            rs.close();
            prStatement.close();
            return readerHistories;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
