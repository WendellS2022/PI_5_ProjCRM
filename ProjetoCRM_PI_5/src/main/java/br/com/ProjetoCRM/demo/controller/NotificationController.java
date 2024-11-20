package br.com.ProjetoCRM.demo.controller;

import br.com.ProjetoCRM.demo.DTO.EmailDTO;
import br.com.ProjetoCRM.demo.Services.Notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotificationController
{
    @Autowired NotificationService notificationService;

    @PostMapping("/SendEmail")
    public String SendEmail(EmailDTO emailDTO)
    {
        emailDTO.setSubject("Seu protocolo de Vision One");
        notificationService.sendEmail(emailDTO);
        return "redirect:/";
    }
}
