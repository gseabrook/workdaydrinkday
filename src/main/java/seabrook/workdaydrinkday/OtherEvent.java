package seabrook.workdaydrinkday;

import org.joda.time.Instant;
import seabrook.Employee;

public class OtherEvent {
    private final String subject;
    private final Employee employee;
    private final Instant instant;

    public OtherEvent(String subject, Employee employee, Instant instant) {
        this.subject = subject;
        this.employee = employee;
        this.instant = instant;
    }

    public String getSubject() {
        return subject;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Instant getInstant() {
        return instant;
    }

    @Override
    public String toString() {
        return "OtherEvent{" +
                "subject='" + subject + '\'' +
                ", employee=" + employee +
                ", instant=" + instant +
                '}';
    }
}
