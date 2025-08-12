package com.jafar.portfolio.service;


import com.jafar.portfolio.entity.EmailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(EmailEntity emailEntity){
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo("skjafar4944@gmail.com");
            mail.setFrom("skjafar4944@gmail.com");
            mail.setSubject("New message from "+emailEntity.getName());
            mail.setText("Name : "+emailEntity.getName()+"\nEmail : "+emailEntity.getEmail()+"\n Message : "+  emailEntity.getMessage());
            javaMailSender.send(mail);
        } catch (Exception e) {
            log.error("Exception while sending mail" , e);
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
