package com.upemorrally2021.pandac.view;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.ResponsiveRow;
import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Motivo;
import com.upemorrally2021.pandac.model.entity.SitioAyuda;
import com.upemorrally2021.pandac.model.entity.Solicitud;
import com.upemorrally2021.pandac.view.utils.Element;
import com.upemorrally2021.pandac.view.utils.TemplateModalDlg;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.Position;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import java.time.LocalDateTime;
import java.util.logging.Logger;

/** @author cerimice **/
public class SolicitudModalDlg extends TemplateModalDlg{
    
    private TextField nombre;
    private TextField email;
    private TextField telefono;
    private ComboBox<Motivo> motivo;
    private ComboBox<SitioAyuda> sitioAyuda;
    
    public SolicitudModalDlg(SitioAyuda sitioAyuda){
        init();
        this.sitioAyuda.setValue(sitioAyuda);
    }
    
    private void init(){
        Image image = new Image("",new ThemeResource("images/logo/logo.jpeg"));
            image.setWidth("100%");
        sitioAyuda = new ComboBox<>();
            Element.cfgComponent(sitioAyuda,"Sitio ayuda");
            sitioAyuda.setEnabled(false);
        nombre = new TextField();
            Element.cfgComponent(nombre,"Nombre");
        email = new TextField();
            Element.cfgComponent(email,"email");
        telefono = new TextField();
            Element.cfgComponent(telefono,"Teléfono");
        motivo = new ComboBox<>();
            Element.cfgComponent(motivo,"Motivo");
        
        ResponsiveLayout content = new ResponsiveLayout();
        ResponsiveRow row1 = content.addRow().withAlignment(Alignment.TOP_CENTER);
            row1.addColumn().withDisplayRules(2,2,4,4);
            row1.addColumn().withDisplayRules(8,8,4,4).withComponent(image);
            row1.addColumn().withDisplayRules(2,2,4,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(nombre);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(telefono);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(sitioAyuda);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(email);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(motivo);
            row1.addColumn().withDisplayRules(1,1,3,4);
        
        try{
            motivo.setItems(ui.getControllerMotivo().getRepositorio().findAll());
            sitioAyuda.setItems(ui.getControllerSitioAyuda().getRepositorio().findAll());
        }catch(Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
        }
        
        contentLayout.addComponent(content);
        setCaption("Solicitud de ayuda");
    }
    
    @Override
    protected void buttonCancelEvent(){
        
    }

    @Override
    protected void loadData(long id){
    }

    @Override
    protected void buttonAcceptEvent(){
        try{
            Solicitud solicitud = new Solicitud();
                solicitud.setEmail(email.getValue());
                solicitud.setFecha(LocalDateTime.now());
                solicitud.setMotivo(motivo.getValue().getId());
                solicitud.setNombre(nombre.getValue());
                solicitud.setSitioAyuda(sitioAyuda.getValue().getId());
                solicitud.setTelefono(telefono.getValue());
            solicitud = ui.getControllerSolicitud().guardar(solicitud);
            if(solicitud != null){
                ui.getMailer().sendEmail(solicitud.getId());
                ui.setContent(new SolicitudAceptadaDlg());
            }
        }catch (Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
            Element.makeNotification("Solicitud enviada",Notification.Type.WARNING_MESSAGE,Position.TOP_CENTER).show(ui.getPage());
        }
    }
    
}
