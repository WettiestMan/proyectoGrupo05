/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.*;
import com.grupo06.Resourses.Pago;
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
public class SQLPago {
    private static final String SELECT = "SELECT * FROM Pago";
    private static final String INSERT = "INSERT INTO Pago(DNI_cliente,Fecha,id_Empleado) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE Estudiantes SET DNI_cliente=?,Fecha=?,id_Empleado=? WHERE id_Pago=?";
    private static final String DELETE = "DELETE FROM Pago WHERE id_Pago=?";
    
     public List<Pago> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Pago> pagos = new ArrayList<>();
        Pago pago = null;
        try {
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Pago");
                Date fecha = rs.getDate("Fecha");
                String dni = rs.getString("DNI_cliente");
                int idEmp = rs.getInt("id_Empleado");
                
                pago = new Pago(id, idEmp, dni, fecha.toLocalDate());
                pagos.add(pago);
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
        
        return pagos;
    }
    
    public int SQL_INSERT(Pago pago){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, pago.getDni());
            pstmt.setDate(2, (Date) Date.from(pago.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(3, pago.getIdEmp());
         
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
    
    public int SQL_UPDATE(Pago pago){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, pago.getDni());
            pstmt.setDate(2, (Date) Date.from(pago.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(3,pago.getIdEmp());
            pstmt.setInt(4, pago.getId());
         
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
    
    public int SQL_DELETE(Pago pago){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, pago.getId());
            
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
