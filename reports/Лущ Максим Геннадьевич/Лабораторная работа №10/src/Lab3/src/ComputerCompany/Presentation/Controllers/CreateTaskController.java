package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Core.Interfaces.IDateTimeProvider;
import ComputerCompany.Core.Services.DateTimeProvider;
import ComputerCompany.Entities.Task;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Repositories.TaskRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTaskController {
    @FXML
    private TextField title;
    @FXML
    private TextArea description;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker deadline;
    @FXML
    private TextField difficultLevel;

    private IBaseRepository<Task> taskRepository;
    private IDateTimeProvider dateTimeProvider;

    public void Initialize(Connection connection)
    {
        taskRepository = new TaskRepository(connection);
        dateTimeProvider = new DateTimeProvider();
    }

    @FXML
    public void OnCreateButtonClicked(ActionEvent event)
    {
        var task = new Task();
        task.setTitle(title.getText());
        task.setDescription(description.getText());
        task.setStartTime(dateTimeProvider.ConvertLocal(startDate.getValue()));
        task.setDeadline(dateTimeProvider.ConvertLocal(deadline.getValue()));

        try {
            var value = Integer.parseInt(difficultLevel.getText());
            task.setDifficultLevel(value);
        }
        catch (NumberFormatException e)
        {
            task.setDifficultLevel(0);
        }

        try {
            taskRepository.Add(task);
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
