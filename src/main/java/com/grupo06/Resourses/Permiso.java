/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

import java.io.Serializable;

/**
 *
 * @author santi
 */
public class Permiso implements Serializable {
    private int idPermiso;
    private String nombrePermiso;
    
    public Permiso(int idPermiso, String nombrePermiso){
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }
    
    
}
