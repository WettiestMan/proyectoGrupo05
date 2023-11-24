/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.EstudianteClase;
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
public class SQLEstudianteClase {
    
    private static final String SELECT = "SELECT * FROM Estudiantes";
    private static final String INSERT = "INSERT INTO Estudiantes(id_Clase,id_Estudiante,Estado) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE Estudiantes SET id_Clase=?,id_Estudiante=?,Estado=? WHERE id_Est_Clase=?";
    private static final String DELETE = "DELETE FROM Estudiantes WHERE id_Est_Clase=?";
    
    public List<EstudianteClase> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<EstudianteClase> estClases = new ArrayList<>();
        EstudianteClase estClas = null;
        try {
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Est_Clase");
                int idClas = rs.getInt("id_Clase");
                int idEst = rs.getInt("id_Estudiante");
                String estado = rs.getString("Estado");

                estClas = new EstudianteClase(id, estado, idClas, idEst);
                estClases.add(estClas);
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
        
        return estClases;
    }
    
    public int SQL_INSERT(EstudianteClase ec){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, ec.getIdClas());
            pstmt.setInt(2, ec.getIdEst());
            pstmt.setString(3, ec.getEstado());
         
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
    
    public int SQL_UPDATE(EstudianteClase ec){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, ec.getIdClas());
            pstmt.setInt(2, ec.getIdEst());
            pstmt.setString(3, ec.getEstado());
            pstmt.setInt(4, ec.getId());
         
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
    
     public int SQL_DELETE(EstudianteClase ec){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, ec.getId());
            
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
