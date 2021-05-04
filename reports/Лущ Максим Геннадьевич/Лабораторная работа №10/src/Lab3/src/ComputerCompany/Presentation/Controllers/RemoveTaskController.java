package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Entities.Employee;
import ComputerCompany.Entities.Task;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Interfaces.IEmployeeTaskManager;
import ComputerCompany.Persistence.Repositories.EmployeeTaskManager;
import ComputerCompany.Persistence.Repositories.TaskRepository;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class RemoveTaskController {
    @FXML
    private ComboBox<Task> task;

    private IEmployeeTaskManager employeeTaskManager;
    private Employee employee;

    public void Initialize(Connection connection, Employee employee) throws Exception {
        this.employee = employee;
        employeeTaskManager = new EmployeeTaskManager(connection);

        var employeeTasks = employeeTaskManager.GetEmployeeTasks(employee);

        var result = FXCollections.observableArrayList(employeeTasks);
        task.setItems(result);
    }

    @FXML
    public void OnRemoveButtonClicked(ActionEvent event)
    {
        var selectedTask = task.getSelectionModel().getSelectedItem();
        try {
            employeeTaskManager.RemoveEmployeeTask(employee, selectedTask);
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
