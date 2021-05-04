package ComputerCompany.Persistence.Repositories;

import ComputerCompany.Entities.Address;
import ComputerCompany.Persistence.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddressRepository implements IBaseRepository<Address> {

    private final Connection connection;

    public AddressRepository(Connection connection)
    {
        this.connection = connection;
    }

    @Override
    public Address Add(Address entity) throws SQLException {
        var query =
            "INSERT INTO [dbo].[Addresses]" +
            "       ([Country]" +
            "       ,[City]" +
            "       ,[Street]" +
            "       ,[PostalCode])" +
            "   VALUES" +
            "       (?,?,?,?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, entity.getCountry());
        statement.setString(2, entity.getCity());
        statement.setString(3, entity.getStreet());
        statement.setString(4, entity.getPostalCode());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Address entity) throws SQLException {
        var query =
            "UPDATE [dbo].[Addresses]" +
            "   SET [Country] = ?" +
            "       ,[City] = ?" +
            "       ,[Street] = ?" +
            "       ,[PostalCode] = ?" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setString(1, entity.getCountry());
        statement.setString(2, entity.getCity());
        statement.setString(3, entity.getStreet());
        statement.setString(4, entity.getPostalCode());
        statement.setInt(5, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Address entity) throws SQLException {
        var query =
            "DELETE FROM [dbo].[Addresses]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Address GetByIdOrNull(int id) throws SQLException {
        var query =
            "SELECT * FROM [dbo].[Addresses]" +
            "   WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Address();
            result.setId(reader.getInt("Id"));
            result.setCountry(reader.getString("Country"));
            result.setCity(reader.getString("City"));
            result.setStreet(reader.getString("Street"));
            result.setPostalCode(reader.getString("PostalCode"));

            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Address> GetAll() throws SQLException {
        var query = "SELECT * FROM [dbo].[Addresses]";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Address>();
        while (reader.next())
        {
            var address = new Address();
            address.setId(reader.getInt("Id"));
            address.setCountry(reader.getString("Country"));
            address.setCity(reader.getString("City"));
            address.setStreet(reader.getString("Street"));
            address.setPostalCode(reader.getString("PostalCode"));

            result.add(address);
        }

        return result;
    }
}
