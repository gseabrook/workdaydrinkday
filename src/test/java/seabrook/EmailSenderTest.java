package seabrook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import seabrook.email.EmailSender;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WorkDayDrinkDayApplication.class)
@WebAppConfiguration
public class EmailSenderTest {

    @Autowired
    private EmailSender emailSender;

    @Test
    public void shouldSendEmail(){
        // Given
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("gseabrook@gmail.com");
        msg.setFrom("gseabrook@gmail.com");
        msg.setText("Some test text");
        msg.setSubject("Work day drink day email");

        // When
        emailSender.sendEmail(msg);

        // Then

    }
}