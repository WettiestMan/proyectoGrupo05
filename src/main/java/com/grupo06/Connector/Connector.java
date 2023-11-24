package com.grupo06.Connector;

import com.grupo06.Private.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Connector {
    
    public static DataSource getDataSource(String databaseName){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(Config.URL + databaseName);
        ds.setUsername(Config.USERNAME);
        ds.setPassword(Config.PASSWORD);
        ds.setInitialSize(5);
        return ds;
    }
    
    public static Connection getConnection(String databaseName) {
        try {
            return getDataSource(databaseName).getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(PreparedStatement pstmt) throws SQLException{
        pstmt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
}
