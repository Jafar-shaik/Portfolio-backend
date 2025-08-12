package com.jafar.portfolio.controller;

import com.jafar.portfolio.entity.EmailEntity;
import com.jafar.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contact")
    public ResponseEntity<?> sendMail(@RequestBody EmailEntity emailEntity) {
        emailService.sendMail(emailEntity);
        return ResponseEntity.ok("The Email has been sent  !");
    }
}