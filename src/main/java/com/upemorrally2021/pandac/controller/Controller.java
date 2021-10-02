package com.upemorrally2021.pandac.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/** @author cerimice **/
public abstract class Controller<Entity,Repository>{
    
    @Getter 
    @Autowired 
    private Repository repositorio;
    
    protected abstract boolean validar(Entity obj) throws Exception;
    public abstract Entity guardar(Entity nuevo) throws Exception;
    
}
