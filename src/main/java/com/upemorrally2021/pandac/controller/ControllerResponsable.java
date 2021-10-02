package com.upemorrally2021.pandac.controller;

import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Responsable;
import com.upemorrally2021.pandac.model.repository.RepositoryResponsable;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author User-Lap
 */

@Component
public class ControllerResponsable extends Controller<Responsable, RepositoryResponsable>{

    @Override
    protected boolean validar(Responsable obj) throws Exception {
        
       if(obj.getNombre().isEmpty()){throw new Exception("El nombre no se ha proporcionado");}
       if(obj.getEmail().isEmpty()){throw new Exception("El email no se ha proporcionado");}
       if(obj.getTelefono().isEmpty()){throw new Exception("El telefono no se ha proporcionado");}
       
       
       
       
       return true; 
    }

    @Override
    public Responsable guardar(Responsable nuevo) throws Exception {
           try{
            if (validar(nuevo)) {
                if (nuevo.getId()==0) {
                    return getRepositorio().save(nuevo);
                }
                Responsable viejo= getRepositorio().getById(nuevo.getId());
                    viejo.setNombre(nuevo.getNombre());
                    viejo.setEmail(nuevo.getEmail());
                    viejo.setTelefono(nuevo.getTelefono());
                return getRepositorio().save(nuevo);
            }
            return null;
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            throw ex;
        }
    }
    
}
