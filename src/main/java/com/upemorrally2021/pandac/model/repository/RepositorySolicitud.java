/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.upemorrally2021.pandac.model.repository;
import com.upemorrally2021.pandac.model.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User-Lap
 */
public interface RepositorySolicitud extends JpaRepository<Solicitud,Long> {
    
    
}
