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
    private int dni;
    private LocalDate fecha;

    public Pago(int dni, LocalDate fecha) {
        this.dni = dni;
        this.fecha = fecha;
        this.id = null;
        this.idEmp = null;
    }

    public Pago(Integer id, Integer idEmp, int dni, LocalDate fecha) {
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}
