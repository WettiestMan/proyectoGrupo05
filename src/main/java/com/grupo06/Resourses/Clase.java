/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

/**
 *
 * @author santi
 */
public class Clase implements java.io.Serializable{
    private String nivel;
    private byte grado;
    private char seccion;

    public Clase(String nivel, byte grado, char seccion) {
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public byte getGrado() {
        return grado;
    }

    public void setGrado(byte grado) {
        this.grado = grado;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }
    
    
}
