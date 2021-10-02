package com.upemorrally2021.pandac.testing;

import com.upemorrally2021.pandac.controller.ControllerMotivo;
import com.upemorrally2021.pandac.model.entity.Motivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** @author cerimice **/

@Component
public class CrearDatosMotivo{
    
    @Autowired private ControllerMotivo controlador;
    
    public boolean crearDatos()throws Exception{
        
        if(!controlador.getRepositorio().findAll().isEmpty()){return false;}
        
        String[] dts = {"Acoso","Maltrato","Abuso","Discriminación"};
        for(String motivo:dts){
            Motivo obj = new Motivo();
            obj.setNombre(motivo);
            obj.setDescripcion(motivo);
        controlador.guardar(obj);
        }
        
        return true;
    }
}
