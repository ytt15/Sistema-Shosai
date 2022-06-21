package com.example.shosai.controller;

import com.example.shosai.domain.MailServiceUsuario;
import org.springframework.stereotype.Controller;
import com.example.shosai.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author YURLEY
 */
@Controller
public class SendMailUserController {

    @Autowired
    private MailServiceUsuario mailService;

    @GetMapping("envioCorreoUser")
    public String envioCorreoUser() {
        return "envioCorreoUser";
    }

    @PostMapping("/sendEmailUsuario")
    public String sendEmailUsuario(@RequestParam("to") String to,@RequestParam("subject") String subject, @RequestParam("body") String body) {
       
        String message = body;
        mailService.sendEmailUsuario("shosai.sys@gmail.com", to , subject, message);

        return "envioCorreoUser";
    }
}
