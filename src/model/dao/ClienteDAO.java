/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import model.entity.Cliente;

/**
 *
 * @author User
 */
public class ClienteDAO {
    private static ClienteDAO instance;
    private PreparedStatement insertCliente;
    
    public static ClienteDAO getInstance(){
       if (instance == null){
           instance = new ClienteDAO();
       }
       return instance;
    }
    
    private ClienteDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertCliente = con.prepareStatement("insert into clientes (nome, dtnasc, email, endereco, telefone) values (?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addCliente(Cliente cl){
        try {
            insertCliente.setString(1,cl.getNome());
            insertCliente.setDate(2,Date.valueOf(cl.getDtnasc()));
            insertCliente.setString(3,cl.getEmail());
            insertCliente.setString(4,cl.getEndereco());
            insertCliente.setString(5,cl.getTelefone());
            insertCliente.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
