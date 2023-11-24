package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLCurso {
    
    private static final String SELECT = "SELECT * FROM Cursos";
    private static final String INSERT = "INSERT INTO Cursos(id_Curso,titulo,id_Profesor,id_Clase) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE Cursos SET id_Curso=?,titulo=?,id_Profesor=?,id_Clase=? WHERE id_Curso=?";
    private static final String DELETE = "DELETE FROM Cursos WHERE id_Curso=?";

    public List<Curso> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Curso> cursos = new ArrayList<>();
        Curso curso = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id_Curso");
                String titulo = rs.getString("Titulo");
                int id_profesor = rs.getInt("id_Profesor");
                int id_clase = rs.getInt("id_Clase");

                curso = new Curso(id, titulo, id_profesor, id_clase);
                cursos.add(curso);
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
        
        return cursos;
    }
    
    public int SQL_INSERT(Curso curso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, curso.getTitulo());
            pstmt.setInt(2, curso.getIdProf());
            pstmt.setInt(3, curso.getIdClas());
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
    
    public int SQL_UPDATE(Curso curso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, curso.getTitulo());
            pstmt.setInt(2, curso.getIdProf());
            pstmt.setInt(3, curso.getIdClas());
            pstmt.setInt(4, curso.getId());
            
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
    
    public int SQL_DELETE(Curso curso){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros=0;
        try{
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, curso.getId());
            
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
