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
public class Cliente extends Persona {
    private double deuda;
    private String correo;
    private int numTelefono;
    
    public Cliente(LocalDate fechaNacimiento, int DNI, String nombre,
            String apellidos, double deuda, String correo, int numTelefono){
        super(fechaNacimiento, DNI, nombre, apellidos);
        this.deuda = deuda;
        this.correo = correo;
        this.numTelefono = numTelefono; 
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    
    @Override
    public String toString() {
        return String.format("[fechaNacimiento: %s, Nombre: %s, "
                + "Apellidos: %s, DNI: %d, Deuda: %.2f, Correo: %s, "
                + "Número de teléfono: %d]", fechaNacimiento, nombre,
                apellidos, DNI, deuda, correo, numTelefono);
    }
}
