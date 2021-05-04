package ComputerCompany.Core.Interfaces;

import java.sql.Date;
import java.time.LocalDate;

public interface IDateTimeProvider {
    Date GetNow();
    Date AddDays(Date date, int daysCount);
    Date ConvertLocal(LocalDate date);
}
