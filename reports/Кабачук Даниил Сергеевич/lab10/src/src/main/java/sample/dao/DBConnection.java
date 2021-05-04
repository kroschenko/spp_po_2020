package sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static final String URL = "jdbc:h2:mem:test;INIT=runscript from 'src/main/resources/sql/schema1.sql'\\;" +
                               "runscript from 'src/main/resources/sql/data.sql'";

    static final String USER = "sa";
    static final String PASS = "";

    public static Connection connection = null;

    public static void getConnection() throws SQLException {

        if(connection == null)
        connection = DriverManager.getConnection(URL, "sa", "");

    }
}
