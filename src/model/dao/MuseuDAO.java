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
    private PreparedStatement updatePTuristico;
    private PreparedStatement updateMuseu;
    private PreparedStatement deleteMuseu;
    private PreparedStatement selectAllMuseu;
    private PreparedStatement selectMuseuCidade;
    private PreparedStatement selectCountMuseu;
    
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
            updatePTuristico = con.prepareStatement("update pturisticos set nome = ?, descricao = ?, endereco = ?, codcd = ? where codpt = ?");
            updateMuseu = con.prepareStatement("update museus set dtfundacao = ?, nrsalas = ? where codpt = ?");
            deleteMuseu = con.prepareStatement("delete from pturisticos where codpt = ?");
            selectAllMuseu = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, dtfundacao, nrsalas from pturisticos join museus using(codpt) order by nome");
            selectMuseuCidade = con.prepareStatement("select codpt, nome, descricao, endereco, dtfundacao, nrsalas from pturisticos join museus using(codpt) where codcd = ? order by nome");
            selectCountMuseu = con.prepareStatement("select count(codpt) from museus");
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
    
    public void updateMuseu(Museu ms) throws SQLException {
        updatePTuristico.setString(1,ms.getNome());
        updatePTuristico.setString(2,ms.getDescricao());
        updatePTuristico.setString(3,ms.getEndereco());
        updatePTuristico.setInt(4,ms.getCidade().getCod());
        updatePTuristico.setInt(5,ms.getCod());
        updateMuseu.setDate(1, Date.valueOf(ms.getDtfundacao()));
        updateMuseu.setInt(2, ms.getNrsalas());
        updateMuseu.setInt(3, ms.getCod());
        updatePTuristico.executeUpdate();
        updateMuseu.executeUpdate();
    }
    
    public void deleteMuseu(Museu ms){
        try{
            deleteMuseu.setInt(1,ms.getCod());
            deleteMuseu.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
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
                new Cidade(rs.getInt("codcd"),"","",0),
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
                cd,
                rs.getString("descricao"),
                LocalDate.parse(rs.getDate("dtfundacao").toString()),
                rs.getInt("nrsalas")));
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
            rs = selectCountMuseu.executeQuery();
            if(rs.next()){
                res = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
