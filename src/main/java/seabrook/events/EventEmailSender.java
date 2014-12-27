package seabrook.events;

import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import seabrook.email.EmailSender;
import seabrook.email.EmailFactory;
import seabrook.workdaydrinkday.WorkDayDrinkDay;
import seabrook.workdaydrinkday.WorkDayDrinkDayRepository;

import java.util.List;

@Component
public class EventEmailSender {

    private static final Logger LOG = LoggerFactory.getLogger(EventEmailSender.class);

    private final EmailSender emailSender;
    private final EmailFactory emailFactory;

    @Autowired
    public EventEmailSender(EmailSender emailSender, EmailFactory emailFactory) {
        this.emailSender = emailSender;
        this.emailFactory = emailFactory;
    }

    public void sendPromotionEmails(Interval interval) {
        LOG.debug("Sending emails for {}", interval);

        List<WorkDayDrinkDay> workDayDrinkDays = WorkDayDrinkDayRepository.getWorkDayDrinkDays();

        for (WorkDayDrinkDay workDayDrinkDay : workDayDrinkDays) {
            for (Event event : workDayDrinkDay.getEvents()) {
                if (event.isWithinInterval(interval)) {
                    SimpleMailMessage email = emailFactory.buildEmail(event);
                    emailSender.sendEmail(email);
                }
            }
        }
    }
}
