/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author THIS PC
 */
public class KetNoi {
    private static Connection con;
    
    public static Connection getcon(){
        try {
            if (con == null) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName = Edusys; username = nghia; password = lonely";
                con = DriverManager.getConnection(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static PreparedStatement prepare(String query) throws Exception{
        return getcon().prepareStatement(query);
    }
}
