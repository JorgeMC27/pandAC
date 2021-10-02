package com.upemorrally2021.pandac;

import com.upemorrally2021.pandac.view.utils.Element;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

/** @author cerimice **/
@SpringUI
@PreserveOnRefresh
@Viewport("width=device-width, initial-scale=1")
@StyleSheet({"https://fonts.googleapis.com/css2?family=Lora:ital@1&display=swap"})
@Theme("mainTheme")
public class MainUI  extends UI{
    
    @Override
    protected void init(VaadinRequest request){
        this.setSizeFull();
        this.getUI().getPage().setTitle(Element.getSystemName());
    
    
    //this.setContent(new CropDlg());
    
    }
}
