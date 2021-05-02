package FacultyCompany.Core;

import FacultyCompany.Constants.ConfigurationConstants;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connection {

    public java.sql.Connection GetConnection() throws SQLException {
        var connectionURL = ConfigurationConstants.URL;
        var connectionUser = ConfigurationConstants.USER;
        var connectionPassword = ConfigurationConstants.PASSWORD;

        var connection = DriverManager.getConnection(connectionURL, connectionUser, connectionPassword);
        return connection;
    }
}
