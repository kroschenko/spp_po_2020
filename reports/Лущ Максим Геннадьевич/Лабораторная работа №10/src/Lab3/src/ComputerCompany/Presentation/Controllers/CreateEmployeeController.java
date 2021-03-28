package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Entities.Address;
import ComputerCompany.Entities.Department;
import ComputerCompany.Entities.Employee;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Repositories.AddressRepository;
import ComputerCompany.Persistence.Repositories.DepartmentRepository;
import ComputerCompany.Persistence.Repositories.EmployeeRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateEmployeeController {
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public ComboBox<Department> department;
    @FXML
    public ComboBox<Address> address;

    private IBaseRepository<Employee> employeeRepository;
    private IBaseRepository<Address> addressRepository;
    private IBaseRepository<Department> departmentRepository;

    public void Initialize(Connection connection) throws Exception {
        employeeRepository = new EmployeeRepository(connection);
        addressRepository = new AddressRepository(connection);
        departmentRepository = new DepartmentRepository(connection);

        var departments = FXCollections.observableArrayList(departmentRepository.GetAll());
        var addresses = FXCollections.observableArrayList(addressRepository.GetAll());

        department.setItems(departments);
        address.setItems(addresses);
    }

    @FXML
    public void OnCreateButtonClicked(ActionEvent event)
    {
        var employee = new Employee();
        employee.setFirstName(firstName.getText());
        employee.setLastName(lastName.getText());
        employee.setAddressId(address.getSelectionModel().getSelectedItem().getId());
        employee.setDepartmentId(department.getSelectionModel().getSelectedItem().getId());

        try {
            employeeRepository.Add(employee);
        } catch (SQLException exception) {
            return;
        }

        closeStage(event);
    }

    private void closeStage(ActionEvent event) {
        var source = (Node)event.getSource();
        var stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}