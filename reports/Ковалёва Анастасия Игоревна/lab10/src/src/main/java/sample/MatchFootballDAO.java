package sample;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatchFootballDAO {

    public List<MatchFootball> getAll(){
        String sql = "SELECT MF.ID, MF.MATCH_NAME, R.NAME as TYPE, C.COMAND_NAME, C.CITY, S.STADION_NAME AS STADION, S.STADION_SIZE, " +
                "FROM MATCHFOOTBALL MF " +
                "INNER JOIN REFEREE R ON MF.REFEREE = R.ID " +
                "INNER JOIN STADION  S  ON MF.STADION = S.ID " +
                "INNER JOIN COMAND C ON MF.COMAND = C.ID";

        List<MatchFootball> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                System.out.println(resultSet.isLast());
                list.add(new MatchFootball(
                        resultSet.getInt("ID"),
                        resultSet.getString("MATCH_NAME"),
                        resultSet.getString("COMAND_NAME"),
                        resultSet.getString("TYPE"),
                        resultSet.getString("STADION"),
                        resultSet.getString("STADION_SIZE")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void insertMatchFootball(MatchFootball mf){
        String sql = "insert into MatchFootball (match_name, referee, " +
                "stadion, comand) values ( ?, (SELECT id FROM REFEREE where NAME = ?)," +
                "SELECT id FROM STADION where STADION_NAME = ?," +
                "SELECT id FROM COMAND where COMAND_NAME = ?)";

        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1, mf.getMatch_name());
            preparedStatement.setString(2, mf.getComand());
            preparedStatement.setString(3, mf.getReferee());
            preparedStatement.setString(4, mf.getStadion());

            System.out.println("1  - "+mf.getMatch_name()+ " 2  - "+mf.getReferee()+
                    " 3  - "+ mf.getStadion()+ " 4  - " + mf.getComand());
            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows added", rows);

            List<MatchFootball> list = getAll();
            for (MatchFootball matchFootball :list) {
                System.out.println(matchFootball.getComand());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id){
        String sql = "Delete from MATCHFOOTBALL  where id = ?";
        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(MatchFootball matchFootball, String str){
        String sql = "UPDATE MATCHFOOTBALL SET MATCH_NAME = ? WHERE ID = ?";
        try {
            DBConnection.getConnection();
            PreparedStatement preparedStatement = DBConnection.connection.prepareStatement(sql);
            preparedStatement.setString(1, str);
            preparedStatement.setString(2, Integer.toString(matchFootball.getId()));

            int rows = preparedStatement.executeUpdate();
            System.out.printf("%d rows upDate added", rows);

            List<MatchFootball> list = getAll();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<String> getReferee(){
        String sql = "SELECT * FROM REFEREE";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<String> getComand(){
        String sql = "SELECT * FROM COMAND";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(resultSet.getString("comand_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public List<String> getStadion(){
        String sql = "SELECT * FROM STADION";

        List<String> list = new ArrayList<>();

        try {
            DBConnection.getConnection();
            Statement statement = DBConnection.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                list.add(resultSet.getString("stadion_name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }
}
