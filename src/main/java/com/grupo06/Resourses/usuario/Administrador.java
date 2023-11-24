/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.usuario;

import java.time.LocalDate;

/**
 *
 * @author santi
 */
public class Administrador extends com.grupo06.Resourses.Usuario{
    
    public Administrador(int id, LocalDate fechaNacimiento, String DNI, String nombre, String apellidos, String usuario, String contrasena) {
        super(id, fechaNacimiento, DNI, nombre, apellidos, usuario, contrasena);
    }

}
