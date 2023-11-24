package com.grupo06.Resourses;

import java.time.LocalDate;

public class Estudiante extends Persona{

    private byte grado;         
    private String correo;
    private int numTelefono;
  
    public Estudiante(Integer id, LocalDate fechaNacimiento, String DNI, String nombre,
            String apellidos, byte grado, String correo, int numTelefono){
        super(id, fechaNacimiento, DNI, nombre, apellidos);
        this.grado = grado;
        this.correo = correo;
        this.numTelefono = numTelefono; 
    }

    public byte getGrado() {
        return grado;
    }

    public void setGrado(byte grado) {
        this.grado = grado;
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
                + "Apellidos: %s, DNI: %s, Grado: %d, Correo: %s, "
                + "Número de teléfono: %d]", fechaNacimiento, nombre,
                apellidos, DNI, grado, correo, numTelefono);
    }
    
}
