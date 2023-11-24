
package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.usuario.Asistente;
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
 * @author Cristopher
 */
public class SQLAsistente {
    private static final String SELECT = "SELECT * FROM Asistentes";
    private static final String INSERT = "INSERT INTO Asistentes(fechaNac,DNI,nombre,apellidos,usuario,contrasena) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Asistentes SET fechaNac=?,DNI=?,nombre=?,apellidos=?,usuario=?,contrasena=? WHERE id_Asistente=?";
    private static final String DELETE = "DELETE FROM Asistentes WHERE id_Asistente=?";

    public List<Asistente> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Asistente> asistentes = new ArrayList<>();
        Asistente asistente = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Asistente");
                Date fechaNacimiento = rs.getDate("fechaNac");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("DNI");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");

                asistente = new Asistente(id,fechaNacimiento.toLocalDate(),dni, nombre, apellidos, usuario,contrasena);
                asistentes.add(asistente);
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
        
        return asistentes;
    }
    
    public int SQL_INSERT(Asistente asistente){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setDate(1, (Date) Date.from(asistente.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, asistente.getDNI());
            pstmt.setString(3, asistente.getNombre());
            pstmt.setString(4, asistente.getApellidos());
            pstmt.setString(5, asistente.getUsuario());
            pstmt.setString(6, asistente.getContrasena());
         
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
    
    public int SQL_UPDATE(Asistente asistente){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setDate(1, (Date) Date.from(asistente.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            pstmt.setString(2, asistente.getDNI());
            pstmt.setString(3, asistente.getNombre());
            pstmt.setString(4, asistente.getApellidos());
            pstmt.setString(5, asistente.getUsuario());
            pstmt.setString(6, asistente.getContrasena());
            pstmt.setInt(7, asistente.getId());
            
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
    
    public int SQL_DELETE(Asistente asistente){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, asistente.getId());
            
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
