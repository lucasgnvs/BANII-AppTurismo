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
import java.util.Arrays;
import model.entity.Restaurante;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class RestauranteDAO {
    private static RestauranteDAO instance;
    private PreparedStatement insertRestaurante;
    private PreparedStatement updateRestaurante;
    private PreparedStatement deleteRestaurante;
    private PreparedStatement selectAllRestaurante;
    private PreparedStatement selectRestauranteCidade;

    public static RestauranteDAO getInstance(){
       if (instance == null){
           instance = new RestauranteDAO();
       }
       return instance;
    }
    
    private RestauranteDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertRestaurante = con.prepareStatement("select add_restaurante(?, ?, ?, ?)");
            updateRestaurante = con.prepareStatement("update restaurantes set nome = ?, endereco = ?, categoria = ?, codcd = ? where codr = ?");
            deleteRestaurante = con.prepareStatement("delete from restaurantes where codr = ?");
            selectAllRestaurante = con.prepareStatement("select codr, nome, endereco, categoria, codcd from restaurantes order by nome");
            selectRestauranteCidade = con.prepareStatement("select codr, nome, endereco, categoria from restaurantes where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addRestaurante(Restaurante rt) throws SQLException {
        insertRestaurante.setString(1,rt.getNome());
        insertRestaurante.setString(2,rt.getEndereco());
        insertRestaurante.setInt(3,rt.getCategoria());
        insertRestaurante.setInt(4,rt.getCidade().getCod());
        ResultSet rs = insertRestaurante.executeQuery();
        return rs.next() ? rs.getInt("add_restaurante") : -1;
    }
    
    public void updateRestaurante(Restaurante rt) throws SQLException {
        updateRestaurante.setString(1,rt.getNome());
        updateRestaurante.setString(2,rt.getEndereco());
        updateRestaurante.setInt(3,rt.getCategoria());
        updateRestaurante.setInt(4,rt.getCidade().getCod());
        updateRestaurante.setInt(5,rt.getCod());
        updateRestaurante.executeUpdate();
    }
    
    public void deleteRestaurante(Restaurante rt){
        try{
            deleteRestaurante.setInt(1,rt.getCod());
            deleteRestaurante.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Restaurante> loadAllRestaurante(){
        ArrayList<Restaurante> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllRestaurante.executeQuery();
            ArrayList<String> categorias = new ArrayList<>(Arrays.asList("0","SIMPLES", "LUXO"));
            while(rs.next()){
                list.add(new Restaurante(rs.getInt("codr"),
                rs.getString("nome"),
                rs.getString("endereco"),
                new Cidade(rs.getInt("codcd"),"","",0),
                categorias.indexOf(rs.getString("categoria"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Restaurante> loadRestauranteCidade(Cidade cd){
        ArrayList<Restaurante> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectRestauranteCidade.setInt(1, cd.getCod());
            rs = selectRestauranteCidade.executeQuery();
            ArrayList<String> categorias = new ArrayList<>(Arrays.asList("SIMPLES", "LUXO"));
            while(rs.next()){
                list.add(new Restaurante(rs.getInt("codr"),
                rs.getString("nome"),
                rs.getString("endereco"),
                cd,
                categorias.indexOf(rs.getString("categoria"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
