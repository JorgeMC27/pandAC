package com.upemorrally2021.pandac.testing;

import com.upemorrally2021.pandac.controller.ControllerResponsable;
import com.upemorrally2021.pandac.controller.ControllerSitioAyuda;
import com.upemorrally2021.pandac.model.entity.Responsable;
import com.upemorrally2021.pandac.model.entity.SitioAyuda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/** @author cerimice **/

@Component
public class CrearDatosSitioAyuda{
    
    @Autowired private ControllerSitioAyuda controladorSitioAyuda;
    @Autowired private ControllerResponsable controladorResponsable;
    
    public boolean crearDatos()throws Exception{
        
        if(!controladorSitioAyuda.getRepositorio().findAll().isEmpty()){return false;}
        
        Responsable responsable = new Responsable();
            responsable.setEmail("cminauro@upemor.edu.mx");
            responsable.setNombre("Cesar Minauro");
            responsable.setTelefono("7773270000");
        responsable = controladorResponsable.guardar(responsable);
        
        SitioAyuda sitioAyuda = new SitioAyuda();
            sitioAyuda.setDireccion("Conocido");
            sitioAyuda.setLatitud(18.889872);
            sitioAyuda.setLongitud(-99.139726);
            sitioAyuda.setNombre("Upemor - Entrada principal");
            sitioAyuda.setResponsable(responsable.getId());
        controladorSitioAyuda.guardar(sitioAyuda);
        
        sitioAyuda = new SitioAyuda();
            sitioAyuda.setDireccion("Conocido");
            sitioAyuda.setLatitud(18.889872);
            sitioAyuda.setLongitud(-99.139726);
            sitioAyuda.setNombre("Upemor - Entrada UD1");
            sitioAyuda.setResponsable(responsable.getId());
        controladorSitioAyuda.guardar(sitioAyuda);
        
        sitioAyuda = new SitioAyuda();
            sitioAyuda.setDireccion("Conocido");
            sitioAyuda.setLatitud(18.889872);
            sitioAyuda.setLongitud(-99.139726);
            sitioAyuda.setNombre("Upemor - Entrada UD2");
            sitioAyuda.setResponsable(responsable.getId());
        controladorSitioAyuda.guardar(sitioAyuda);
        
        sitioAyuda = new SitioAyuda();
            sitioAyuda.setDireccion("Conocido");
            sitioAyuda.setLatitud(18.889872);
            sitioAyuda.setLongitud(-99.139726);
            sitioAyuda.setNombre("Upemor - Entrada LT1");
            sitioAyuda.setResponsable(responsable.getId());
        controladorSitioAyuda.guardar(sitioAyuda);
        
        return true;
    }
}
