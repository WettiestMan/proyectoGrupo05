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
public class Empleado implements java.io.Serializable{
    private LocalDate fecNac;
    private Integer id;
    private String nombre;
    private String apellido;
    private String cargo;
    private int sueldo;
    private String contrasena;

    public Empleado(LocalDate fecNac, String nombre, String apellido, String cargo, int sueldo) {
        this.fecNac = fecNac;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Empleado(LocalDate fecNac, Integer id, String nombre, String apellido, String cargo, int sueldo) {
        this.fecNac = fecNac;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.contrasena = contrasena;
    }

    public Empleado(LocalDate fecNac, String nombre, String apellido, String cargo, String contrasena, int sueldo) {
        this.fecNac = fecNac;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
        this.sueldo = sueldo;
        this.id = null;
    }

    public Empleado(Integer id, LocalDate fecNac, String nombre, String apellido, String cargo, String contrasena, int sueldo) {
        this.id = id;
        this.fecNac = fecNac;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.contrasena = contrasena;
        this.sueldo = sueldo;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
