package com.upemorrally2021.pandac.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Solicitud implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false) private LocalDateTime fecha;
    @Column(nullable=false) private String nombre;
    @Column(nullable=false) private String email;
    @Column(nullable=false) private String telefono;
    @Column(nullable=false) private long motivo;
    
    /* Relaciones */
    @ManyToOne
    @JoinColumn(name="motivo",referencedColumnName="id",insertable=false,updatable=false)
    private Motivo objMotivo;
    
    /* Metodos */
    @Override
    public String toString(){
        return nombre;
    }
}