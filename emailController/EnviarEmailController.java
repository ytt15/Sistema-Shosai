package com.example.shosai.emailController;

import com.example.shosai.Dao.UsuarioDao;
import com.example.shosai.domain.Usuario;
import com.example.shosai.servicioMail.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author YURLEY
 */
@Controller
public class EnviarEmailController {

    @Autowired
    SendMailService sendMailService;

    @Autowired
    UsuarioDao usuario;
    
    @PostMapping("/enviaremail")
    public String enviaremail(@RequestParam("email") String correo /*,
			@RequestParam("subject")String subject,@RequestParam("body") String body*/) {
        Usuario usuario1 = usuario.findByCorreo(correo.toLowerCase());
        String mensaje = sendMailService.plantillaCambioContra().
                replace("URL_CAMBIO_CONTRASENA", "http://localhost:8080/formularioCambioContraseña?identificaion=" + usuario1.getIdentificaion()).
                replace("nombre_usuario", usuario1.getNombres() + " " + usuario1.getApellidos()); //body + "\n\n  correo de contacto;" +subject+"\n asunto"  + "\n email" + correo;
        String subject = "Cambio de contraseña usuario " + usuario1.getNombres() + " " + usuario1.getApellidos();
        sendMailService.enviaremail("shosaisystem@gmail.com", correo, subject, mensaje);
        return "pagprincipal";
    }
    
}

