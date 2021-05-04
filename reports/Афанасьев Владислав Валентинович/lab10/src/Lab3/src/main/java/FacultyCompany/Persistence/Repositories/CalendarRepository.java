package FacultyCompany.Persistence.Repositories;

import FacultyCompany.Entities.Calendar;
import FacultyCompany.Persistence.Interfaces.IBaseRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CalendarRepository implements IBaseRepository<Calendar> {

    private final Connection connection;

    public CalendarRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Calendar Add(Calendar entity) throws SQLException {
        var query =
                "INSERT INTO public.calendar( " +
                        " semesterid, weekday, lessonid, lessontime) " +
                        " VALUES (?, ?, ?, ?)";

        var statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, entity.getSemesterid());
        statement.setInt(2, entity.getWeekday());
        statement.setInt(3, entity.getLessonid());
        statement.setString(4, entity.getLessontime());

        statement.execute();

        var generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        entity.setId(generatedKeys.getInt(1));

        return entity;
    }

    @Override
    public void Update(Calendar entity) throws SQLException {
        var query ="UPDATE public.calendar " +
                " SET semesterid=?, weekday=?, lessonid=?, lessontime=?" +
                " WHERE id=?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getSemesterid());
        statement.setInt(2, entity.getWeekday());
        statement.setInt(3, entity.getLessonid());
        statement.setString(4, entity.getLessontime());
        statement.setInt(5, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public void Delete(Calendar entity) throws SQLException {
        var query = "DELETE FROM public.calendar" +
                " WHERE id=?";
        var statement = connection.prepareStatement(query);
        statement.setInt(1, entity.getId());

        statement.executeUpdate();
    }

    @Override
    public Calendar GetByIdOrNull(int id) throws SQLException {
        var query =
                "SELECT * FROM public.calendar" +
                        " WHERE Id = ?";

        var statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var reader = statement.executeQuery();
        if(reader.next())
        {
            var result = new Calendar();
            result.setId(reader.getInt("id"));
            result.setLessonid(reader.getInt("lessonid"));
            result.setSemesterid(reader.getInt("semesterid"));
            result.setWeekday(reader.getInt("weekday"));
            result.setLessontime(reader.getString("lessontime"));
            return result;
        }

        return null;
    }

    @Override
    public ArrayList<Calendar> GetAll() throws SQLException {
        var query =
                "SELECT * FROM public.calendar Order by id";

        var statement = connection.prepareStatement(query);

        var reader = statement.executeQuery();
        var result = new ArrayList<Calendar>();
        while (reader.next())
        {
            var calendar = new Calendar();
            calendar.setId(reader.getInt("id"));
            calendar.setLessonid(reader.getInt("lessonid"));
            calendar.setSemesterid(reader.getInt("semesterid"));
            calendar.setWeekday(reader.getInt("weekday"));
            calendar.setLessontime(reader.getString("lessontime"));

            result.add(calendar);
        }

        return result;
    }
}
