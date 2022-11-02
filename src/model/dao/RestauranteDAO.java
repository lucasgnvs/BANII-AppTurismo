/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entity.Restaurante;

/**
 *
 * @author User
 */
public class RestauranteDAO {
    private static RestauranteDAO instance;
    private PreparedStatement insertRestaurante;
    
    public static RestauranteDAO getInstance(){
       if (instance == null){
           instance = new RestauranteDAO();
       }
       return instance;
    }
    
    private RestauranteDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertRestaurante = con.prepareStatement("select add_restaurante(?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addRestaurante(Restaurante rs){
        try {
            insertRestaurante.setString(1,rs.getNome());
            insertRestaurante.setString(2,rs.getEndereco());
            insertRestaurante.setInt(3,rs.getCategoria());
            insertRestaurante.setInt(4,rs.getCidade().getCod());
            insertRestaurante.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
