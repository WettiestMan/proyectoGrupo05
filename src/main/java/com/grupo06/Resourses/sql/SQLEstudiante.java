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

    private static final String SELECT = "SELECT * FROM Estudiantes";
    private static final String INSERT = "INSERT INTO Estudiantes(fechaNac,DNI,Nombre,Apellidos,Grado,Correo,numero_telefonico) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Estudiantes SET fechaNac=?,DNI=?,Nombre=?,Apellidos=?,Grado=?,Correo=?,numero_telefonico=? WHERE id_Estudiante=?";
    private static final String DELETE = "DELETE FROM Estudiantes WHERE id_Estudiante=?";

    public List<Estudiante> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Estudiante> estudiantes = new ArrayList<>();
        Estudiante estudiante = null;
        try {
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Estudiante");
                Date fechaNacimiento = rs.getDate("fechaNac");
                String dni = rs.getString("DNI");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellidos");
                byte grado = rs.getByte("Grado");
                String correo = rs.getString("Correo");
                int numTelefono = rs.getInt("numero_telefonico");

                estudiante = new Estudiante(id, fechaNacimiento.toLocalDate(), dni, nombre, apellido, grado, correo, numTelefono);
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
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setDate(1, (Date) Date.from(estudiante.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, estudiante.getDNI());
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
            conn = Connector.getConnection("DB_Escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, (Date) Date.from(estudiante.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, estudiante.getDNI());
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
            conn = Connector.getConnection("DB_Escuela");
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
