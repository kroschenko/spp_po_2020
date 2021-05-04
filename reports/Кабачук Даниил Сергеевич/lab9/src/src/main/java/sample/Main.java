package sample;

import sample.DBConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DBConnection().getConnection();

        ResultSet result;
        Statement st = null;
        st = connection.createStatement();
        result = st.executeQuery("SELECT * FROM Departments");


        result = st.executeQuery("SELECT * FROM Type_Equipment");
        while (result.next()) {
            String name = result.getString("id");
            System.out.println(name + " " +result.getString("name"));
        }

        result = st.executeQuery("SELECT Employees.id, Employees.fname, Departments.name " +
                "                    FROM Employees " +
                "                    JOIN Departments " +
                "                    ON Employees.department = Departments.id");
        while (result.next()) {
            String name = result.getString("Departments.name");
            System.out.println(
                    result.getString("Employees.id")    + " " +
                    result.getString("Employees.fname") + " " +
                    name);
        }
    }
}
