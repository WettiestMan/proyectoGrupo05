/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author santi
 */
public class ActividadReciente implements Serializable {
    private Integer id;
    private String desc;
    private java.time.LocalDate fecha_act;
    private int ganancia;
    private int perdida;

    public ActividadReciente(Integer id, String desc, LocalDate fecha_act, int ganancia, int perdida) {
        this.id = id;
        this.desc = desc;
        this.fecha_act = fecha_act;
        this.ganancia = ganancia;
        this.perdida = perdida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getFecha_act() {
        return fecha_act;
    }

    public void setFecha_act(LocalDate fecha_act) {
        this.fecha_act = fecha_act;
    }

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }

    public int getPerdida() {
        return perdida;
    }

    public void setPerdida(int perdida) {
        this.perdida = perdida;
    }
    
    
}
