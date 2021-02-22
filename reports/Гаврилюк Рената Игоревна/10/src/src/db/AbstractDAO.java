package db;

import entity.Entity;
import connection.WrapperConnection;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO <T extends Entity> extends DAO<T> {
    protected String sqlSelectAll;
    protected String sqlSelectById;
    protected String sqlDeleteById;
    protected String sqlUpdateById;
    protected String sqlInsert;

    public AbstractDAO(Connection connection, Class<? extends T> ctor) throws NoSuchMethodException {
        super(connection, ctor);
    }

    public List<T> findAll() throws DAOExtension {
        List<T> entities = new ArrayList<>();
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectAll);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                T entity = ctor.newInstance();
                entity.setResultSet(rs);
                entities.add(entity);
            }
            rs.close();
            prStatement.close();
            return entities;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findEntityById(int id) throws DAOExtension {
        T entity = null;
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectById);
            prStatement.setInt(1, id);
            ResultSet rs = prStatement.executeQuery();
            while (rs.next()) {
                entity = ctor.newInstance();
                entity.setResultSet(rs);
            }
            rs.close();
            prStatement.close();
            return entity;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteEntityById(int id) throws DAOExtension {
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlDeleteById);
            prStatement.setInt(1, id);
            prStatement.execute();
            prStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean deleteEntity(T entity) throws DAOExtension {
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlDeleteById);
            prStatement.setInt(1, entity.getId());
            prStatement.execute();
            prStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean createEntity(T entity) throws DAOExtension {
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlInsert);
            this.setEntityCreateParams(entity, prStatement);
            prStatement.execute();
            prStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean updateEntity(T entity) throws DAOExtension {
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlUpdateById);
            this.setEntityUpdateParams(entity, prStatement);
            prStatement.execute();
            prStatement.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public abstract void setEntityCreateParams(T entity, PreparedStatement pr) throws SQLException;
    public abstract void setEntityUpdateParams(T entity, PreparedStatement pr) throws SQLException;
}
