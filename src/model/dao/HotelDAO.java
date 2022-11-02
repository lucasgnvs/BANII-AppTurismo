/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import model.entity.Hotel;

/**
 *
 * @author User
 */
public class HotelDAO {
    private static HotelDAO instance;
    private PreparedStatement insertHotel;
    
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
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addHotel(Hotel ht){
        try {
            insertHotel.setString(1,ht.getNome());
            insertHotel.setString(2,ht.getEndereco());
            insertHotel.setInt(3,ht.getCategoria());
            if (ht.getRestaurante() != null){
                insertHotel.setInt(4,ht.getRestaurante().getCod());
            }else{
                insertHotel.setNull(4, Types.NULL);
            }
            insertHotel.setInt(5,ht.getCidade().getCod());
            insertHotel.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
