/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.grupo06.View;

import com.grupo06.Config.Config;
import com.grupo06.Connector.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santi
 */
public class ProyectoImportante {

    public static void main(String[] args) {
        Connector con = new Connector();
        
        Connection cn = con.getConnection(Config.DATABASE_NAME);
        try {
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("");
            
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
