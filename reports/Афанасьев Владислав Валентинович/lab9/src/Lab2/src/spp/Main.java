package spp;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:49697;databaseName=TimeTable;user=bn;password=prostobn";

        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            if(con.isValid(30)) {
                System.out.println("Success connection");

                Statement stmt = con.createStatement();

                /*String addingGroups = "INSERT groups VALUES ('PO-3') " +
                        "INSERT groups VALUES ('AS-54')";
                stmt.execute(addingGroups);*/

                /*String addingSubjects = "INSERT subjects VALUES ('Math') " +
                        "INSERT subjects VALUES ('SPP') " +
                        "INSERT subjects VALUES ('Physics')";
                stmt.execute(addingSubjects);*/

                /*String addingLecturers = "INSERT lecturers VALUES ('Ivan', 'Gladkiu', 'Ivanovich') " +
                        "INSERT lecturers VALUES ('Vladimir', 'Lenin', 'Ilich') " +
                        "INSERT lecturers VALUES ('Vladislav', 'Afanasev', 'Valentinovich')";
                stmt.execute(addingLecturers);*/

                /*String addingCalendars = "INSERT calendar VALUES (6, 4, 1, '12:00 - 13:20') " +
                        "INSERT calendar VALUES (6, 4, 2, '13:40 - 15:10') " +
                        "INSERT calendar VALUES (6, 1, 1, '12:00 - 13:20')";
                stmt.execute(addingCalendars);*/

                /*String addingTimetable = "INSERT timetable VALUES (4, 1, 1, 4, 1)" +
                        "INSERT timetable VALUES (4, 3, 3, 4, 2)";
                stmt.execute(addingTimetable);*/

                String selectThursday = "SELECT t.ID, g.GroupName, sub.SubjectName, l.FirstName, l.LastName, c.LessonTime, c.LessonID " +
                        "FROM timetable t " +
                        "    INNER JOIN groups g ON t.GroupID = g.ID " +
                        "    INNER JOIN subjects sub ON t.SubjectID = sub.ID " +
                        "    INNER JOIN lecturers l ON t.LecturerID = l.ID " +
                        "    INNER JOIN calendar c ON t.LessonID = c.ID " +
                        "WHERE t.WeekDay = 4 " +
                        "    AND g.GroupName = 'PO-3' " +
                        "ORDER BY t.LessonID";

                ResultSet rs = stmt.executeQuery(selectThursday);

                while(rs.next()) {
                    System.out.println(rs.getString("GroupName"));
                    System.out.println(rs.getString("SubjectName"));
                    System.out.println(rs.getString("FirstName"));
                    System.out.println(rs.getString("LastName"));
                    System.out.println(rs.getString("LessonTime"));
                    System.out.println(rs.getString("LessonID"));
                }

                String addingTestGroup = "INSERT groups VALUES ('TEST') ";
                stmt.execute(addingTestGroup);

                String readingTestGroup = "SELECT * FROM groups";
                ResultSet testGroupFirst = stmt.executeQuery(readingTestGroup);

                while(testGroupFirst.next()) {
                    System.out.println(testGroupFirst.getString("GroupName"));
                }

                String updatingTestGroup = "UPDATE groups SET GroupName='NORD' WHERE GroupName='TEST'";
                stmt.execute(updatingTestGroup);

                ResultSet testGroupSecond = stmt.executeQuery(readingTestGroup);

                while(testGroupSecond.next()) {
                    System.out.println(testGroupSecond.getString("GroupName"));
                }

                String deletingTestGroup = "DELETE FROM groups WHERE GroupName='NORD'";
                stmt.execute(deletingTestGroup);

                ResultSet testGroupThird = stmt.executeQuery(readingTestGroup);

                while(testGroupThird.next()) {
                    System.out.println(testGroupThird.getString("GroupName"));
                }
            }
            else {
                System.out.println("Connection failed");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
