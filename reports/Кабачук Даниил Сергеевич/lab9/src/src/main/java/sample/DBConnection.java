package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String DB_URL = "jdbc:h2:~/test";
    String URL = "jdbc:h2:mem:test;INIT=runscript from 'src/main/java/sample/schema1.sql'\\;runscript from 'src/main/java/sample/data.sql'";

    static final String USER = "sa";
    static final String PASS = "";

    Connection connection = null;

    public Connection getConnection() throws SQLException {

        connection = DriverManager.getConnection(URL, "sa", "");

        return connection;
    }
}
