package com.grupo06.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Connector {

    public Connection getConnection(String databaseName) {
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName,
                    "root", "1234");

            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement pstmt) throws SQLException {
        pstmt.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

}
