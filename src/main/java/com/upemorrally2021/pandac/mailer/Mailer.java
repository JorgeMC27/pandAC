package com.upemorrally2021.pandac.mailer;

import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Solicitud;
import com.upemorrally2021.pandac.view.utils.Element;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/** @author cerimice **/
@Component
public class Mailer{
    
    @Autowired private JavaMailSender mailSender;
    
    public void sendEmail(String to,String subject,String message) throws Exception{
        try{
            SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(to);
                email.setSubject(subject);
                email.setText(message);
            mailSender.send(email);
        }catch(MailException ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            throw ex;
        }
    }
    
    public void sendEmail(long solicitudId) throws Exception{
        try{
            Solicitud solicitud = Element.getUI().getControllerSolicitud().getRepositorio().getById(solicitudId);
            SimpleMailMessage email = new SimpleMailMessage();
                email.setTo(solicitud.getObjSitioAyuda().getObjResponsable().getEmail());
                email.setSubject("Alguien necesita ayuda");
                String mensaje = "Hola";
                    mensaje += "\n\nSe ha recibido una solicitd de ayuda de:";
                    mensaje += "\nNombre: "+solicitud.getNombre();
                    mensaje += "\nTelefono: "+solicitud.getTelefono();
                    mensaje += "\nEmail: "+solicitud.getEmail();
                    mensaje += "\n\nEs necesario atenderlo a la brevedad";
                email.setText(mensaje);
            mailSender.send(email);
        }catch(MailException ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            throw ex;
        }
    }
}
