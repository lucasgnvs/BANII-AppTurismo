/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import model.entity.Igreja;

/**
 *
 * @author User
 */
public class IgrejaDAO {
    private static IgrejaDAO instance;
    private PreparedStatement insertIgreja;
    
    public static IgrejaDAO getInstance(){
       if (instance == null){
           instance = new IgrejaDAO();
       }
       return instance;
    }
    
    private IgrejaDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertIgreja = con.prepareStatement("select add_igreja(?, ?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addIgreja(Igreja ig){
        try {
            insertIgreja.setString(1,ig.getNome());
            insertIgreja.setString(2,ig.getDescricao());
            insertIgreja.setString(3,ig.getEndereco());
            insertIgreja.setInt(4,ig.getCidade().getCod());
            insertIgreja.setDate(5, Date.valueOf(ig.getData()));
            insertIgreja.setString(6, ig.getEstilo());
            insertIgreja.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}    
