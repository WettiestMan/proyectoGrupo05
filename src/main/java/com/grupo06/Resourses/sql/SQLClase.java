package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.Clase;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLClase {
    private static final String SELECT = "SELECT * FROM Clases";
    private static final String INSERT = "INSERT INTO Clases(Nivel,Grado,Seccion,id_Profesor) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE Clases SET Nivel=?,Grado=?,Seccion=?,id_Profesor=? WHERE id_Clase=?";
    private static final String DELETE = "DELETE FROM Clases WHERE id_Clase=?";

    public List<Clase> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Clase> clases = new ArrayList<>();
        Clase clase = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Integer id = rs.getInt("id_Clase");
                String nivel = rs.getString("Nivel");
                byte grado = rs.getByte("Grado");
                char seccion = rs.getString("Seccion").charAt(0);
                int id_Profesor = rs.getInt("id_Profesor");

                clase = new Clase(id, nivel, grado, seccion,id_Profesor);
                clases.add(clase);
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
        
        return clases;
    }
    
    public int SQL_INSERT(Clase clase){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, clase.getNivel());
            pstmt.setByte(2, clase.getGrado());
            pstmt.setString(3, String.valueOf(clase.getSeccion()));
            pstmt.setInt(4, clase.getId_profesor());
         
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
    
    public int SQL_UPDATE(Clase clase){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, clase.getNivel());
            pstmt.setByte(2, clase.getGrado());
            pstmt.setString(3, String.valueOf(clase.getSeccion()));
            pstmt.setInt(4, clase.getId_profesor());
            pstmt.setInt(5, clase.getId());
            
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
    
    public int SQL_DELETE(Clase clase){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, clase.getId());
            
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
