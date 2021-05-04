package FacultyCompany.Core;

import FacultyCompany.Entities.*;
import FacultyCompany.Persistence.Interfaces.IBaseRepository;
import FacultyCompany.Persistence.Repositories.*;

import java.sql.SQLException;

public class RepositoryManager {
    public IBaseRepository<Subject> subjectRepository;
    public IBaseRepository<Group> groupRepository;
    public IBaseRepository<Lecturer> lecturerRepository;
    public IBaseRepository<Calendar> calendarRepository;
    public IBaseRepository<TimeTable> timeTableRepository;

    private static Connection connection = new Connection();

    public RepositoryManager() throws SQLException {
        this.subjectRepository = new SubjectRepository(connection.GetConnection());
        this.groupRepository = new GroupRepository(connection.GetConnection());
        this.lecturerRepository = new LecturerRepository(connection.GetConnection());
        this.calendarRepository = new CalendarRepository(connection.GetConnection());
        this.timeTableRepository = new TimeTableRepository(connection.GetConnection());
    }
}
