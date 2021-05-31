import java.sql.*;
import java.util.Scanner;
public class DatabaseController {
    Connection connection;
    Statement state;
    Scanner in;

    public DatabaseController() throws SQLException {
        connection =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/lab3?user=postgres&password=1111&ssl=false");
        state = connection.createStatement();
        in = new Scanner(System.in);
    }

    public void showProducts() throws SQLException {
        ResultSet result = state.executeQuery("SELECT * FROM products;");
        System.out.printf("%30s%30s%30s%30s\n", "Название", "Стоимость", "Тип", "Контрагент");
        while (result.next()) {
            System.out.printf("%30s%30s", result.getString(2), result.getString(3));
            String idProduct = result.getString(1);
            if (Integer.parseInt(result.getString(4)) == 0)
                System.out.printf("%30s", "продукт");
            else
                System.out.printf("%30s", "товар");
            Statement state2 = connection.createStatement();
            ResultSet result2 = state2.executeQuery("SELECT name FROM providers WHERE idproviders = (SELECT idproviders FROM products_providers WHERE idproducts ="+idProduct+");");
            while(result2.next()) {
                System.out.printf("%30s\n", result2.getString(1));
            }
        }
    }

    public void showClients() throws SQLException {
        ResultSet result = state.executeQuery("SELECT * FROM clients ORDER BY surname;");
        System.out.printf("%30s%30s%30s\n", "Имя", "Фамилия", "Телефон");
        while (result.next())
            System.out.printf("%30s%30s%30s\n", result.getString(2), result.getString(3),
                    result.getString(4));
    }

    public void showProductsClients() throws SQLException {
        ResultSet result = state.executeQuery("SELECT * FROM products_clients;");
        System.out.printf("%30s%30s%30s\n", "Фамилия заказчика", "Продукт или товар", "Количество");
        while (result.next()) {
            Statement state2 = connection.createStatement();
            Statement state3 = connection.createStatement();
            String client1 = "null", product1 = "null";
            ResultSet client = state2.executeQuery("SELECT * FROM clients WHERE idclients=" + result.getString(3) + ";");
            if (client.next())
                client1 = client.getString(3);
            ResultSet product = state3.executeQuery("SELECT * FROM products WHERE idproducts=" + result.getString(2) + ";");
            if (product.next())
                product1 = product.getString(2);
            System.out.printf("%30s%30s%30s\n", client1, product1, result.getString(4));
        }
    }

    public void addNewClient() throws SQLException {
        String name, surname, phone;
        System.out.println("Введите имя:");
        name = in.nextLine();
        System.out.println("Введите фамилию:");
        surname = in.nextLine();
        System.out.println("Введите телефон:");
        phone = in.nextLine();
        String query = String.format("INSERT INTO clients (name, surname, phone) VALUES ('%s', '%s', '%s');", name, surname, phone);
        try {
            state.executeUpdate(query);
            System.out.println("Успешно добавлено.");
        } catch (SQLIntegrityConstraintViolationException E) {
            System.out.println("Произошла ошибка добавления.");
        }
    }

    public void updateNameProduct() throws SQLException {
        ResultSet result = state.executeQuery("SELECT * FROM products;");
        System.out.printf("%30s%30s\n", "id", "Название");
        while (result.next())
            System.out.printf("%30s%30s\n", result.getString(1), result.getString(2));
        System.out.println("Введите id товара:");
        String id = in.nextLine();
        System.out.println("Введите новое название:");
        String name = in.nextLine();
        String query = String.format("UPDATE products SET name = '%s' WHERE idproducts = '%s';", name, id);
        try {
            state.executeUpdate(query);
            System.out.println("Успешно обновлено");
        } catch (SQLIntegrityConstraintViolationException E) {
            System.out.println("Произошла ошибка обновления.");
        }
    }

    public void deleteClient() throws SQLException {
        ResultSet result = state.executeQuery("SELECT * FROM clients;");
        System.out.printf("%30s%30s\n", "id", "Фамилия");
        while (result.next())
            System.out.printf("%30s%30s\n", result.getString(1), result.getString(3));
        System.out.println("Введите id заказчика:");
        String id = in.nextLine();
        String query = String.format("DELETE FROM clients WHERE idclients = '%s';", id);
        try {
            state.executeUpdate(query);
            System.out.println("Успешно удалено");
        } catch (SQLIntegrityConstraintViolationException E) {
            System.out.println("Произошла ошибка удаления.");
        }
    }
}