package db;

import entity.Entity;
import connection.WrapperConnection;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.*;

public abstract class DAO <T extends Entity> {
    protected Connection connection;
    protected PreparedStatement prStatement;

    protected final Constructor<? extends T> ctor;

    public DAO(Connection connection, Class<? extends T> ctor) throws NoSuchMethodException {
        this.ctor = ctor.getConstructor();
        try {
            this.connection = WrapperConnection.createConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() throws SQLException {
        return WrapperConnection.getStatement();
    }

    public void closeStatement(Statement st) throws SQLException {
        WrapperConnection.closeStatement(st);
    }
}
