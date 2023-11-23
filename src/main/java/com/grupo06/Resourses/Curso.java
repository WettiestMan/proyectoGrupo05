/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

/**
 *
 * @author santi
 */
public class Curso implements java.io.Serializable{
    private Integer id;
    private String titulo;
    private Integer idProf;
    private Integer idClas;
    
    public Curso(String titulo){
        this.titulo = titulo;
    }

    public Curso(Integer id, String titulo, Integer idProf, Integer idClas) {
        this.id = id;
        this.titulo = titulo;
        this.idProf = idProf;
        this.idClas = idClas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProf() {
        return idProf;
    }

    public void setIdProf(Integer idProf) {
        this.idProf = idProf;
    }

    public Integer getIdClas() {
        return idClas;
    }

    public void setIdClas(Integer idClas) {
        this.idClas = idClas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
