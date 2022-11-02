/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.entity.Pacote;
import model.entity.Cliente;

/**
 *
 * @author User
 */
public class ContratoDAO {
    private static ContratoDAO instance;
    private PreparedStatement insertContrato;
    
    public static ContratoDAO getInstance(){
       if (instance == null){
           instance = new ContratoDAO();
       }
       return instance;
    }
    
    private ContratoDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertContrato = con.prepareStatement("insert into contratos values (?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addContrato(Pacote pc, Cliente cl){
        try {
            insertContrato.setInt(1,pc.getCod());
            insertContrato.setInt(2,cl.getCod());
            insertContrato.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
