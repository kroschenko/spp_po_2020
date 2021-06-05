import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseController {
    Connection connection;
    Statement state;
    public DatabaseController () throws SQLException {
        connection=
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/lab3?user=postgres&password=1111&ssl=false");
        state = connection.createStatement();
    }
    public List<Element> getProductsClients() throws SQLException
    {
        ResultSet result = state.executeQuery("SELECT * FROM products_clients;");  List<Element> list = new ArrayList<Element>();
        while(result.next()) {
            Statement state2= connection.createStatement();
            Statement state3= connection.createStatement();
            String client1="null", product1="null";
            ResultSet client = state2.executeQuery("SELECT * FROM clients WHERE  idclients="+result.getString(3)+";");
            if(client.next())
                client1=client.getString(3)+ " " + client.getString(2);
            ResultSet product = state3.executeQuery("SELECT * FROM products WHERE  idproducts="+result.getString(2)+";");
            if(product.next())
                product1=product.getString(2);
            list.add(new Element(product1, client1, result.getInt(4), result.getInt(1)));  }
        return list;
    }
    public int getProductInProductsClientsById(int id) throws SQLException  {
        String query=String.format("SELECT * FROM products_clients WHERE  idproducts_clients= %d;", id);
        ResultSet result = state.executeQuery(query);
        if(!result.next()) {
            System.out.println("-1!!!!!!!!!!!!!!!!!!!!");
            return -1;
        }
        return Integer.parseInt(result.getString(2));
    }
    public int getClientInProductsClientsById(int id) throws SQLException  {
        String query=String.format("SELECT * FROM products_clients WHERE  idproducts_clients= %d;", id);
        ResultSet result = state.executeQuery(query);
        if(!result.next()) {
            System.out.println("-1!!!!!!!!!!!!!!!!!!!!");
            return -1;
        }
        return Integer.parseInt(result.getString(3));
    }
    public int getCountInProductsClientsById(int id) throws SQLException  {
        String query=String.format("SELECT * FROM products_clients WHERE  idproducts_clients= %d;", id);
        ResultSet result = state.executeQuery(query);
        if(!result.next()) {
            System.out.println("-1!!!!!!!!!!!!!!!!!!!!");
            return -1;
        }
        return Integer.parseInt(result.getString(4));
    }
    public void deleteRow(int id) throws SQLException
    {
        String query=String.format("DELETE FROM products_clients WHERE  idproducts_clients='%s';", String.valueOf(id));
        state.executeUpdate(query);
    }
    public List<Product> getProducts() throws SQLException {
        ResultSet result=state.executeQuery("SELECT * FROM products;");  List<Product> list=new ArrayList<Product>();
        while(result.next())
        {
            Product product=new Product(result.getInt(1), result.getString(2),  result.getDouble(3), result.getInt(4));
            list.add(product);
        }
        return list;
    }
    public List<Client> getClients() throws SQLException {
        ResultSet result=state.executeQuery("SELECT * FROM clients;");  List<Client> list=new ArrayList<Client>();
        while(result.next())
        {
            Client client=new Client(result.getInt(1), result.getString(2),  result.getString(3), result.getString(4));
            list.add(client);
        }
        return list;
    }
    public boolean addNewRecord(int idProduct, int idClient, int count) throws  SQLException
    {
        String query=String.format("INSERT INTO products_clients (idproducts, idclients,  count) VALUES ('%d', '%d', '%d');", idProduct, idClient, count);
        try {
            state.executeUpdate(query);
            return true;
        }
        catch(SQLIntegrityConstraintViolationException E)
        {
            return false;
        }
    }
    public boolean updateRecord(int id, int idProduct, int idClient, int count) throws  SQLException
    {
        String query=String.format("UPDATE products_clients SET idproducts='%d',  idclients='%d', count='%d' WHERE idproducts_clients='%d';", idProduct, idClient, count,  id);
        try {
            state.executeUpdate(query);
            return true;
        }
        catch(SQLIntegrityConstraintViolationException E)
        {
            return false;
        }
    }
}