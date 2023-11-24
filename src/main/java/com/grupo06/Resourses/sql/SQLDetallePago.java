package com.grupo06.Resourses.sql;

import com.grupo06.Connector.Connector;
import com.grupo06.Resourses.DetallePago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLDetallePago {

    private static final String SELECT = "SELECT * FROM Detalle_Pago";
    private static final String INSERT = "INSERT INTO Detalle_Pago(id_Pago,costo,descripcion,razon,id_Est_Clase) VALUES(?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Detalle_Pago SET id_Pago=?,costo=?,descripcion=?,razon=?,id_Est_Clas=? WHERE id_DetallePago=?";
    private static final String DELETE = "DELETE FROM Detalle_Pago WHERE id_DetallePago=?";

    public List<DetallePago> SQL_SELECT() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<DetallePago> detallepagos = new ArrayList<>();
        DetallePago detallepago = null;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id_detallePago = rs.getInt("id_DetallePago");
                int id_pago = rs.getInt("id_Pago");
                int costo = rs.getInt("costo");
                String descripcion = rs.getString("descripcion");
                String razon = rs.getString("razon");
                int id_est_clase = rs.getInt("id_Est_Clase");

                detallepago = new DetallePago(id_detallePago, costo, descripcion, razon, id_pago, id_est_clase);
                detallepagos.add(detallepago);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Connector.close(rs);
                Connector.close(pstmt);
                Connector.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return detallepagos;
    }

    public int SQL_INSERT(DetallePago detallePago) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, detallePago.getIdPag());
            pstmt.setInt(2, detallePago.getCosto());
            pstmt.setString(3, detallePago.getDescripcion());
            pstmt.setString(4, detallePago.getRazon());
            pstmt.setInt(5, detallePago.getIdEstClas());

            registros = pstmt.executeUpdate();
        } catch (SQLException ex) {
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

    public int SQL_UPDATE(DetallePago detallePago) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setInt(1, detallePago.getIdPag());
            pstmt.setInt(2, detallePago.getCosto());
            pstmt.setString(3, detallePago.getDescripcion());
            pstmt.setString(4, detallePago.getRazon());
            pstmt.setInt(5, detallePago.getIdEstClas());
            pstmt.setInt(6, detallePago.getId());

            registros = pstmt.executeUpdate();
        } catch (SQLException ex) {
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

    public int SQL_DELETE(DetallePago detallePago) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros = 0;
        try {
            conn = Connector.getConnection("db_escuela");
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, detallePago.getId());

            registros = pstmt.executeUpdate();
        } catch (SQLException ex) {
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
