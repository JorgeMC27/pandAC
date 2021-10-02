package com.upemorrally2021.pandac.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SitioAyuda implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable=false)
    private String nombre;
    
    @Column(nullable=false, columnDefinition="text")
    private String direccion;
    
    @Column(nullable=false)
    private double latitud;
    
    @Column(nullable=false)
    private double longitud;

    @Column(nullable=false)
    private long responsable;
    
    /* Relaciones */
    @OneToMany(mappedBy = "objSitioAyuda")
    private List<Solicitud> listaSolicitudes;
    
    @ManyToOne
    @JoinColumn(name="responsable",referencedColumnName="id",insertable=false,updatable=false)
    private Responsable objResponsable;
    
    
    /* Metodos */
    @Override
    public String toString(){
        return nombre;
    }
}
