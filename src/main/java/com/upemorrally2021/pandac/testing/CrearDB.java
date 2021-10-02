package com.upemorrally2021.pandac.testing;

import com.upemorrally2021.pandac.controller.ControllerSolicitud;
import com.upemorrally2021.pandac.mailer.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/** @author cerimice **/

@Component
public class CrearDB implements ApplicationRunner{
    
    @Autowired CrearDatosMotivo crearDatosMotivo;
    @Autowired CrearDatosSitioAyuda crearDatosSitioAyuda;
    @Autowired ControllerSolicitud controllerSolicitud;
    @Autowired Mailer mailer;
    
    @Override
    public void run(ApplicationArguments args) throws Exception{
        System.out.println("");
        System.out.println("Iniciando testing");
        
        crearDatosMotivo.crearDatos();
        crearDatosSitioAyuda.crearDatos();
        
        System.out.println("Probando mailer");
        mailer.sendEmail("cerimice@gmail.com","Probandooo","Mensajeeeee");
        
        System.out.println("Finalizando testing");
        System.out.println("");
        
    }
}
