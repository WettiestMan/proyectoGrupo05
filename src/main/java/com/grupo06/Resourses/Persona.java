package com.grupo06.Resourses;

import java.time.LocalDate;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected Integer id;
    protected LocalDate fechaNacimiento;
    protected int DNI;
    protected String nombre;
    protected String apellidos;

    public Persona(LocalDate fechaNacimiento, int DNI, String nombre, String apellidos) {
        this.fechaNacimiento = fechaNacimiento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = null;
    }

    public Persona(Integer id, LocalDate fechaNacimiento, int DNI, String nombre, String apellidos) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    //public abstract String toQuery();
    
    @Override
    public abstract String toString();
        
}
