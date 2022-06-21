/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author YURLEY
 */
@Service
public class MailServiceUsuario {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmailUsuario(String from, String to, String subject, String body) {

        SimpleMailMessage email = new SimpleMailMessage();

        String correos[] = to.split(",");
        for (String cadena : correos) {
            email.setFrom(from);
            email.setTo(cadena);
            email.setSubject(subject);
            email.setText(body);

            javaMailSender.send(email);

        }

    }
}
