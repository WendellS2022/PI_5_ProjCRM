//package br.com.ProjetoCRM.demo.Service;
//
//import br.com.ProjetoCRM.demo.DTO.EmailDTO;
//import br.com.ProjetoCRM.demo.Services.Notification.NotificationService;
//import com.icegreen.greenmail.util.GreenMail;
//import com.icegreen.greenmail.util.ServerSetupTest;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.mail.internet.MimeMessage;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//public class NotificationServiceTest {
//
//    @Autowired
//    private NotificationService notificationService;
//
//    @Test
//    void testEmailSending() throws Exception {
//        GreenMail greenMail = new GreenMail(ServerSetupTest.SMTP);
//        greenMail.start();
//
//        notificationService.sendEmail(EmailDTO);
//
//        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
////        assertThat(receivedMessages).hasSize(1);
////        assertThat(receivedMessages[0].getSubject()).isEqualTo("Test Subject");
//
//        greenMail.stop();
//    }
//}
//
