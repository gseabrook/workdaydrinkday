package seabrook.assertions;

import org.fest.assertions.api.AbstractAssert;
import org.joda.time.Interval;
import seabrook.workdaydrinkday.WorkDayDrinkDay;

import static org.fest.assertions.api.Assertions.assertThat;

public class WorkDayDrinkDayAssert extends AbstractAssert<WorkDayDrinkDayAssert, WorkDayDrinkDay> {
    protected WorkDayDrinkDayAssert(WorkDayDrinkDay actual) {
        super(actual, WorkDayDrinkDayAssert.class);
    }


    public WorkDayDrinkDayAssert hasInterval(Interval interval) {
        isNotNull();

        assertThat(actual.getInterval())
                .isNotNull();

        assertThat(actual.getInterval())
                .isEqualTo(interval);

        return this;
    }
}
