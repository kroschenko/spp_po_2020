package db;

import connection.WrapperConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    private Connection connection;

    public void initTransaction(DAO dao, DAO ... daos) throws IOException {
        if (connection == null) {
            connection = WrapperConnection.createConnection();
        }

        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        dao.setConnection(connection);
        for (DAO daoElement : daos) {
            daoElement.setConnection(connection);
        }
    }

    public void endTransaction() {
        // connection check code of null
        try {
            // connection check code for commit
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // connection return code to the pool or closing
        connection = null;
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    //not fot transactions
    public void init(AbstractDAO dao) throws IOException {
        if (connection == null) {
            connection = WrapperConnection.createConnection();
        }
        dao.setConnection(connection);
    }

    public void end() {
        // code -> check of null connection
        // code -> return connection to pool or closing
        connection = null;
    }
}
