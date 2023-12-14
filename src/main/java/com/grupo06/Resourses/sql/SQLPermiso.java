/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.Permiso;
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
public class SQLPermiso {
    private static final String SELECT = "SELECT * FROM permisos";
    private static final String INSERT = "INSERT INTO permisos(Nombre_Permiso) VALUES(?)";
    private static final String UPDATE = "UPDATE permisos SET Nombre_Permiso=? WHERE id_Permiso=?";
    private static final String DELETE = "DELETE FROM permisos WHERE id_Permiso=?";
    private static final String GET_BY_ID = "SELECT * FROM permisos WHERE id_Permiso=?";
    private static final String GET_BY_NAME = "SELECT * FROM permisos WHERE Nombre_Permiso=?";
    
    public List<Permiso> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Permiso> permisos = new ArrayList<>();
        Permiso permiso = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Permiso");
                String nombre = rs.getString("Nombre_Permiso");

                permiso = new Permiso(id, nombre);
                permisos.add(permiso);
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
        
        return permisos;
    }
    
    public int SQL_INSERT(Permiso permiso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, permiso.getNombrePermiso());
         
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
    
    public int SQL_UPDATE(Permiso permiso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, permiso.getNombrePermiso());
            pstmt.setInt(2, permiso.getIdPermiso());
            
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
    
    public int SQL_DELETE(Permiso permiso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, permiso.getIdPermiso());
            
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
    
    public Permiso SQL_GET_BY_ID(int idPermiso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Permiso permiso = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, idPermiso);
            rs = pstmt.executeQuery();
            
            if(rs.next())
                permiso = new Permiso(
                        rs.getInt("id_Permiso"),
                        rs.getString("Nombre_Permiso"));
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
        
        return permiso;
    }
    
    // Retorna una List en vez de un único objeto para manejar duplicados (en
    // caso haya)
    public List<Permiso> SQL_GET_BY_NAME(String nombrePermiso) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Permiso> permisos = new ArrayList<>();
        Permiso permiso = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_NAME);
            pstmt.setString(1, nombrePermiso);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Permiso");
                String nombre = rs.getString("Nombre_Permiso");

                permiso = new Permiso(id, nombre);
                permisos.add(permiso);
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
        
        return permisos;
    }
}
