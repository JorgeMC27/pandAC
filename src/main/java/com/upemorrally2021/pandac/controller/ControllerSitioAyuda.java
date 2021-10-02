package com.upemorrally2021.pandac.controller;

import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.SitioAyuda;
import com.upemorrally2021.pandac.model.repository.RepositorySitioAyuda;
import java.util.logging.Logger;

/**
 *
 * @author 
 *  Rodrigo C. B.
 *  cbro172663 
 */
public class ControllerSitioAyuda extends Controller<SitioAyuda, RepositorySitioAyuda>{
     //Atributos

    //Métodos
    @Override
    protected boolean validar(SitioAyuda obj) throws Exception {
        if (obj.getNombre().isEmpty()){
            throw new Exception("El nombre no se ha proporcionado");
        }
        return true;
    }

    @Override
    public SitioAyuda guardar(SitioAyuda nuevo) throws Exception {
        try {
            if (validar(nuevo)) {
                if (nuevo.getId() == 0) {
                    return getRepositorio().save(nuevo);
                }
                
                SitioAyuda viejo = getRepositorio().getById(nuevo.getId());
                viejo.setNombre(nuevo.getNombre());
                viejo.setResponsable(nuevo.getResponsable());
                viejo.setDireccion(nuevo.getDireccion());
            }
            return null;
        } catch (Exception e){ 
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),e.toString());
            throw e;
        }
    }
   


}
