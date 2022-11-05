/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import model.entity.Cliente;

/**
 *
 * @author User
 */
public class ClienteDAO {
    private static ClienteDAO instance;
    private PreparedStatement insertCliente;
    private PreparedStatement selectAllCliente;
    
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
            selectAllCliente = con.prepareStatement("select codc, nome, dtnasc, email, endereco, telefone from clientes order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addCliente(Cliente cl)throws SQLException {
        insertCliente.setString(1,cl.getNome());
        insertCliente.setDate(2,Date.valueOf(cl.getDtnasc()));
        insertCliente.setString(3,cl.getEmail());
        insertCliente.setString(4,cl.getEndereco());
        insertCliente.setString(5,cl.getTelefone());
        insertCliente.executeUpdate();
    }
    
    public ArrayList<Cliente> loadAllCliente(){
        ArrayList<Cliente> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllCliente.executeQuery();
            while(rs.next()){
                //codc, nome, dtnasc, email, endereco, telefone
                //int codc, String nome, String endereco, LocalDate dtnasc, String email, String telefone
                list.add(new Cliente(rs.getInt("codc"),
                rs.getString("nome"),
                rs.getString("endereco"),
                LocalDate.parse(rs.getDate("dtnasc").toString()),
                rs.getString("email"),
                rs.getString("telefone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
