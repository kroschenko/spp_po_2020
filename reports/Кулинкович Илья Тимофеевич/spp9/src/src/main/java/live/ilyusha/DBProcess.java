package live.ilyusha;

import java.sql.*;

public class DBProcess {
    private static final String url = "jdbc:sqlite:sample.db";
    public Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public Savepoint point;

    public DBProcess() {
        try {
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void insert(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public ResultSet select(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        return rs;
    }

    public void delete(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public void update(String query) throws SQLException {
        stmt.executeUpdate(query);
    }
}