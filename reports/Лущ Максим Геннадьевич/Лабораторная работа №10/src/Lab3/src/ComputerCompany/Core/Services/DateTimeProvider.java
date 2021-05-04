package ComputerCompany.Core.Services;

import ComputerCompany.Core.Interfaces.IDateTimeProvider;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class DateTimeProvider implements IDateTimeProvider {
    @Override
    public Date GetNow() {
        Calendar calendar = Calendar.getInstance();
        var date =calendar.getTime();
        var result = new Date(date.getTime());
        return result;
    }

    @Override
    public Date AddDays(Date date, int daysCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, daysCount);

        var utilDate =calendar.getTime();
        var result = new Date(utilDate.getTime());
        return result;
    }

    @Override
    public Date ConvertLocal(LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault();
        var result = new Date(date.atStartOfDay(zoneId).toEpochSecond());
        return result;
    }
}
