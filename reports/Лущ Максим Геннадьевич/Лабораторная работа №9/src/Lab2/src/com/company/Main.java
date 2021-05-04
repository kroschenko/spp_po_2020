package com.company;
import ComputerCompany.Core.Services.DateTimeProvider;
import ComputerCompany.Entities.Address;
import ComputerCompany.Entities.Department;
import ComputerCompany.Entities.Employee;
import ComputerCompany.Entities.Task;
import ComputerCompany.Persistence.Repositories.*;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        var connectionString = ConfigurationConstants.ConnectionString;
        var connection = DriverManager.getConnection(connectionString);

        var dateTimeProvider = new DateTimeProvider();

        var employeeRepository = new EmployeeRepository(connection);
        var departmentRepository = new DepartmentRepository(connection);
        var addressRepository = new AddressRepository(connection);
        var taskRepository = new TaskRepository(connection);
        var employeeTaskManager = new EmployeeTaskManager(connection);

        var address = new Address();
        address.setPostalCode("123214");
        address.setCity("Brest");
        address.setCountry("France");
        address.setStreet("st. green");

        addressRepository.Add(address);

        var other = new Address();
        address.setPostalCode("214");
        address.setCity("Brest");
        address.setCountry("Belarus");

        addressRepository.Add(other);
        addressRepository.Delete(other);

        var department = new Department();
        department.setName("DDD");
        department.setGroupName("DDD Group");

        departmentRepository.Add(department);

        var employee = new Employee();
        employee.setFirstName("Vasya");
        employee.setLastName("Zaebanec");
        employee.setAddressId(address.getId());
        employee.setDepartmentId(department.getId());
        employee.setWork(true);

        employeeRepository.Add(employee);

        var task = new Task();
        task.setTitle("Repair computer");
        task.setDescription("Repair computer");
        task.setStartTime(dateTimeProvider.GetNow());
        task.setStartTime(dateTimeProvider.AddDays(dateTimeProvider.GetNow(), 4));
        task.setDifficultLevel(12);
        task.setCompleted(false);

        taskRepository.Add(task);
        employeeTaskManager.AddEmployeeTask(employee, task);

        task.setCompleted(true);
        taskRepository.Update(task);

        var employeeTasks = employeeTaskManager.GetEmployeeTasks(employee);
        System.out.println(employeeTasks.size());
    }
}
