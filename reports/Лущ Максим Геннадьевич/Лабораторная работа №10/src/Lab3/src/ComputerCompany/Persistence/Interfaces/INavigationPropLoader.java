package ComputerCompany.Persistence.Interfaces;

import java.sql.SQLException;

public interface INavigationPropLoader<T> {
    public T LoadNavigationProperties(T entity) throws SQLException;
}
