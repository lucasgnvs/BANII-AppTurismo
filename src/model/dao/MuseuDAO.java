/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import model.entity.Museu;

/**
 *
 * @author User
 */
public class MuseuDAO {
    private static MuseuDAO instance;
    private PreparedStatement insertMuseu;
    
    public static MuseuDAO getInstance(){
       if (instance == null){
           instance = new MuseuDAO();
       }
       return instance;
    }
    
    private MuseuDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertMuseu = con.prepareStatement("select add_museu(?, ?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addMuseu(Museu ms){
        try {
            insertMuseu.setString(1,ms.getNome());
            insertMuseu.setString(2,ms.getDescricao());
            insertMuseu.setString(3,ms.getEndereco());
            insertMuseu.setInt(4,ms.getCidade().getCod());
            insertMuseu.setDate(5, Date.valueOf(ms.getDtfundacao()));
            insertMuseu.setInt(6, ms.getNrsalas());
            insertMuseu.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
