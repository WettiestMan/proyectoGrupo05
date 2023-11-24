/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.*;
import com.grupo06.Resourses.Empleado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author santi
 */
public class SQLEmpleado {
    
    private static final String SELECT = "SELECT * FROM Empleados";
    private static final String INSERT = "INSERT INTO Empleados(fechaNac,Nombre,Apellidos,Cargo,Sueldo) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Empleados SET fechaNac=?,Nombre=?,Apellidos=?,Cargo=?,Sueldo=? WHERE id_Empleado=?";
    private static final String DELETE = "DELETE FROM Empleados WHERE id_Empleado=?";
    
    public List<Empleado> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<>();
        Empleado empleado = null;
        try {
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Empleado");
                Date fechaNacimiento = rs.getDate("fechaNac");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellidos");
                String cargo = rs.getString("Cargo");
                int sueldo = rs.getInt("Sueldo");

                empleado = new Empleado(fechaNacimiento.toLocalDate(), nombre, apellido, cargo, sueldo);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(rs);
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return empleados;
    }
    
    public int SQL_INSERT(Empleado empleado){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setDate(1, (Date) Date.from(empleado.getFecNac().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, empleado.getNombre());
            pstmt.setString(3, empleado.getApellido());
            pstmt.setString(4, empleado.getCargo());
            pstmt.setInt(5, empleado.getSueldo());
         
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int SQL_UPDATE(Empleado empleado){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, (Date) Date.from(empleado.getFecNac().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, empleado.getNombre());
            pstmt.setString(3, empleado.getApellido());
            pstmt.setString(4, empleado.getCargo());
            pstmt.setInt(5, empleado.getSueldo());
            pstmt.setInt(6, empleado.getId());
         
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int SQL_DELETE(Empleado empleado){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, empleado.getId());
            
            registros = pstmt.executeUpdate();
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
