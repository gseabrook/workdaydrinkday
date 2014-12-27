package seabrook.workdaydrinkday;

import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import seabrook.Employee;
import seabrook.events.Event;
import seabrook.events.EventType;
import seabrook.generator.RandomDateGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class WorkDayDrinkDayFactory {

    private static final Logger LOG = LoggerFactory.getLogger(WorkDayDrinkDayFactory.class);

    public static WorkDayDrinkDay createWorkDayDrinkDay(Interval interval, List<Employee> employees) {
        Collections.shuffle(employees);

        RandomDateGenerator randomDateGenerator = new RandomDateGenerator();

        Iterator<EventType> eventTypes = getShuffledEventTypes();
        List<Event> events = newArrayList();

        for (Employee employee : employees) {
            if (!eventTypes.hasNext()) {
                eventTypes = getShuffledEventTypes();
            }
            Event event = new Event(eventTypes.next(), employee, randomDateGenerator.generateInstant(interval));
            events.add(event);
        }

        WorkDayDrinkDay workDayDrinkDay = new WorkDayDrinkDay(interval, events);
        WorkDayDrinkDayRepository.addWorkDayDrinkDay(workDayDrinkDay);

        LOG.debug("Created WorkDayDrinkDay with employees: {}, duration: {}, events: {}",
                employees,
                interval,
                events);

        return workDayDrinkDay;
    }

    private static Iterator<EventType> getShuffledEventTypes(){
        ArrayList<EventType> eventTypes = newArrayList(EventType.values());
        Collections.shuffle(eventTypes);
        return eventTypes.iterator();
    }
}
