/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Cidade;
import model.entity.Parque;

/**
 *
 * @author User
 */
public class ParqueDAO {
    private static ParqueDAO instance;
    private PreparedStatement insertParque;
    private PreparedStatement selectAllParque;
    private PreparedStatement selectParqueCidade;
    
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
            selectAllParque = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, nratracoes, capacidade from pturisticos join parques using(codpt) order by nome");
            selectParqueCidade = con.prepareStatement("select codpt, nome, descricao, endereco, nratracoes, capacidade from pturisticos join parques using(codpt) where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addParque(Parque pq) throws SQLException {
        insertParque.setString(1,pq.getNome());
        insertParque.setString(2,pq.getDescricao());
        insertParque.setString(3,pq.getEndereco());
        insertParque.setInt(4,pq.getCidade().getCod());
        insertParque.setInt(5, pq.getNratracoes());
        insertParque.setInt(6, pq.getCapacidade());
        ResultSet rs = insertParque.executeQuery();
        return rs.next() ? rs.getInt("add_parque") : -1;
    }
    
    public ArrayList<Parque> loadAllParque(){
        ArrayList<Parque> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllParque.executeQuery();
            while(rs.next()){
                list.add(new Parque(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                rs.getInt("nratracoes"),
                rs.getInt("capacidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Parque> loadParqueCidade(Cidade cd){
        ArrayList<Parque> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectParqueCidade.setInt(1,cd.getCod());
            rs = selectParqueCidade.executeQuery();
            while(rs.next()){
                list.add(new Parque(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                rs.getInt("nratracoes"),
                rs.getInt("capacidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
