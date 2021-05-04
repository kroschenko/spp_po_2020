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
import java.util.stream.Collectors;

public class AssignTaskController {
    @FXML
    private ComboBox<Task> task;

    private IBaseRepository<Task> taskRepository;
    private IEmployeeTaskManager employeeTaskManager;
    private Employee employee;

    public void Initialize(Connection connection, Employee employee) throws Exception {
        this.employee = employee;
        taskRepository = new TaskRepository(connection);
        employeeTaskManager = new EmployeeTaskManager(connection);

        var tasks = taskRepository.GetAll();
        var employeeTasks = employeeTaskManager.GetEmployeeTasks(employee);
        var taskDifference = tasks
                .stream()
                .filter(t -> !employeeTasks.stream().anyMatch(inner -> inner.getId() == t.getId()))
                .collect(Collectors.toList());;

        var result = FXCollections.observableArrayList(taskDifference);
        task.setItems(result);
    }

    @FXML
    public void OnAssignButtonClicked(ActionEvent event)
    {
        var selectedTask = task.getSelectionModel().getSelectedItem();
        try {
            employeeTaskManager.AddEmployeeTask(employee, selectedTask);
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
