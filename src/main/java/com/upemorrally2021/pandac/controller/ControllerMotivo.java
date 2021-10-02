package com.upemorrally2021.pandac.controller;

import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Motivo;
import com.upemorrally2021.pandac.model.repository.RepositoryMotivo;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author cerimice
 */

@Component
public class ControllerMotivo extends Controller<Motivo,RepositoryMotivo>{

    @Override
    protected boolean validar(Motivo obj) throws Exception{
        if(obj.getNombre().isEmpty()){throw new Exception("No se ha proporcionado un nombre");}
        return true;
    }

    @Override
    public Motivo guardar(Motivo nuevo) throws Exception {
        try{
            if(validar(nuevo)){
                if(nuevo.getId() == 0){
                    return getRepositorio().save(nuevo);
                }
                
                Motivo viejo = getRepositorio().getById(nuevo.getId());
                    viejo.setNombre(nuevo.getNombre());
                    viejo.setDescripcion(nuevo.getDescripcion());
                return getRepositorio().save(nuevo);
            }
            return null;
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            throw ex;
        }
    }
    
}
