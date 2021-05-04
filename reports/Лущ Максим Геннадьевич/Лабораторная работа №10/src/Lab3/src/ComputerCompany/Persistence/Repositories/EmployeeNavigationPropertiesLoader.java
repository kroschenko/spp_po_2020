package ComputerCompany.Persistence.Repositories;

import ComputerCompany.Entities.Employee;
import ComputerCompany.Persistence.Interfaces.INavigationPropLoader;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeNavigationPropertiesLoader implements INavigationPropLoader<Employee> {
    private final Connection connection;

    public EmployeeNavigationPropertiesLoader(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Employee LoadNavigationProperties(Employee entity) throws SQLException {
        var addressRepository = new AddressRepository(connection);
        var departmentRepository = new DepartmentRepository(connection);
        var employeeTaskManager = new EmployeeTaskManager(connection);

        var address = addressRepository.GetByIdOrNull(entity.getAddressId());
        entity.setAddress(address);

        var department = departmentRepository.GetByIdOrNull(entity.getDepartmentId());
        entity.setDepartment(department);

        var tasks = employeeTaskManager.GetEmployeeTasks(entity);
        entity.setTasks(tasks);

        return entity;
    }
}
