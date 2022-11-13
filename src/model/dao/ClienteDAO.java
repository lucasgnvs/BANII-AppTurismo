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
import model.entity.Cliente;

/**
 *
 * @author User
 */
public class ClienteDAO {
    private static ClienteDAO instance;
    private PreparedStatement insertCliente;
    private PreparedStatement updateCliente;
    private PreparedStatement deleteCliente;
    private PreparedStatement selectAllCliente;
    private PreparedStatement selectCountCliente;
    
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
            updateCliente = con.prepareStatement("update clientes set nome = ?, dtnasc = ?, email = ?, endereco = ?, telefone = ? where codc = ?");
            deleteCliente = con.prepareStatement("delete from clientes where codc = ?");
            selectAllCliente = con.prepareStatement("select codc, nome, dtnasc, email, endereco, telefone from clientes order by nome");
            selectCountCliente = con.prepareStatement("select count(codc) from clientes");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addCliente(Cliente cl) throws SQLException {
        insertCliente.setString(1,cl.getNome());
        insertCliente.setDate(2,Date.valueOf(cl.getDtnasc()));
        insertCliente.setString(3,cl.getEmail());
        insertCliente.setString(4,cl.getEndereco());
        insertCliente.setString(5,cl.getTelefone());
        insertCliente.executeUpdate();
    }
    
    public void updateCliente(Cliente cl) throws SQLException {
        updateCliente.setString(1,cl.getNome());
        updateCliente.setDate(2,Date.valueOf(cl.getDtnasc()));
        updateCliente.setString(3,cl.getEmail());
        updateCliente.setString(4,cl.getEndereco());
        updateCliente.setString(5,cl.getTelefone());
        updateCliente.setInt(6,cl.getCod());
        updateCliente.executeUpdate();
    }
    
    public void deleteCliente(Cliente cl){
        try{
            deleteCliente.setInt(1,cl.getCod());
            deleteCliente.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cliente> loadAllCliente(){
        ArrayList<Cliente> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllCliente.executeQuery();
            while(rs.next()){
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

    public int loadTotal() {
        ResultSet rs;
        int res = 0;
        try{
            rs = selectCountCliente.executeQuery();
            if(rs.next()){
                res = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
