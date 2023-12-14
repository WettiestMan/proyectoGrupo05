/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.Rol;
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
public class SQLRol {
    private static final String SELECT = "SELECT * FROM roles";
    private static final String INSERT = "INSERT INTO roles(Nombre_Rol) VALUES(?)";
    private static final String UPDATE = "UPDATE roles SET Nombre_Rol=? WHERE id_Rol=?";
    private static final String DELETE = "DELETE FROM roles WHERE id_Rol=?";
    private static final String GET_BY_ID = "SELECT * FROM roles WHERE id_Rol=?";
    private static final String GET_BY_NAME = "SELECT * FROM permisos WHERE Nombre_Rol=?";
    
    public List<Rol> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Rol> roles = new ArrayList<>();
        Rol rol = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Rol");
                String nombre = rs.getString("Nombre_Rol");

                rol = new Rol(id, nombre);
                roles.add(rol);
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
        
        return roles;
    }
    
    public int SQL_INSERT(Rol rol){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, rol.getNombreRol());
         
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
    
    public int SQL_UPDATE(Rol rol){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, rol.getNombreRol());
            pstmt.setInt(2, rol.getIdRol());
            
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
    
    public int SQL_DELETE(Rol rol){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, rol.getIdRol());
            
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
    
    public Rol SQL_GET_BY_ID(int idRol){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Rol rol = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, idRol);
            rs = pstmt.executeQuery();
            
            if(rs.next())
                rol = new Rol(
                        rs.getInt("id_Rol"),
                        rs.getString("Nombre_Rol"));
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
        
        return rol;
    }
    
    // Retorna una List en vez de un único objeto para manejar duplicados (en
    // caso haya)
    public List<Rol> SQL_GET_BY_NAME(String nombreRol) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Rol> roles = new ArrayList<>();
        Rol rol = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_NAME);
            pstmt.setString(1, nombreRol);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Rol");
                String nombre = rs.getString("Nombre_Rol");

                rol = new Rol(id, nombre);
                roles.add(rol);
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
        
        return roles;
    }
}
