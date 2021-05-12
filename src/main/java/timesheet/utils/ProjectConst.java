package timesheet.utils;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class ProjectConst {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static final BigDecimal MINUTES_IN_HOUR = BigDecimal.valueOf(60);
}
