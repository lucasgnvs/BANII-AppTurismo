/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.entity.CasaShow;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Time;
import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Arrays;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class CasaShowDAO {
    private static CasaShowDAO instance;
    private PreparedStatement insertCasaShow;
    private PreparedStatement selectAllCasaShow;
    private PreparedStatement selectCasaShowCidade;
    
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
            selectAllCasaShow = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, hrinicio, diafech, codr, precomedio, especialidade from pturisticos join casashow using(codpt) order by nome");
            selectCasaShowCidade = con.prepareStatement("select codpt, nome, descricao, endereco, hrinicio, diafech, codr, precomedio, especialidade from pturisticos join casashow using(codpt) where codcd = ? order by nome");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addCasaShow(CasaShow cs) throws SQLException {
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
        ResultSet rs = insertCasaShow.executeQuery();
        return rs.next() ? rs.getInt("add_casashow") : -1;
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(){
        ArrayList<CasaShow> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllCasaShow.executeQuery();
            ArrayList<String> dias = new ArrayList<>(Arrays.asList("0","DOM","SEG", "TER", "QUA", "QUI", "SEX", "SAB"));
            while(rs.next()){
                list.add(new CasaShow(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalTime.parse(rs.getTime("hrinicio").toString()),
                dias.indexOf(rs.getString("diafech"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<CasaShow> loadCasaShowCidade(Cidade cd){
        ArrayList<CasaShow> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectCasaShowCidade.setInt(1, cd.getCod());
            rs = selectCasaShowCidade.executeQuery();
            ArrayList<String> dias = new ArrayList<>(Arrays.asList("0","DOM","SEG", "TER", "QUA", "QUI", "SEX", "SAB"));
            while(rs.next()){
                list.add(new CasaShow(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                null,
                rs.getString("descricao"),
                LocalTime.parse(rs.getTime("hrinicio").toString()),
                dias.indexOf(rs.getString("diafech"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
