package ComputerCompany;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FxmlViewLoader<T>
{
    private Stage stage;
    private Parent parent;

    public T Load(String viewPath, Stage stage) throws Exception {
        this.stage = stage;

        var fxmlLoader = new FXMLLoader();
        var viewPathUrl = getClass().getResource(viewPath);
        fxmlLoader.setLocation(viewPathUrl);

        parent = (Parent)fxmlLoader.load();

        return fxmlLoader.getController();
    }

    public void InitializeScene()
    {
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void InitializeModalScene()
    {
        Scene scene = new Scene(parent);

        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
