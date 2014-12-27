package seabrook;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import seabrook.events.EventEmailSender;

@Component
public class Scheduler {

    private static final Logger LOG = LoggerFactory.getLogger(Scheduler.class);

    private final EventEmailSender eventEmailSender;

    @Autowired
    public Scheduler(EventEmailSender eventEmailSender) {
        this.eventEmailSender = eventEmailSender;
    }

    @Scheduled(fixedRate=60000)
    public void sendEmails() {

        DateTime start = new DateTime().withSecondOfMinute(0);
        DateTime end = new DateTime().withSecondOfMinute(59);

        Interval interval = new Interval(start, end);

        eventEmailSender.sendPromotionEmails(interval);
    }
}
