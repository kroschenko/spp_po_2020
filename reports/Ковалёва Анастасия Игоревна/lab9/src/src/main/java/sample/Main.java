package sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = new DBConnection().getConnection();

        ResultSet result;
        Statement st = null;
        st = connection.createStatement();
        result = st.executeQuery("SELECT * FROM Coach");


        result = st.executeQuery("SELECT * FROM Referee");
        while (result.next()) {
            String name = result.getString("id");
            System.out.println(name + " " +result.getString("name"));
        }

        result = st.executeQuery("SELECT Comand.id, Comand.comand_name, Comand.coach " +
                "                    FROM Comand " +
                "                    JOIN Coach " +
                "                    ON Comand.coach = Coach.id");
        while (result.next()) {
            String name = result.getString("Comand.coach");
            System.out.println(
                    result.getString("Comand.id")    + " " +
                    result.getString("Comand.comand_name") + " " +
                    name);
        }
    }
}
