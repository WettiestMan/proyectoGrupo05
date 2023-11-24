/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.ActividadReciente;
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
public class SQLActividadReciente {
    
    private static final String SELECT = "SELECT * FROM Actividad_Reciente";
    private static final String INSERT = "INSERT INTO Actividad_Reciente(Descripcion,Fecha_act,Ganancia,Perdida) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE Actividad_Reciente SET Descripcion=?,Fecha_act=?,Ganancia=?,Perdida=? WHERE id_ActRec=?";
    private static final String DELETE = "DELETE FROM Actividad_Reciente WHERE id_ActRec=?";
    
    public List<ActividadReciente> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ActividadReciente> ars = new ArrayList<>();
        ActividadReciente ar = null;
        try {
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_ActRec");
                String desc = rs.getString("Descripcion");
                Date fecha = rs.getDate("Fecha_act");
                int ganancia = rs.getInt("Ganancia");
                int perdida = rs.getInt("Perdida");

                ar = new ActividadReciente(id, desc, fecha.toLocalDate(), ganancia, perdida);
                ars.add(ar);
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
        
        return ars;
    }
    
    public int SQL_INSERT(ActividadReciente ar){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, ar.getDesc());
            pstmt.setDate(2, (Date) Date.from(ar.getFecha_act().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(3, ar.getGanancia());
            pstmt.setInt(4, ar.getPerdida());
         
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
    
    public int SQL_UPDATE(ActividadReciente ar){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, ar.getDesc());
            pstmt.setDate(2, (Date) Date.from(ar.getFecha_act().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(3, ar.getGanancia());
            pstmt.setInt(4, ar.getPerdida());
            pstmt.setInt(5, ar.getId());
         
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
    
    public int SQL_DELETE(ActividadReciente ar){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, ar.getId());
            
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
