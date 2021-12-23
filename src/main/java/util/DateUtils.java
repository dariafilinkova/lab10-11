package util;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public static Date getNextDate(Date date, int numberOfDays) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }
}
