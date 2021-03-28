package ComputerCompany.Persistence.Repositories;

import ComputerCompany.Entities.Department;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentRepository implements IBaseRepository<Department> {

    private final Connection connection;

    public DepartmentRepository(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Department Add(Department entity) throws SQLException {
        var query =
            "INSERT INTO [dbo].[Departments]" +
            "       ([Name]" +
            "       ,[GroupName])" +
            "   VALUES" +
            "       (?,?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getGroupName());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Department entity) throws SQLException {
        var query =
            "UPDATE [dbo].[Departments]" +
            "   SET [Name] = ?" +
            "       ,[GroupName] = ?" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setString(1, entity.getName());
        statement.setString(2, entity.getGroupName());
        statement.setInt(3, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Department entity) throws SQLException {
        var query =
            "DELETE FROM [dbo].[Departments]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Department GetByIdOrNull(int id) throws SQLException {
        var query =
            "SELECT * FROM [dbo].[Departments]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Department();
            result.setId(reader.getInt("Id"));
            result.setName(reader.getString("Name"));
            result.setGroupName(reader.getString("GroupName"));

            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Department> GetAll() throws SQLException {
        var query = "SELECT * FROM [dbo].[Departments]";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();

        var result = new ArrayList<Department>();
        while (reader.next())
        {
            var department = new Department();
            department.setId(reader.getInt("Id"));
            department.setName(reader.getString("Name"));
            department.setGroupName(reader.getString("GroupName"));

            result.add(department);
        }

        return result;
    }
}

