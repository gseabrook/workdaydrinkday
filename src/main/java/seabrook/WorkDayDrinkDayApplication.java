package seabrook;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import seabrook.workdaydrinkday.WorkDayDrinkDayFactory;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class WorkDayDrinkDayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkDayDrinkDayApplication.class, args);
        create();
    }

    private static void create(){
        Interval interval = new Interval(new DateTime(), new DateTime().plusMinutes(10));

        Employee employee1 = new Employee("gseabrook@gmail.com");
        Employee employee2 = new Employee("gseabrook@gmail.com");
        Employee employee3 = new Employee("gseabrook@gmail.com");

        WorkDayDrinkDayFactory.createWorkDayDrinkDay(interval, newArrayList(employee1, employee2, employee3));
    }
}
