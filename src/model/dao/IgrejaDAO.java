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
import model.entity.Igreja;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class IgrejaDAO {
    private static IgrejaDAO instance;
    private PreparedStatement insertIgreja;
    private PreparedStatement selectAllIgreja;
    private PreparedStatement selectIgrejaCidade;
    
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
            selectAllIgreja = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, data, estilo from pturisticos join igrejas using(codpt) order by nome");
            selectIgrejaCidade = con.prepareStatement("select codpt, nome, descricao, endereco, data, estilo from pturisticos join igrejas using(codpt) where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addIgreja(Igreja ig) throws SQLException {
        insertIgreja.setString(1,ig.getNome());
        insertIgreja.setString(2,ig.getDescricao());
        insertIgreja.setString(3,ig.getEndereco());
        insertIgreja.setInt(4,ig.getCidade().getCod());
        insertIgreja.setDate(5, Date.valueOf(ig.getData()));
        insertIgreja.setString(6, ig.getEstilo());
        ResultSet rs = insertIgreja.executeQuery();
        return rs.next() ? rs.getInt("add_igreja") : -1;
    }
    
    public ArrayList<Igreja> loadAllIgreja(){
        ArrayList<Igreja> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllIgreja.executeQuery();
            while(rs.next()){
                list.add(new Igreja(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalDate.parse(rs.getDate("data").toString()),
                rs.getString("estilo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Igreja> loadIgrejaCidade(Cidade cd){
        ArrayList<Igreja> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectIgrejaCidade.setInt(1,cd.getCod());
            rs = selectIgrejaCidade.executeQuery();
            while(rs.next()){
                list.add(new Igreja(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalDate.parse(rs.getDate("data").toString()),
                rs.getString("estilo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}    
