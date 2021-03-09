package db;

import entity.Entity;
import connection.WrapperConnection;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstratDoubleDAO <T extends Entity> extends DAO<T> {
    protected String sqlSelectById;
    protected String sqlInsert;

    public AbstratDoubleDAO(Connection connection, Class<? extends T> ctor) throws NoSuchMethodException {
        super(connection, ctor);
    }

    protected List<T> findEntityById(int id) throws DAOExtension {
        List<T> entities = new ArrayList<>();
        try {
            prStatement = WrapperConnection.getPreparedStatement(sqlSelectById);
            prStatement.setInt(1, id);
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

    public abstract void setEntityCreateParams(T entity, PreparedStatement pr) throws SQLException;

}
