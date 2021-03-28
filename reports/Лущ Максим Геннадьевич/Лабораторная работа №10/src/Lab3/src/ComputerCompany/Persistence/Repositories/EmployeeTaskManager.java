package ComputerCompany.Persistence.Repositories;

import ComputerCompany.Entities.Employee;
import ComputerCompany.Entities.Task;
import ComputerCompany.Persistence.Interfaces.IEmployeeTaskManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeTaskManager implements IEmployeeTaskManager {

    private final Connection connection;

    public EmployeeTaskManager(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public void AddEmployeeTask(Employee employee, Task task) throws SQLException {
        var query =
            "INSERT INTO [dbo].[EmployeeTask]" +
            "       ([TaskId]" +
            "       ,[EmployeeId])" +
            "   VALUES" +
            "       (?,?)";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, task.getId());
        statement.setInt(2, employee.getId());

        statement.execute();
    }

    @Override
    public void RemoveEmployeeTask(Employee employee, Task task) throws SQLException {
        var query =
                "DELETE FROM [dbo].[EmployeeTask]" +
                "      WHERE TaskId=? AND EmployeeId=?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, task.getId());
        statement.setInt(2, employee.getId());

        statement.executeUpdate();
    }

    @Override
    public ArrayList<Task> GetEmployeeTasks(Employee employee) throws SQLException {
        var query =
                "SELECT * FROM [dbo].[Tasks]" +
                "   INNER JOIN EmployeeTask ON Id=TaskId" +
                "   WHERE EmployeeId=?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, employee.getId());

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
