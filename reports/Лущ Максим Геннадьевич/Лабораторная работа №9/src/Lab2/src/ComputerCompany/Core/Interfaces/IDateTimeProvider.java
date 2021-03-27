package ComputerCompany.Core.Interfaces;

import java.sql.Date;

public interface IDateTimeProvider {
    Date GetNow();
    Date AddDays(Date date, int daysCount);
}
