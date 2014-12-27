package seabrook.assertions;

import org.fest.assertions.api.Assertions;
import org.joda.time.Instant;
import seabrook.workdaydrinkday.WorkDayDrinkDay;

public class WorkDayDrinkDayAssertions extends Assertions {

    public static WorkDayDrinkDayAssert assertThat(WorkDayDrinkDay workDayDrinkDay) {
        return new WorkDayDrinkDayAssert(workDayDrinkDay);
    }


    public static InstantAssert assertThat(Instant instant) {
        return new InstantAssert(instant);
    }
}
