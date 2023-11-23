/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

/**
 *
 * @author santi
 */
public class EstudianteClase implements java.io.Serializable{
    private Integer id;
    private String estado;
    private Integer idClas;
    private Integer idEst;

    public EstudianteClase(String estado) {
        this.estado = estado;
    }

    public EstudianteClase(Integer id, String estado, Integer idClas, Integer idEst) {
        this.id = id;
        this.estado = estado;
        this.idClas = idClas;
        this.idEst = idEst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClas() {
        return idClas;
    }

    public void setIdClas(Integer idClas) {
        this.idClas = idClas;
    }

    public Integer getIdEst() {
        return idEst;
    }

    public void setIdEst(Integer idEst) {
        this.idEst = idEst;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
