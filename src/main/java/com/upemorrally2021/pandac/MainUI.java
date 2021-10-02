package com.upemorrally2021.pandac;

import com.upemorrally2021.pandac.controller.ControllerMotivo;
import com.upemorrally2021.pandac.controller.ControllerResponsable;
import com.upemorrally2021.pandac.controller.ControllerSitioAyuda;
import com.upemorrally2021.pandac.controller.ControllerSolicitud;
import com.upemorrally2021.pandac.mailer.Mailer;
import com.upemorrally2021.pandac.model.entity.SitioAyuda;
import com.upemorrally2021.pandac.view.SolicitudModalDlg;
import com.upemorrally2021.pandac.view.utils.Element;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/** @author cerimice **/
@SpringUI
@PreserveOnRefresh
@Viewport("width=device-width, initial-scale=1")
@StyleSheet({"https://fonts.googleapis.com/css2?family=Lora:ital@1&display=swap"})
@Theme("mainTheme")
public class MainUI  extends UI{
    
    @Getter @Autowired private ControllerMotivo controllerMotivo;
    @Getter @Autowired private ControllerResponsable controllerResponsable;
    @Getter @Autowired private ControllerSitioAyuda controllerSitioAyuda;
    @Getter @Autowired private ControllerSolicitud controllerSolicitud;
    
    @Getter @Autowired private Mailer mailer;
    
    @Override
    protected void init(VaadinRequest request){
        this.setSizeFull();
        this.getUI().getPage().setTitle(Element.getSystemName());
        
        String sitioAyudaId = request.getParameter("sa");
        if(sitioAyudaId == null){sitioAyudaId = "0";}
        
        SitioAyuda sitioAyuda = controllerSitioAyuda.getRepositorio().getById(new Long(sitioAyudaId));
        if(sitioAyuda != null)
            this.setContent(new SolicitudModalDlg(sitioAyuda));
        
        /*
        ip temporal: 172.23.48.57
        url 1: http://172.23.48.57:23627/?sa=1
        url 2: http://172.23.48.57:23627/?sa=2
        url 3: http://172.23.48.57:23627/?sa=3
        */
    
    }
}
