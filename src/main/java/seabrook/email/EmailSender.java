package seabrook.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailSender {

    private static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(SimpleMailMessage msg) {
        LOG.debug("Sending email to: {}, subject: {}, body: {}", msg.getTo(), msg.getSubject(), msg.getText());

        JavaMailSenderImpl javaMailSenderImpl = (JavaMailSenderImpl) javaMailSender;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable",true);
        javaMailSenderImpl.setJavaMailProperties(properties);

//        javaMailSender.send(msg);
    };
}
