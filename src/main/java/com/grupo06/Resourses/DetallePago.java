/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author santi
 */
public class DetallePago implements Serializable {
    private BigDecimal costo;
    private String descripcion;
    private String razon;

    public DetallePago(BigDecimal costo, String descripcion, String razon) {
        this.costo = costo;
        this.descripcion = descripcion;
        this.razon = razon;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
}
