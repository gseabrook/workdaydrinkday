package seabrook.events;

import org.joda.time.Instant;
import org.joda.time.Interval;
import seabrook.Employee;

public class Event {

    private final EventType eventType;
    private final Employee employee;
    private final Instant instant;

    public Event(EventType eventType, Employee employee, Instant instant) {
        this.eventType = eventType;
        this.employee = employee;
        this.instant = instant;
    }

    public Boolean isWithinInterval(Interval interval) {
        return instant.isBefore(interval.getEndMillis())
                && instant.isAfter(interval.getStartMillis());
    }

    public EventType getEventType() {
        return eventType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", employee=" + employee +
                ", instant=" + instant +
                '}';
    }
}
