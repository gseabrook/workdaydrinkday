package seabrook.workdaydrinkday;

import seabrook.workdaydrinkday.WorkDayDrinkDay;

import java.util.ArrayList;
import java.util.List;

public class WorkDayDrinkDayRepository {

    private static List<WorkDayDrinkDay> workDayDrinkDays = new ArrayList<>();

    public static List<WorkDayDrinkDay> getWorkDayDrinkDays() {
        return workDayDrinkDays;
    }

    public static void addWorkDayDrinkDay(WorkDayDrinkDay workDayDrinkDay) {
        workDayDrinkDays.add(workDayDrinkDay);
    }
}
