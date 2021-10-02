/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.upemorrally2021.pandac.controller;


import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Solicitud;
import com.upemorrally2021.pandac.model.repository.RepositorySolicitud;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author User-Lap
 */

@Component
public class ControllerSolicitud extends Controller<Solicitud, RepositorySolicitud>{

    @Override
    protected boolean validar(Solicitud obj) throws Exception {
        
       if(obj.getNombre().isEmpty()){throw new Exception("El nombre no se ha proporcionado");}
       if(obj.getEmail().isEmpty()){throw new Exception("El email no se ha proporcionado");}
       if(obj.getTelefono().isEmpty()){throw new Exception("El telefono no se ha proporcionado");}
       
       
       
       
       return true; 
    }


    @Override
    public Solicitud guardar(Solicitud nuevo) throws Exception {
        try{
            if (validar(nuevo)) {
                if (nuevo.getId()==0) {
                    return getRepositorio().save(nuevo);
                }
               
            }
            return null;
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            throw ex;
        }
    }
    
}
