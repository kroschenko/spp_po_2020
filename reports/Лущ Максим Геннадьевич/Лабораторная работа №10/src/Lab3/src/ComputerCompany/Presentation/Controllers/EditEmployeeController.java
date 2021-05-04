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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class EditEmployeeController {
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public ComboBox<Department> department;
    @FXML
    public ComboBox<Address> address;
    @FXML
    public CheckBox isWork;

    private IBaseRepository<Employee> employeeRepository;
    private IBaseRepository<Address> addressRepository;
    private IBaseRepository<Department> departmentRepository;
    private Employee editable;

    public void Initialize(Connection connection, Employee editable) throws Exception {
        employeeRepository = new EmployeeRepository(connection);
        addressRepository = new AddressRepository(connection);
        departmentRepository = new DepartmentRepository(connection);

        var departments = FXCollections.observableArrayList(departmentRepository.GetAll());
        var addresses = FXCollections.observableArrayList(addressRepository.GetAll());

        department.setItems(departments);
        address.setItems(addresses);

        this.editable = editable;
        firstName.setText(editable.getFirstName());
        lastName.setText(editable.getLastName());
        department.getSelectionModel().select(editable.getDepartment());
        address.getSelectionModel().select(editable.getAddress());
        isWork.setSelected(editable.isWork());
    }

    @FXML
    public void OnCreateButtonClicked(ActionEvent event)
    {
        editable.setFirstName(firstName.getText());
        editable.setLastName(lastName.getText());
        editable.setAddressId(address.getSelectionModel().getSelectedItem().getId());
        editable.setDepartmentId(department.getSelectionModel().getSelectedItem().getId());
        editable.setWork(isWork.isSelected());

        try {
            employeeRepository.Update(editable);
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