package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.Profesor;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class SQLProfesor {
    
    private static final String SELECT = "SELECT * FROM Profesores";
    private static final String INSERT = "INSERT INTO Profesores(nombre,apellido,sueldo) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE Profesores SET nombre=?,apellido=?,sueldo=? WHERE id_Profesor=?";
    private static final String DELETE = "DELETE FROM Profesores WHERE id_Profesor=?";

    public List<Profesor> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Profesor> profesores = new ArrayList<>();
        Profesor profesor = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Integer id = rs.getInt("id_Profesor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");
                BigDecimal sueldo = rs.getBigDecimal("sueldo");

                profesor = new Profesor(id, nombre, apellido, sueldo);
                profesores.add(profesor);
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
        
        return profesores;
    }
    
    public int SQL_INSERT(Profesor profesor){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellidos());
            pstmt.setBigDecimal(3, profesor.getSueldo());
         
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
    
    public int SQL_UPDATE(Profesor profesor){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, profesor.getNombre());
            pstmt.setString(2, profesor.getApellidos());
            pstmt.setBigDecimal(3, profesor.getSueldo());
            pstmt.setInt(4, profesor.getId());
            
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
    
    public int SQL_DELETE(Profesor profesor){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, profesor.getId());
            
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
