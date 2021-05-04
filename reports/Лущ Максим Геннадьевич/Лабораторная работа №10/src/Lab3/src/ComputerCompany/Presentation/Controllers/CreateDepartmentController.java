package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Entities.Department;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Repositories.DepartmentRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateDepartmentController {
    @FXML
    private TextField name;
    @FXML
    private TextField groupName;

    private IBaseRepository<Department> departmentRepository;

    public void Initialize(Connection connection)
    {
        departmentRepository = new DepartmentRepository(connection);
    }

    @FXML
    public void OnCreateButtonClicked(ActionEvent event)
    {
        var department = new Department();
        department.setName(name.getText());
        department.setGroupName(groupName.getText());

        try {
            departmentRepository.Add(department);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        closeStage(event);
    }

    private void closeStage(ActionEvent event) {
        var source = (Node)event.getSource();
        var stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
}
