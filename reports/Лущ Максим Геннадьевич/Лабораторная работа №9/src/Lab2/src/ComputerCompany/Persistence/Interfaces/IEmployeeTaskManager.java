package ComputerCompany.Persistence.Interfaces;

import ComputerCompany.Entities.Employee;
import ComputerCompany.Entities.Task;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IEmployeeTaskManager {
    void AddEmployeeTask(Employee employee, Task task) throws SQLException;
    void RemoveEmployeeTask(Employee employee, Task task) throws SQLException;
    ArrayList<Task> GetEmployeeTasks(Employee employee) throws SQLException;
}
