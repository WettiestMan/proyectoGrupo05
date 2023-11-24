package com.grupo06.Resourses.sql;

import com.grupo06.Connector.*;
import com.grupo06.Resourses.Estudiante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class SQLEstudiante {

    private static final String SELECT = "SELECT * FROM Cliente";
    private static final String INSERT = "INSERT INTO Estudiantes(fechaNac,DNI,nombre,apellido,grado,correo,numtelefono) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Estudiantes SET fechaNac=?,DNI=?,nombre=?,apellido=?,grado=?,correo=?,numtelefono=? WHERE id_Estudiante=?";
    private static final String DELETE = "DELETE FROM Estudiantes WHERE id_Estudiante=?";

    public List<Estudiante> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Date fechaNacimiento = rs.getDate("fechaNac");
                int dni = rs.getInt("DNI");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                byte grado = rs.getByte("grado");
                String correo = rs.getString("correo");
                int numTelefono = rs.getInt("numTelefono");

                estudiante = new Estudiante(fechaNacimiento.toLocalDate(), dni, nombre, apellido, grado, correo, numTelefono);
                estudiantes.add(estudiante);
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
        
        return estudiantes;
    }
    
    public int SQL_INSERT(Estudiante estudiante){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setDate(1, (Date) Date.from(estudiante.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(2, estudiante.getDNI());
            pstmt.setString(3, estudiante.getNombre());
            pstmt.setString(4, estudiante.getApellidos());
            pstmt.setByte(5, estudiante.getGrado());
            pstmt.setString(6, estudiante.getCorreo());
            pstmt.setInt(7, estudiante.getNumTelefono());
         
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
    
    public int SQL_UPDATE(Estudiante estudiante){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, (Date) Date.from(estudiante.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setInt(2, estudiante.getDNI());
            pstmt.setString(3, estudiante.getNombre());
            pstmt.setString(4, estudiante.getApellidos());
            pstmt.setByte(5, estudiante.getGrado());
            pstmt.setString(6, estudiante.getCorreo());
            pstmt.setInt(7, estudiante.getNumTelefono());
            pstmt.setInt(8, estudiante.getId());
            
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
    
    public int SQL_DELETE(Estudiante estudiante){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, estudiante.getId());
            
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
