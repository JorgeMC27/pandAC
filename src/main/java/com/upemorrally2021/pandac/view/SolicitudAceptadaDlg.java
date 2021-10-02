package com.upemorrally2021.pandac.view;

import com.jarektoro.responsivelayout.ResponsiveLayout;
import com.jarektoro.responsivelayout.ResponsiveRow;
import com.upemorrally2021.pandac.view.utils.Element;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

/** @author cerimice **/
public class SolicitudAceptadaDlg extends Panel{
    
    public SolicitudAceptadaDlg(){
        init();
    }
    
    private void init(){
        
        Label label1 = new Label("<center>Tu registro se ha enviado</center>",ContentMode.HTML);
            label1.addStyleNames(ValoTheme.LABEL_H1);
        Label label2 = new Label("<center>Iniciamos el proceso de contacto</center>",ContentMode.HTML);
            label2.addStyleNames(ValoTheme.LABEL_H3);
        ResponsiveLayout contenido =  new ResponsiveLayout();
            Element.cfgLayoutComponent(contenido);
        ResponsiveRow row1 = contenido.addRow().withAlignment(Alignment.TOP_CENTER);
            row1.addColumn().withDisplayRules(12,12,12,12).withComponent(label1);
            row1.addColumn().withDisplayRules(12,12,12,12).withComponent(label2);
            
        this.setContent(contenido);
        this.setCaptionAsHtml(true);
    }
    
}
