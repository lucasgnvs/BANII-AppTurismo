/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entity.Hotel;
import model.entity.Quarto;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class QuartoDAO {
    private static QuartoDAO instance;
    private PreparedStatement insertQuarto;
    
    public static QuartoDAO getInstance(){
       if (instance == null){
           instance = new QuartoDAO();
       }
       return instance;
    }
    
    private QuartoDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertQuarto = con.prepareStatement("select add_quarto(?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addQuarto(Hotel ht,Quarto qt) throws SQLException {
        insertQuarto.setInt(1,ht.getCod());
        insertQuarto.setInt(2,qt.getNome());
        insertQuarto.setFloat(3,qt.getValor());
        insertQuarto.setInt(4,qt.getNrquartos());
        insertQuarto.setInt(5,qt.getNrhospedes());
        ResultSet rs = insertQuarto.executeQuery();
        return rs.next() ? rs.getInt("add_parque") : -1;
    }
}
