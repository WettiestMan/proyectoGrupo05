/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.AsignacionPermisos;
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
public class SQLAsignacionPermisos {
    private static final String SELECT = "SELECT * FROM asignacion_permisos";
    private static final String INSERT = "INSERT INTO asignacion_permisos(id_Rol, id_Permiso) VALUES(?,?)";
    private static final String UPDATE = "UPDATE asignacion_permisos SET id_Rol=?, id_Permiso=? WHERE id_Rol=? AND id_Permiso=?";
    private static final String DELETE = "DELETE FROM asignacion_permisos WHERE id_Rol=? AND id_Permiso=?";
    private static final String GET_BY_ID = "SELECT * FROM asignacion_permisos WHERE id_Rol=? AND id_Permiso=?";
    private static final String GET_BY_ROLID = "SELECT * FROM asignacion_permisos WHERE id_Rol=?";
    private static final String GET_BY_PERMID = "SELECT * FROM asignacion_permisos WHERE id_Permiso=?";
    
    public List<AsignacionPermisos> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AsignacionPermisos> asignaciones = new ArrayList<>();
        AsignacionPermisos asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int idRol = rs.getInt("id_Rol");
                int idPermiso = rs.getInt("id_Permiso");

                asignacion = new AsignacionPermisos(idRol, idPermiso);
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
    
    public int SQL_INSERT(AsignacionPermisos asignacion){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, asignacion.getIdRol());
            pstmt.setInt(2, asignacion.getIdPermiso());
         
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
    
    public int SQL_UPDATE(AsignacionPermisos asignacionNuevo,
                          AsignacionPermisos asignacionPrev){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, asignacionNuevo.getIdRol());
            pstmt.setInt(2, asignacionNuevo.getIdPermiso());
            pstmt.setInt(3, asignacionPrev.getIdRol());
            pstmt.setInt(4, asignacionPrev.getIdPermiso());
            
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
    
    public int SQL_DELETE(AsignacionPermisos asignacion){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, asignacion.getIdRol());
            pstmt.setInt(2, asignacion.getIdPermiso());
            
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
    
    public AsignacionPermisos SQL_GET_BY_ID(int idRol, int idPermiso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        AsignacionPermisos asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_ID);
            pstmt.setInt(1, idRol);
            pstmt.setInt(2, idPermiso);
            rs = pstmt.executeQuery();
            
            if(rs.next())
                asignacion = new AsignacionPermisos(
                        rs.getInt("id_Rol"),
                        rs.getInt("id_Permiso"));
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
    
    public List<AsignacionPermisos> SQL_GET_BY_ROLID(int idRolSelecc) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AsignacionPermisos> asignaciones = new ArrayList<>();
        AsignacionPermisos asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_ROLID);
            pstmt.setInt(1, idRolSelecc);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int idRol = rs.getInt("id_Rol");
                int idPermiso = rs.getInt("id_Permiso");

                asignacion = new AsignacionPermisos(idRol, idPermiso);
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
    
    public List<AsignacionPermisos> SQL_GET_BY_PERMID(int idPermisoSelecc) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<AsignacionPermisos> asignaciones = new ArrayList<>();
        AsignacionPermisos asignacion = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(GET_BY_PERMID);
            pstmt.setInt(1, idPermisoSelecc);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int idRol = rs.getInt("id_Rol");
                int idPermiso = rs.getInt("id_Permiso");

                asignacion = new AsignacionPermisos(idRol, idPermiso);
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
}
