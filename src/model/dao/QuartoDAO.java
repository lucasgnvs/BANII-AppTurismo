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
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class QuartoDAO {
    private static QuartoDAO instance;
    private PreparedStatement insertQuarto;
    private PreparedStatement updateQuarto;
    private PreparedStatement deleteQuarto;
    private PreparedStatement selectQuartoHotel;
    
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
            updateQuarto = con.prepareStatement("update tipoquarto set nome = ?, valor = ?, nrquatos = ?, nrhospedes = ? where codq = ?");
            deleteQuarto = con.prepareStatement("delete from tipoquarto where codq = ?");
            selectQuartoHotel = con.prepareStatement("select codq, nome, valor, nrquatos, nrhospedes from tipoquarto where codh = ?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addQuarto(Hotel ht, Quarto qt) throws SQLException {
        insertQuarto.setInt(1,ht.getCod());
        insertQuarto.setInt(2,qt.getNome());
        insertQuarto.setFloat(3,qt.getValor());
        insertQuarto.setInt(4,qt.getNrquartos());
        insertQuarto.setInt(5,qt.getNrhospedes());
        ResultSet rs = insertQuarto.executeQuery();
        return rs.next() ? rs.getInt("add_quarto") : -1;
    }
    
    public void updateQuarto(Quarto qt) throws SQLException {
        ArrayList<String> nome = new ArrayList<>(Arrays.asList("0","SIMPLES", "LUXO", "SUPERLUXO"));
        updateQuarto.setString(1,nome.get(qt.getNome()));
        updateQuarto.setFloat(2,qt.getValor());
        updateQuarto.setInt(3,qt.getNrquartos());
        updateQuarto.setInt(4,qt.getNrhospedes());
        updateQuarto.setInt(5,qt.getCod());
        updateQuarto.executeUpdate();
    }
    
    public void deleteQuarto(Quarto qt){
        try{
            deleteQuarto.setInt(1,qt.getCod());
            deleteQuarto.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Quarto> loadAllQuarto(Hotel ht){
        ArrayList<Quarto> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectQuartoHotel.setInt(1, ht.getCod());
            rs = selectQuartoHotel.executeQuery();
            while(rs.next()){
                ArrayList<String> nome = new ArrayList<>(Arrays.asList("0","SIMPLES", "LUXO", "SUPERLUXO"));
                list.add(new Quarto(rs.getInt("codq"),
                nome.indexOf(rs.getString("nome")),
                rs.getFloat("valor"),
                rs.getInt("nrquatos"),
                rs.getInt("nrhospedes")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
