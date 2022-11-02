/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entity.Parque;

/**
 *
 * @author User
 */
public class ParqueDAO {
    private static ParqueDAO instance;
    private PreparedStatement insertParque;
    
    public static ParqueDAO getInstance(){
       if (instance == null){
           instance = new ParqueDAO();
       }
       return instance;
    }
    
    private ParqueDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertParque = con.prepareStatement("select add_parque(?, ?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addParque(Parque pq){
        try {
            insertParque.setString(1,pq.getNome());
            insertParque.setString(2,pq.getDescricao());
            insertParque.setString(3,pq.getEndereco());
            insertParque.setInt(4,pq.getCidade().getCod());
            insertParque.setInt(5, pq.getNratracoes());
            insertParque.setInt(6, pq.getCapacidade());
            insertParque.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
