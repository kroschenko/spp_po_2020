package live.ilyusha;

import java.sql.*;

public class DBProcess {
    private static final String url = "jdbc:sqlite:sample.db";
    public Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public Savepoint point;

    public DBProcess() {
        try {
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void reconnect() {
        try {
            con.close();
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        } catch (SQLException _) {}
    }

    public void setup() throws SQLException {
        update("create table car ( car_id integer not null constraint car_pk primary key autoincrement, make varchar(40), name varchar(40) )");
        update("create unique index car_car_id_uindex on car (car_id)");
        update("create table race_location ( race_location_id integer not null constraint race_location_pk primary key autoincrement, name varchar(100), country varchar(100) )");
        update("create table race ( race_id integer not null constraint races_pk primary key autoincrement, winner_id integer references racer (racer_id), race_location_id integer references race_location )");
        update("create unique index races_race_id_uindex on race (race_id)");
        update("create unique index race_location_race_location_id_uindex on race_location (race_location_id)");
        update("create table racer ( racer_id integer not null constraint racer_pk primary key autoincrement, name varchar(100), birth_year integer, race_id integer references race, car_id integer references car )");
        update("create unique index racer_racer_id_uindex on racer (racer_id)");
        update("create table sponsorship ( sponsorship_id integer not null constraint sponsorship_pk primary key autoincrement, company_name varchar(40), pay integer, race_id integer references race )");
        update("create unique index sponsorship_sponsorship_id_uindex on sponsorship (sponsorship_id)");

        // Fill with test data
        insert("insert or ignore into car (car_id, make, name) values (0, \"Toyota\", \"Supra\")");
        insert("insert or ignore into race_location (race_location_id, name, country) values (0, \"Nürburgring\", \"Germany\")");
        insert("insert or ignore into racer (racer_id, name, birth_year, race_id, car_id) values (0, \"Valtteri Bottas\", 1989, 0, 0)");
        insert("insert or ignore into race (race_id, winner_id, race_location_id) values (0, 0, 0)");
        insert("insert or ignore into sponsorship (sponsorship_id, company_name, pay, race_id) values (0, \"Nissan\", 2900000, 0)");
        insert("insert or ignore into car (car_id, make, name) values (1, \"Bmw\", \"M4\")");
        insert("insert or ignore into racer (racer_id, name, birth_year, race_id, car_id) values (1, \"Lewis Hamilton\", 1985, 0, 1)");
        insert("insert or ignore into race_location (race_location_id, name, country) values (1, \"Adelaide Street\", \"Australia\")");
        insert("insert or ignore into race (race_id, winner_id, race_location_id) values (1, 1, 1)");
    }

    public void insert(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public ResultSet select(String query) throws SQLException {
        rs = stmt.executeQuery(query);
        return rs;
    }

    public void delete(String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public void update(String query) throws SQLException {
        stmt.executeUpdate(query);
    }
}