package seabrook.workdaydrinkday;

import org.joda.time.Interval;
import seabrook.events.Event;

import java.util.List;

public class WorkDayDrinkDay {

    private final Interval interval;
    private final List<Event> events;

    public WorkDayDrinkDay(Interval interval, List<Event> events) {
        this.interval = interval;
        this.events = events;
    }

    public Interval getInterval() {
        return interval;
    }

    public List<Event> getEvents() {
        return events;
    }
}
