package ComputerCompany.Persistence.Repositories;

import ComputerCompany.Entities.Task;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaskRepository implements IBaseRepository<Task> {

    private final Connection connection;

    public TaskRepository(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Task Add(Task entity) throws SQLException {
        var query =
            "INSERT INTO [dbo].[Tasks]" +
            "       ([Title]" +
            "       ,[Description]" +
            "       ,[StartTime]" +
            "       ,[Deadline]" +
            "       ,[DifficultLevel]" +
            "       ,[IsCompleted])" +
            "   VALUES" +
            "       (?,?,?,?,?,?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getTitle());
        statement.setString(2, entity.getDescription());
        statement.setDate(3, entity.getStartTime());
        statement.setDate(4, entity.getDeadline());
        statement.setInt(5, entity.getDifficultLevel());
        statement.setBoolean(6, entity.isCompleted());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Task entity) throws SQLException {
        var query =
            "UPDATE [dbo].[Tasks]" +
            "   SET [Title] = ?" +
            "       ,[Description] = ?" +
            "       ,[StartTime] = ?" +
            "       ,[Deadline] = ?" +
            "       ,[DifficultLevel] = ?" +
            "       ,[IsCompleted] = ?" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getTitle());
        statement.setString(2, entity.getDescription());
        statement.setDate(3, entity.getStartTime());
        statement.setDate(4, entity.getDeadline());
        statement.setInt(5, entity.getDifficultLevel());
        statement.setBoolean(6, entity.isCompleted());

        statement.setInt(7, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Task entity) throws SQLException {
        var query =
            "DELETE FROM [dbo].[Tasks]" +
            "      WHERE Id = ?";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Task GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM [dbo].[Tasks]" +
                "      WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
           var result = new Task();
           result.setId(reader.getInt("Id"));
           result.setTitle(reader.getString("Title"));
           result.setDescription(reader.getString("Description"));
           result.setStartTime(reader.getDate("StartTime"));
           result.setDeadline(reader.getDate("Deadline"));
           result.setDifficultLevel(reader.getInt("DifficultLevel"));
           result.setCompleted(reader.getBoolean("IsCompleted"));

           return result;
        }

        return null;
    }

    @Override
    public ArrayList<Task> GetAll() throws SQLException {
        var query = "SELECT * FROM [dbo].[Tasks]";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Task>();
        while (reader.next())
        {
            var task = new Task();
            task.setId(reader.getInt("Id"));
            task.setTitle(reader.getString("Title"));
            task.setDescription(reader.getString("Description"));
            task.setStartTime(reader.getDate("StartTime"));
            task.setDeadline(reader.getDate("Deadline"));
            task.setDifficultLevel(reader.getInt("DifficultLevel"));
            task.setCompleted(reader.getBoolean("IsCompleted"));

            result.add(task);
        }

        return result;
    }
}

