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
public class Usuario extends Persona {
    protected String usuario;
    protected String contrasena;
    
    public Usuario(int id, LocalDate fechaNacimiento, int DNI, String nombre,
            String apellidos, String usuario, String contrasena) {
        super(id, fechaNacimiento, DNI, nombre, apellidos);
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return String.format("[fechaNacimiento: %s, Nombre: %s, "
                + "Apellidos: %s, DNI: %d, Usuario: %s, Contraseña: %s]",
                fechaNacimiento, nombre,apellidos, DNI,
                usuario, contrasena);
    }
    
    

}
