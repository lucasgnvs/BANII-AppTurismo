/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import model.entity.Museu;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class MuseuDAO {
    private static MuseuDAO instance;
    private PreparedStatement insertMuseu;
    private PreparedStatement selectAllMuseu;
    private PreparedStatement selectMuseuCidade;
    
    public static MuseuDAO getInstance(){
       if (instance == null){
           instance = new MuseuDAO();
       }
       return instance;
    }
    
    private MuseuDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertMuseu = con.prepareStatement("select add_museu(?, ?, ?, ?, ?, ?)");
            selectAllMuseu = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, dtfundacao, nrsalas from pturisticos join museus using(codpt) order by nome");
            selectMuseuCidade = con.prepareStatement("select codpt, nome, descricao, endereco, dtfundacao, nrsalas from pturisticos join museus using(codpt) where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addMuseu(Museu ms) throws SQLException {
        insertMuseu.setString(1,ms.getNome());
        insertMuseu.setString(2,ms.getDescricao());
        insertMuseu.setString(3,ms.getEndereco());
        insertMuseu.setInt(4,ms.getCidade().getCod());
        insertMuseu.setDate(5, Date.valueOf(ms.getDtfundacao()));
        insertMuseu.setInt(6, ms.getNrsalas());
        ResultSet rs = insertMuseu.executeQuery();
        return rs.next() ? rs.getInt("add_museu") : -1;
    }
    
    public ArrayList<Museu> loadAllMuseu(){
        ArrayList<Museu> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllMuseu.executeQuery();
            while(rs.next()){
                list.add(new Museu(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalDate.parse(rs.getDate("dtfundacao").toString()),
                rs.getInt("nrsalas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Museu> loadMuseuCidade(Cidade cd){
        ArrayList<Museu> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectMuseuCidade.setInt(1,cd.getCod());
            rs = selectMuseuCidade.executeQuery();
            while(rs.next()){
                list.add(new Museu(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalDate.parse(rs.getDate("dtfundacao").toString()),
                rs.getInt("nrsalas")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
