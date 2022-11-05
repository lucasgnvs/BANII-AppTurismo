/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import model.entity.Hotel;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class HotelDAO {
    private static HotelDAO instance;
    private PreparedStatement insertHotel;
    private PreparedStatement selectAllHotel;
    private PreparedStatement selectHotelCidade;
    
    public static HotelDAO getInstance(){
       if (instance == null){
           instance = new HotelDAO();
       }
       return instance;
    }
    
    private HotelDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertHotel = con.prepareStatement("select add_hotel(?, ?, ?, ?, ?)");
            selectAllHotel = con.prepareStatement("select codh, nome, endereco, categoria, codr, codcd from hoteis order by nome");
            selectHotelCidade = con.prepareStatement("select codh, nome, endereco, categoria, codr from hoteis where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addHotel(Hotel ht) throws SQLException {
        insertHotel.setString(1,ht.getNome());
        insertHotel.setString(2,ht.getEndereco());
        insertHotel.setInt(3,ht.getCategoria());
        if (ht.getRestaurante() != null){
            insertHotel.setInt(4,ht.getRestaurante().getCod());
        }else{
            insertHotel.setNull(4, Types.NULL);
        }
        insertHotel.setInt(5,ht.getCidade().getCod());
        ResultSet rs = insertHotel.executeQuery();
        return rs.next() ? rs.getInt("add_hotel") : -1;
    }
    
    public ArrayList<Hotel> loadAllHotel(){
        ArrayList<Hotel> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllHotel.executeQuery();
            while(rs.next()){
                list.add(new Hotel(rs.getInt("codh"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getInt("categoria")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Hotel> loadHotelCidade(Cidade cd){
        ArrayList<Hotel> list = new ArrayList<>();
        ResultSet rs;
        try{
           selectHotelCidade.setInt(1, cd.getCod());
            rs = selectHotelCidade.executeQuery();
            while(rs.next()){
                list.add(new Hotel(rs.getInt("codh"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getInt("categoria")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
