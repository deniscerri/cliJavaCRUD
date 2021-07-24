/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliJavaCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class DatabaseConnection {
    static Connection conn = null;
    
    
    public static Connection getConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/plotesimnotebonus", "root", "root");
            return conn;
        }catch(SQLException e){
            return null;
        }
    }
}
