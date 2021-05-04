package ComputerCompany;
import ComputerCompany.Constants.ConfigurationConstants;
import ComputerCompany.Presentation.Controllers.MainWindowController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.DriverManager;


public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        var connectionString = ConfigurationConstants.ConnectionString;
        var connection = DriverManager.getConnection(connectionString);

        var loader = new FxmlViewLoader<MainWindowController>();
        var controller = loader.Load(ConfigurationConstants.MainWindowViewPath, stage);
        controller.Initialize(connection);
        loader.InitializeScene();
    }
}
