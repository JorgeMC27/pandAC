package com.upemorrally2021.pandac.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Motivo implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false, columnDefinition="text")
    private String descripcion;
    
    /* Metodos */
    @Override
    public String toString(){
        return nombre;
    }
}
