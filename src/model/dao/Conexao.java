/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Conexao {
    static private Connection con;
    
    static public Connection getConnection(){
        if (con == null){
            
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://localhost:5432/turismo";
            String username = "postgres";
            String password = "123";
            
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, password);
            }
            catch(SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return con;
    }
}
