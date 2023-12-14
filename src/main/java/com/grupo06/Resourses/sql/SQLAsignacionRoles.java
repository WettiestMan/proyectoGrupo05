/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.AsignacionRoles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class SQLAsignacionRoles {
    private static final String SELECT = "SELECT * FROM asignacion_roles";
    private static final String INSERT = "INSERT INTO asignacion_roles(id_Empleado, id_Rol) VALUES(?,?)";
    private static final String UPDATE = "UPDATE asignacion_roles SET id_Empleado=?, id_Rol=? WHERE id_Empleado=? AND id_Rol=?";
    private static final String DELETE = "DELETE FROM asignacion_roles WHERE id_Empleado=? AND id_Rol=?";
    private static final String GET_BY_ID = "SELECT * FROM asignacion_roles WHERE id_Empleado=? AND id_Rol=?";
    
    public List<AsignacionRoles> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AsignacionRoles> asignaciones = new ArrayList<>();
        AsignacionRoles asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int idEmpleado = rs.getInt("id_Empleado");
                int idRol = rs.getInt("id_Rol");

                asignacion = new AsignacionRoles(idEmpleado, idRol);
                asignaciones.add(asignacion);
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
        
        return asignaciones;
    }
    
    public int SQL_INSERT(AsignacionRoles asignacion){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, asignacion.getIdEmpleado());
            pstmt.setInt(2, asignacion.getIdRol());
         
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
    
    public int SQL_UPDATE(AsignacionRoles asignacionNuevo,
                          AsignacionRoles asignacionPrev){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, asignacionNuevo.getIdEmpleado());
            pstmt.setInt(2, asignacionNuevo.getIdRol());
            pstmt.setInt(3, asignacionPrev.getIdEmpleado());
            pstmt.setInt(4, asignacionPrev.getIdRol());
            
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
    
    public int SQL_DELETE(AsignacionRoles asignacion){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, asignacion.getIdEmpleado());
            pstmt.setInt(2, asignacion.getIdRol());
            
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
    
    public AsignacionRoles SQL_GET_BY_ID(int idEmpleado, int idRol){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AsignacionRoles asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, idEmpleado);
            pstmt.setInt(2, idRol);
            rs = pstmt.executeQuery();
            
            if(rs.next())
                asignacion = new AsignacionRoles(
                        rs.getInt("id_Empleado"),
                        rs.getInt("id_Rol"));
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
        
        return asignacion;
    }
}
