package com.example.shosai.servicioMail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author YURLEY
 */
@Service
public class SendMailService {

    @Autowired
    private JavaMailSender javamailsender;

    public void enviaremail(String from, String to, String subject, String body) {

        /*SimpleMailMessage mimensaje = new SimpleMailMessage();
		
		mimensaje.setFrom(from);
		mimensaje.setTo(to);
		mimensaje.setSubject(subject);
		mimensaje.setText(body);*/
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("shosai.sys@gmail.com");
        sender.setPassword("ajgyreyflbsxulvu");
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", true);
        mailProperties.put("mail.smtp.starttls.required", true);
        mailProperties.put("mail.smtp.quitwait", false);
        sender.setJavaMailProperties(mailProperties);
        MimeMessage message = sender.createMimeMessage();

// use the true flag to indicate you need a multipart message
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setText(body, true);

            sender.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(SendMailService.class.getName()).log(Level.SEVERE, null, ex);
        }

        //javamailsender.send(mimensaje);
    }

    public String plantillaCambioContra() {
        String plantilla = "<html xmlns='http://www.w3.org/1999/xhtml'>"
                + "<head>"
                + "        <meta http-equiv='content-type' content='text/html; charset=utf-8'>"
                + "        <meta name='viewport' content='width=device-width, initial-scale=1.0;'>"
                + "        <meta name='format-detection' content='telephone=no'/>"
                + "        <style>"
                + "body { margin: 0; padding: 0; min-width: 100%; width: 100% !important; height: 100% !important;}"
                + "body, table, td, div, p, a { -webkit-font-smoothing: antialiased; text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; line-height: 100%; }"
                + "table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; border-collapse: collapse !important; border-spacing: 0; }"
                + "img { border: 0; line-height: 100%; outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; }"
                + "#outlook a { padding: 0; }"
                + ".ReadMsgBody { width: 100%; } .ExternalClass { width: 100%; }"
                + ".ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div { line-height: 100%; }"
                + "@media all and (min-width: 560px) {"
                + "        .container { border-radius: 8px; -webkit-border-radius: 8px; -moz-border-radius: 8px; -khtml-border-radius: 8px;}"
                + "}"
                + "a, a:hover {"
                + "        color: #127DB3;"
                + "}"
                + ".footer a, .footer a:hover {"
                + "        color: #999999;"
                + "}"
                + "        </style>"
                + "        <title>Get this responsive email template</title>"
                + "</head>"
                + "<body topmargin='0' rightmargin='0' bottommargin='0' leftmargin='0' marginwidth='0' marginheight='0' width='100%' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; width: 100%; height: 100%; -webkit-font-smoothing: antialiased; text-size-adjust: 100%; -ms-text-size-adjust: 100%; -webkit-text-size-adjust: 100%; line-height: 100%;"
                + "        background-color: #F0F0F0;"
                + "        color: #000000;'"
                + "        bgcolor='#F0F0F0'"
                + "        text='#000000'>"
                + "<table width='100%' align='center' border='0' cellpadding='0' cellspacing='0' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; width: 100%;' class='background'><tr><td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0;'"
                + "        bgcolor='#F0F0F0'>"
                + "<table border='0' cellpadding='0' cellspacing='0' align='center'"
                + "        width='560' style='border-collapse: collapse; border-spacing: 0; padding: 0; width: inherit;"
                + "        max-width: 560px;' class='wrapper'>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%;"
                + "                        padding-top: 20px;"
                + "                        padding-bottom: 20px;'>"
                + "                        <div style='display: none; visibility: hidden; overflow: hidden; opacity: 0; font-size: 1px; line-height: 1px; height: 0; max-height: 0; max-width: 0;"
                + "                        color: #F0F0F0;' class='preheader'>"
                + "                                Cambio de contraseña Shosai SYS - INSPIRA </div>"
                + "                </td>"
                + "        </tr>"
                + "</table>"
                + "<table border='0' cellpadding='0' cellspacing='0' align='center'"
                + "        bgcolor='#FFFFFF'"
                + "        width='560' style='border-collapse: collapse; border-spacing: 0; padding: 0; width: inherit;"
                + "        max-width: 560px;' class='container'>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%; font-size: 24px; font-weight: bold; line-height: 130%;"
                + "                        padding-top: 25px;"
                + "                        color: #000000;"
                + "                        font-family: sans-serif;' class='header'>"
                + "                </td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-bottom: 3px; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%; font-size: 18px; font-weight: 300; line-height: 150%;"
                + "                        padding-top: 5px;"
                + "                        color: #000000;"
                + "                        font-family: sans-serif;' class='subheader'>      "
                + "                </td>"
                + "        </tr>                                                                                                                             <tr>"
                + "               <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-bottom: 3px; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%; font-size: 18px; font-weight: 300; line-height: 150%;"
                + "                        padding-top: 5px;"
                + "                        color: #000000;"
                + "                        font-family: sans-serif;' class='subheader'>"
                + "      Hola nombre_usuario"
                + "                </td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%; font-size: 17px; font-weight: 400; line-height: 160%;"
                + "                        padding-top: 25px; "
                + "                        color: #000000;"
                + "                        font-family: sans-serif;' class='paragraph'>"
                + "      Recientemente has solicitado restablecer tu contraseña, por favor sigue el proceso como se te indica. En caso de que no hayas sido tu quien solicito reestablecer, por favor haz caso omiso a este mensaje"
                + "                </td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%;"
                + "                        padding-top: 25px;"
                + "                        padding-bottom: 5px;' class='button'><a"
                + "                        href='URL_CAMBIO_CONTRASENA' target='_blank' style='text-decoration: underline;'>"
                + "                                <table border='0' cellpadding='0' cellspacing='0' align='center' style='max-width: 240px; min-width: 120px; border-collapse: collapse; border-spacing: 0; padding: 0;'><tr><td align='center' valign='middle' style='padding: 12px 24px; margin: 0; text-decoration: underline; border-collapse: collapse; border-spacing: 0; border-radius: 4px; -webkit-border-radius: 4px; -moz-border-radius: 4px; -khtml-border-radius: 4px;'"
                + "                                        bgcolor='#E9703E'><a target='_blank' style='text-decoration: underline;"
                + "                                        color: #FFFFFF; font-family: sans-serif; font-size: 17px; font-weight: 400; line-height: 120%;'"
                + "                                        href='URL_CAMBIO_CONTRASENA'>"
                + "                                                Cambiar contraseña"
                + "                                        </a>"
                + "                        </td></tr></table></a>"
                + "                </td>"
                + "        </tr>"
                + "        <tr>    "
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%;"
                + "                        padding-top: 25px;' class='line'><hr"
                + "                        color='#E0E0E0' align='center' width='100%' size='1' noshade style='margin: 0; padding: 0;' />"
                + "                </td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%;' class='list-item'><table align='center' border='0' cellspacing='0' cellpadding='0' style='width: inherit; margin: 0; padding: 0; border-collapse: collapse; border-spacing: 0;'>"
                + "                        <tr>"
                + "                </table></td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%;"
                + "                        padding-top: 25px;' class='line'><hr"
                + "                        color='#E0E0E0' align='center' width='100%' size='1' noshade style='margin: 0; padding: 0;' />"
                + "                </td>"
                + "        </tr>"
                + "</table>"
                + "<table border='0' cellpadding='0' cellspacing='0' align='center'"
                + "        width='560' style='border-collapse: collapse; border-spacing: 0; padding: 0; width: inherit;"
                + "        max-width: 560px;' class='wrapper'>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%;"
                + "                        padding-top: 25px;' class='social-icons'><table"
                + "                        width='256' border='0' cellpadding='0' cellspacing='0' align='center' style='border-collapse: collapse; border-spacing: 0; padding: 0;'>"
                + "                        </table>"
                + "                </td>"
                + "        </tr>"
                + "        <tr>"
                + "                <td align='center' valign='top' style='border-collapse: collapse; border-spacing: 0; margin: 0; padding: 0; padding-left: 6.25%; padding-right: 6.25%; width: 87.5%; font-size: 13px; font-weight: 400; line-height: 150%;"
                + "                        padding-top: 20px;"
                + "                        padding-bottom: 20px;"
                + "                        color: #999999;"
                + "                        font-family: sans-serif;' class='footer'> "
                + "No responda a este mensaje. Este correo electrónico ha sido enviado a través de un sistema automatizado que no permite dar respuesta a las preguntas enviadas a esta dirección. Para ponerse en contacto con nosotros, vaya al sitio web"
                + "                </td>"
                + "        </tr>"
                + "</table>"
                + "</td></tr></table>"
                + "</body>"
                + "</html>";
        return plantilla;
    }

}
