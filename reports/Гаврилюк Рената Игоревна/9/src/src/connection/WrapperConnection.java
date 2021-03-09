package connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class WrapperConnection {
    private static String DB_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;
    private static Connection connection = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/properties/database.properties"));

            DB_URL = (String) properties.get("db.url");
            DB_USER = (String) properties.get("db.user");
            DB_PASSWORD = (String) properties.get("db.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WrapperConnection() {}

    public static Connection createConnection() throws IOException {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public static Statement getStatement() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or statement is null");
    }

    public static void closeStatement(Statement statement) throws SQLException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("statement is null " + e);
            }
        }
    }
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        if (connection != null) {
            PreparedStatement statement = connection.prepareStatement(sql);
            if (statement != null) {
                return statement;
            }
        }
        throw new SQLException("connection or Prepared statement is null");
    }

    public static void closePreparedStatement(PreparedStatement statement) throws SQLException {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println("Prepared statement is null " + e);
            }
        }
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
