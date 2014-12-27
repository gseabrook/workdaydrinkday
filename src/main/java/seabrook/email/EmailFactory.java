package seabrook.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import seabrook.events.Event;

@Component
public class EmailFactory {

    @Value("${spring.mail.username}")
    private String fromEmail;

    public SimpleMailMessage buildEmail(Event event) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(event.getEmployee().getEmailAddress());
        msg.setFrom(fromEmail);
        msg.setSubject(event.getEventType().getSubject());
        msg.setText(event.getEventType().getBody());
        return msg;
    }
}
