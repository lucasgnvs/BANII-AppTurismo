/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.entity.CasaShow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Time;

/**
 *
 * @author User
 */
public class CasaShowDAO {
    private static CasaShowDAO instance;
    private PreparedStatement insertCasaShow;
    
    public static CasaShowDAO getInstance(){
       if (instance == null){
           instance = new CasaShowDAO();
       }
       return instance;
    }
    
    private CasaShowDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertCasaShow = con.prepareStatement("select add_casashow(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addCasaShow(CasaShow cs){
        try {
            insertCasaShow.setString(1,cs.getNome());
            insertCasaShow.setString(2,cs.getDescricao());
            insertCasaShow.setString(3,cs.getEndereco());
            insertCasaShow.setInt(4,cs.getCidade().getCod());
            insertCasaShow.setTime(5, Time.valueOf(cs.getHrinicio()));
            insertCasaShow.setInt(6,cs.getDiafech());
            if (cs.getRestaurante() != null){
                insertCasaShow.setInt(7,cs.getRestaurante().getCod());
            }else{
                insertCasaShow.setNull(7, Types.NULL);
            }
            if (cs.getPrecomedio() != 0){
                insertCasaShow.setFloat(8,cs.getPrecomedio());
            }else{
                insertCasaShow.setNull(8,Types.NULL);
            }
            insertCasaShow.setInt(9,cs.getEspecialidade());
            insertCasaShow.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
