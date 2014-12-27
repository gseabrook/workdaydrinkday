package seabrook.assertions;

import org.fest.assertions.api.AbstractAssert;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalDateTime;

import static org.fest.assertions.api.JODA_TIME.assertThat;

public class InstantAssert extends AbstractAssert<InstantAssert, Instant> {
    protected InstantAssert(Instant actual) {
        super(actual, InstantAssert.class);
    }

    public InstantAssert isWithinInterval(Interval interval) {
        LocalDateTime expectedStartTime = new LocalDateTime(interval.getStartMillis());
        LocalDateTime expectedEndTime = new LocalDateTime(interval.getEndMillis());

        LocalDateTime actualTime = new LocalDateTime(actual);
        assertThat(actualTime).isBeforeOrEqualTo(expectedEndTime);
        assertThat(actualTime).isAfterOrEqualTo(expectedStartTime);

        return this;
    }
}
