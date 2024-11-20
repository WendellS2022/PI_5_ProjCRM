package br.com.ProjetoCRM.demo.Services.Notification;

import br.com.ProjetoCRM.demo.DTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail (EmailDTO emailDTO)
    {
        SimpleMailMessage SimpleMessage = new SimpleMailMessage();
        SimpleMessage.setFrom("noreply@visionone.com");
        SimpleMessage.setTo(emailDTO.getEmail());
        SimpleMessage.setSubject(emailDTO.getSubject());
        SimpleMessage.setText(emailDTO.getBody());
        mailSender.send(SimpleMessage);
    }
}
