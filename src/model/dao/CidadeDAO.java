/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class CidadeDAO {
    private static CidadeDAO instance;
    private PreparedStatement insertCidade;
    
    public static CidadeDAO getInstance(){
       if (instance == null){
           instance = new CidadeDAO();
       }
       return instance;
    }
    
    private CidadeDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertCidade = con.prepareStatement("insert into cidades (nome, estado, populacao) values (?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addCidade(Cidade cd){
        try {
            insertCidade.setString(1,cd.getNome());
            insertCidade.setString(2,cd.getEstado());
            insertCidade.setInt(3,cd.getPopulacao());
            insertCidade.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
