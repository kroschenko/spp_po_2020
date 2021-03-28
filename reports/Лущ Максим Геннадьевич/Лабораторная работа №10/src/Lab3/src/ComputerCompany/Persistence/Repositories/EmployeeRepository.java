package ComputerCompany.Persistence.Repositories;
import ComputerCompany.Entities.Employee;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Interfaces.INavigationPropLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeRepository implements IBaseRepository<Employee> {

    private final Connection connection;
    private INavigationPropLoader<Employee> employeeINavigationPropLoader;

    public EmployeeRepository(Connection connection)
    {
        this.connection = connection;
    }
    public EmployeeRepository(Connection connection, INavigationPropLoader<Employee> employeeINavigationPropLoader)
    {
        this.connection = connection;
        this.employeeINavigationPropLoader = employeeINavigationPropLoader;
    }

    @Override
    public Employee Add(Employee entity) throws SQLException {
        var query =
            "INSERT INTO [dbo].[Employees]" +
            "       ([IsWork]" +
            "       ,[DepartmentId]" +
            "       ,[AddressId]" +
            "       ,[LastName]" +
            "       ,[FirstName])" +
            "   VALUES" +
            "       (?,?,?,?,?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setBoolean(1, entity.isWork());
        statement.setInt(2, entity.getDepartmentId());
        statement.setInt(3, entity.getAddressId());
        statement.setString(4, entity.getLastName());
        statement.setString(5, entity.getFirstName());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Employee entity) throws SQLException {
        var query =
            "UPDATE [dbo].[Employees]" +
            "   SET [IsWork] = ?" +
            "       ,[DepartmentId] = ?" +
            "       ,[AddressId] = ?" +
            "       ,[LastName] = ?" +
            "       ,[FirstName] = ?" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setBoolean(1, entity.isWork());
        statement.setInt(2, entity.getDepartmentId());
        statement.setInt(3, entity.getAddressId());
        statement.setString(4, entity.getLastName());
        statement.setString(5, entity.getFirstName());
        statement.setInt(6, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Employee entity) throws SQLException {
        var query =
            "DELETE FROM [dbo].[Employees]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Employee GetByIdOrNull(int id) throws SQLException {
        var query =
            "SELECT * FROM [dbo].[Employees]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if (reader.next())
        {
            var result = new Employee();
            result.setId(reader.getInt("Id"));
            result.setWork(reader.getBoolean("IsWork"));
            result.setDepartmentId(reader.getInt("DepartmentId"));
            result.setAddressId(reader.getInt("AddressId"));
            result.setFirstName(reader.getString("FirstName"));
            result.setLastName(reader.getString("LastName"));

            if (employeeINavigationPropLoader != null)
            {
                employeeINavigationPropLoader.LoadNavigationProperties(result);
            }

            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Employee> GetAll() throws SQLException {
        var query = "SELECT * FROM [dbo].[Employees]";

        var statement = connection.prepareStatement(query);
        var reader = statement.executeQuery();

        var result = new ArrayList<Employee>();
        while (reader.next())
        {
            var employee = new Employee();
            employee.setId(reader.getInt("Id"));
            employee.setWork(reader.getBoolean("IsWork"));
            employee.setDepartmentId(reader.getInt("DepartmentId"));
            employee.setAddressId(reader.getInt("AddressId"));
            employee.setFirstName(reader.getString("FirstName"));
            employee.setLastName(reader.getString("LastName"));

            if (employeeINavigationPropLoader != null)
            {
                employeeINavigationPropLoader.LoadNavigationProperties(employee);
            }

            result.add(employee);
        }

        return result;
    }
}
