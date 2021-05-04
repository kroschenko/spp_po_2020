package sample.dao;

import sample.model.Equipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO {

    public List<Equipment> getAll(){
        String sql = "SELECT E.ID, E.REGISTRATION_NUMBER, TE.NAME as TYPE, EM.LNAME  as Last, EM.FNAME, M.NAME AS MANUFACTURER, M.WARRANTY, " +
                "FROM EQUIPMENT E " +
                "INNER JOIN TYPE_EQUIPMENT TE ON E.TYPE_EQUIPMENT = TE.ID " +
                "INNER JOIN MANUFACTURERS  M  ON E.MANUFACTURER   = M.ID " +
                "INNER JOIN EMPLOYEES      EM ON E.EMPLOYEE       = EM.ID";

        List<Equipment> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.isLast());
                list.add(new Equipment(
                        resultSet.getInt("ID"),
                        resultSet.getString("REGISTRATION_NUMBER"),
                        resultSet.getString("TYPE"),
                        resultSet.getString("MANUFACTURER"),
                        resultSet.getString("LNAME"),
                        resultSet.getString("WARRANTY")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void insertEquipment(Equipment eq){
        String sql = "insert into Equipment (registration_number, type_equipment, " +
                "manufacturer, employee) values ( ?, (SELECT id FROM TYPE_EQUIPMENT where NAME = ?)," +
                "SELECT id FROM MANUFACTURERS where NAME = ?," +
                "SELECT id FROM EMPLOYEES where lname = ?)";
        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1, eq.getRegistrationNumber());
            preparedStatement.setString(2, eq.getTypeEquipment());
            preparedStatement.setString(3, eq.getManufacturer());
            preparedStatement.setString(4, eq.getEmployee());

            System.out.println("1  - "+eq.getRegistrationNumber()+ "2  - "+eq.getTypeEquipment()+
                    "3  - "+ eq.getManufacturer()+ "4  - " + eq.getEmployee());
            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows added", rows);

            List<Equipment> list = getAll();
            for (Equipment equipment:list) {
                System.out.println(equipment.getEmployee());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "Delete from EQUIPMENT  where id = ?";
        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void upDate(Equipment equipment, String str){
        String sql = "UPDATE EQUIPMENT SET REGISTRATION_NUMBER  = ? WHERE ID = ?";
        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1, str);
            preparedStatement.setString(2, Integer.toString(equipment.getId()));

            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows upDate added", rows);

            List<Equipment> list = getAll();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<String> getTypeEquipment(){
        String sql = "SELECT * FROM TYPE_EQUIPMENT";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("name"));
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<String> getEmployees(){
        String sql = "SELECT * FROM EMPLOYEES";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("lname"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<String> getManufacturers(){
        String sql = "SELECT * FROM MANUFACTURERS";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                list.add(resultSet.getString("name"));
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
