/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

import java.time.LocalDate;

/**
 *
 * @author santi
 */
public class Pago implements java.io.Serializable{
    private Integer id;
    private Integer idEmp;
    private String dni;
    private LocalDate fecha;

    public Pago(Integer idEmp, String dni, LocalDate fecha) {
        this.dni = dni;
        this.fecha = fecha;
        this.id = null;
        this.idEmp = idEmp;
    }

    public Pago(Integer id, Integer idEmp, String dni, LocalDate fecha) {
        this.id = id;
        this.idEmp = idEmp;
        this.dni = dni;
        this.fecha = fecha;
    }

    public Integer getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(Integer idEmp) {
        this.idEmp = idEmp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
