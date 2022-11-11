/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class CidadeDAO {
    private static CidadeDAO instance;
    private PreparedStatement insertCidade;
    private PreparedStatement updateCidade;
    private PreparedStatement deleteCidade;
    private PreparedStatement selectAllCidade;
    
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
            updateCidade = con.prepareStatement("update cidades set nome = ?, estado = ?, populacao = ? where codcd = ?");
            deleteCidade = con.prepareStatement("delete from cidades where codcd = ?");
            selectAllCidade = con.prepareStatement("select codcd, nome, estado, populacao from cidades order by estado, nome");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addCidade(Cidade cd) throws SQLException {
        insertCidade.setString(1,cd.getNome());
        insertCidade.setString(2,cd.getEstado());
        insertCidade.setInt(3,cd.getPopulacao());
        insertCidade.executeUpdate();
    }
    
    public void updateCidade(Cidade cd) throws SQLException {
        updateCidade.setString(1,cd.getNome());
        updateCidade.setString(2,cd.getEstado());
        updateCidade.setInt(3,cd.getPopulacao());
        updateCidade.setInt(4,cd.getCod());
        updateCidade.executeUpdate();
    }
    
    public void deleteCidade(Cidade cd){
        try{
            deleteCidade.setInt(1,cd.getCod());
            deleteCidade.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Cidade> loadAllCidade(){
        ArrayList<Cidade> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllCidade.executeQuery();
            while(rs.next()){
                list.add(new Cidade(rs.getInt("codcd"),
                rs.getString("nome"),
                rs.getString("estado"),
                rs.getInt("populacao")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
