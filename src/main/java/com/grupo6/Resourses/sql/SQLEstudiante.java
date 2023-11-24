package com.grupo6.Resourses.sql;

import com.grupo06.Connector.*;
import com.grupo06.Resourses.Estudiante;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class SQLEstudiante {

    private static final String SELECT = "SELECT * FROM Cliente";

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
                Date fechaNacimiento = rs.getDate("fechaNacimiento");
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

}
