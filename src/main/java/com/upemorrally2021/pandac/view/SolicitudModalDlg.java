package com.upemorrally2021.pandac.view;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.ResponsiveRow;
import com.tiamex.comeiiEA.utils.Utils;
import com.upemorrally2021.pandac.model.entity.Motivo;
import com.upemorrally2021.pandac.view.utils.Element;
import com.upemorrally2021.pandac.view.utils.TemplateModalDlg;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import java.util.logging.Logger;

/** @author cerimice **/
public class SolicitudModalDlg extends TemplateModalDlg{
    
    private TextField nombre;
    private TextField email;
    private TextField telefono;
    private ComboBox<Motivo> motivo;
    
    public SolicitudModalDlg(){
        init();
    }
    
    private void init(){
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
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(nombre);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(email);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(telefono);
            row1.addColumn().withDisplayRules(1,1,3,4);
            
            row1.addColumn().withDisplayRules(1,1,3,4);
            row1.addColumn().withDisplayRules(10,10,6,4).withComponent(motivo);
            row1.addColumn().withDisplayRules(1,1,3,4);
        
        try{
            motivo.setItems(ui.getControllerMotivo().getRepositorio().findAll());
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
        }catch (Exception ex){
            Logger.getLogger(this.getClass().getName()).log(Utils.nivelLoggin(),ex.toString());
        }
    }
    
}
