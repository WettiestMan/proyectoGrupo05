/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

/**
 *
 * @author santi
 */
public class SQLActividadReciente {
    
    private static final String SELECT = "SELECT * FROM Empleados";
    private static final String INSERT = "INSERT INTO Empleados(fechaNac,Nombre,Apellidos,Cargo,Sueldo) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Empleados SET fechaNac=?,Nombre=?,Apellidos=?,Cargo=?,Sueldo=? WHERE id_Empleado=?";
    private static final String DELETE = "DELETE FROM Empleados WHERE id_Empleado=?";
}
