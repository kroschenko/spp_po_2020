package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Constants.ConfigurationConstants;
import ComputerCompany.Entities.Employee;
import ComputerCompany.FxmlViewLoader;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Interfaces.IEmployeeTaskManager;
import ComputerCompany.Persistence.Interfaces.INavigationPropLoader;
import ComputerCompany.Persistence.Repositories.EmployeeNavigationPropertiesLoader;
import ComputerCompany.Persistence.Repositories.EmployeeRepository;
import ComputerCompany.Persistence.Repositories.EmployeeTaskManager;
import ComputerCompany.Presentation.Utils.PropertyFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class MainWindowController {
    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label department;
    @FXML
    private Label isWork;
    @FXML
    private Label address;
    @FXML
    private Label tasks;

    @FXML
    private TextField lastNameFilter;

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> employeeId;
    @FXML
    private TableColumn<Employee, String> employeeFirstName;
    @FXML
    private TableColumn<Employee, String> employeeLastName;
    @FXML
    private TableColumn<Employee, String> employeeAddress;
    @FXML
    private TableColumn<Employee, String> employeeDepartment;

    private Employee current;

    private IBaseRepository<Employee> employeeRepository;
    private IEmployeeTaskManager employeeTaskManager;
    private INavigationPropLoader<Employee> navigationPropertiesLoader;
    private Connection connection;

    public void Initialize(Connection connection) throws SQLException {
        this.connection = connection;
        navigationPropertiesLoader = new EmployeeNavigationPropertiesLoader(connection);
        employeeRepository = new EmployeeRepository(connection, navigationPropertiesLoader);
        employeeTaskManager = new EmployeeTaskManager(connection);

        LinkEmployeeCells();
        UpdateTable();
    }

    @FXML
    public void OnCreateAddressButtonClicked() throws Exception {
        var loader = new FxmlViewLoader<CreateAddressController>();
        var controller = loader.Load(ConfigurationConstants.AddressCreationWindowViewPath, null);
        controller.Initialize(connection);
        loader.InitializeModalScene();
    }


    @FXML
    public void OnAssignTaskButtonClicked() throws Exception {
        if(current == null)
        {
            return;
        }

        var loader = new FxmlViewLoader<AssignTaskController>();
        var controller = loader.Load(ConfigurationConstants.AssignTaskWindowViewPath, null);
        controller.Initialize(connection, current);
        loader.InitializeModalScene();

        FillEmployeeInfo(current);
    }

    @FXML
    public void OnRemoveTaskButtonClicked() throws Exception {
        if(current == null)
        {
            return;
        }

        var loader = new FxmlViewLoader<RemoveTaskController>();
        var controller = loader.Load(ConfigurationConstants.RemoveTaskWindowViewPath, null);
        controller.Initialize(connection, current);
        loader.InitializeModalScene();

        FillEmployeeInfo(current);
    }

    @FXML
    public void OnCreateDepartmentButtonClicked() throws Exception {
        var loader = new FxmlViewLoader<CreateDepartmentController>();
        var controller = loader.Load(ConfigurationConstants.DepartmentCreationWindowViewPath, null);
        controller.Initialize(connection);
        loader.InitializeModalScene();
    }

    @FXML
    public void OnCreateTaskButtonClicked() throws Exception {
        var loader = new FxmlViewLoader<CreateTaskController>();
        var controller = loader.Load(ConfigurationConstants.TaskCreationWindowViewPath, null);
        controller.Initialize(connection);
        loader.InitializeModalScene();

        FillEmployeeInfo(current);
    }

    @FXML
    public void OnCreateEmployeeButtonClicked() throws Exception {
        var loader = new FxmlViewLoader<CreateEmployeeController>();
        var controller = loader.Load(ConfigurationConstants.EmployeeCreationWindowViewPath, null);
        controller.Initialize(connection);
        loader.InitializeModalScene();

        UpdateTable();
    }

    @FXML
    public void OnDeleteEmployeeButtonClicked() throws Exception {
        employeeRepository.Delete(current);
        current = null;

        FillEmployeeInfo(null);
        UpdateTable();
    }

    @FXML
    public void OnEditEmployeeButtonClicked() throws Exception {
        var loader = new FxmlViewLoader<EditEmployeeController>();
        var controller = loader.Load(ConfigurationConstants.EmployeeEditWindowViewPath, null);
        controller.Initialize(connection, current);
        loader.InitializeModalScene();

        FillEmployeeInfo(current);
        UpdateTable();
    }

    @FXML
    public void ClickItem() throws SQLException {
        current = employeeTable.getSelectionModel().getSelectedItem();
        FillEmployeeInfo(current);
    }

    @FXML
    public void OnFilterButtonClicked() throws SQLException {
        var filterPattern = ".*" + lastNameFilter.getText() + ".*";

        var filteredEmployees = employeeRepository
                .GetAll()
                .stream()
                .filter(e -> e.getLastName().matches(filterPattern))
                .collect(Collectors.toList());

        var result = FXCollections.observableArrayList(filteredEmployees);
        employeeTable.setItems(result);
    }

    public void LinkEmployeeCells() {
        employeeId.setCellValueFactory(c -> PropertyFactory.CreateProperty(c, e -> e.getId()));
        employeeFirstName.setCellValueFactory(c -> PropertyFactory.CreateProperty(c, e -> e.getFirstName()));
        employeeLastName.setCellValueFactory(c -> PropertyFactory.CreateProperty(c, e -> e.getLastName()));
        employeeAddress.setCellValueFactory(c -> PropertyFactory.CreateProperty(c, e -> e.getAddress().getCountry()));
        employeeDepartment.setCellValueFactory(c -> PropertyFactory.CreateProperty(c, e -> e.getDepartment().getName()));
    }

    public void FillEmployeeInfo(Employee employee) throws SQLException {
        var isNotNull = employee != null;
        firstName.setText(isNotNull ? current.getFirstName() : "");
        lastName.setText(isNotNull ? current.getLastName() : "");
        address.setText(isNotNull ? current.getAddress().getCountry() : "");
        department.setText(isNotNull ? current.getDepartment().getName() : "");
        isWork.setText(isNotNull ? String.valueOf(current.isWork()) : "");

        if (isNotNull)
        {
            var employeeTasks = employeeTaskManager.GetEmployeeTasks(current);
            var result = employeeTasks
                    .stream()
                    .map(t-> t.toString())
                    .collect(Collectors.joining(", "));

            tasks.setText(result);
        }
    }

    public void UpdateTable() throws SQLException {
        var employees = FXCollections.observableArrayList(employeeRepository.GetAll());
        employeeTable.setItems(employees);
    }

}
