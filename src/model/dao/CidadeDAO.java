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
