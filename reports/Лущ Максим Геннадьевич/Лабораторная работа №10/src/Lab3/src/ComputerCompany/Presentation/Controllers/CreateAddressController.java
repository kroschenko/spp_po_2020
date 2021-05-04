package ComputerCompany.Presentation.Controllers;

import ComputerCompany.Entities.Address;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;
import ComputerCompany.Persistence.Repositories.AddressRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateAddressController {
    @FXML
    private TextField country;
    @FXML
    private TextField city;
    @FXML
    private TextField street;
    @FXML
    private TextField postalCode;

    private IBaseRepository<Address> addressRepository;

    public void Initialize(Connection connection)
    {
        addressRepository = new AddressRepository(connection);
    }

    @FXML
    public void OnCreateButtonClicked(ActionEvent event)
    {
        var address = new Address();
        address.setCountry(country.getText());
        address.setCity(city.getText());
        address.setStreet(street.getText());
        address.setPostalCode(postalCode.getText());

        try {
            addressRepository.Add(address);
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
