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
public class DetallePago implements Serializable {
    private Integer id;
    private int costo;
    private String descripcion;
    private String razon;
    private Integer idPag;
    private Integer idEstClas;

    public DetallePago(int costo, String descripcion, String razon, Integer idPag, Integer idEstClas) {
        this.costo = costo;
        this.descripcion = descripcion;
        this.razon = razon;
        this.idPag = idPag;
        this.idEstClas = idEstClas;
    }

    public DetallePago(Integer id, int costo, String descripcion, String razon, Integer idPag, Integer idEstClas) {
        this.id = id;
        this.costo = costo;
        this.descripcion = descripcion;
        this.razon = razon;
        this.idPag = idPag;
        this.idEstClas = idEstClas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPag() {
        return idPag;
    }

    public void setIdPag(Integer idPag) {
        this.idPag = idPag;
    }

    public Integer getIdEstClas() {
        return idEstClas;
    }

    public void setIdEstClas(Integer idEstClas) {
        this.idEstClas = idEstClas;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
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
