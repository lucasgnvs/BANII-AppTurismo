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
import model.entity.Restaurante;

/**
 *
 * @author User
 */
public class CasaShowDAO {
    private static CasaShowDAO instance;
    private PreparedStatement insertCasaShow;
    private PreparedStatement updatePTuristico;
    private PreparedStatement updateCasaShow;
    private PreparedStatement deleteCasaShow;
    private PreparedStatement selectAllCasaShow;
    private PreparedStatement selectCasaShowCidade;
    private PreparedStatement selectCountCasaShow;
    
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
            updatePTuristico = con.prepareStatement("update pturisticos set nome = ?, descricao = ?, endereco = ?, codcd = ? where codpt = ?");
            updateCasaShow = con.prepareStatement("update casashow set hrinicio = ?, diafech = ?, codr = ?, precomedio = ?, especialidade = ? where codpt = ?");
            deleteCasaShow = con.prepareStatement("delete from pturisticos where codpt = ?");
            selectAllCasaShow = con.prepareStatement("select codpt, nome, descricao, endereco, codcd, hrinicio, diafech, codr, precomedio, especialidade from pturisticos join casashow using(codpt) order by nome");
            selectCasaShowCidade = con.prepareStatement("select codpt, nome, descricao, endereco, hrinicio, diafech, codr, precomedio, especialidade from pturisticos join casashow using(codpt) where codcd = ? order by nome");
            selectCountCasaShow = con.prepareStatement("select count(codpt) from casashow");
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
    
    public void updateCasaShow(CasaShow cs) throws SQLException {
        updatePTuristico.setString(1, cs.getNome());
        updatePTuristico.setString(2,cs.getDescricao());
        updatePTuristico.setString(3,cs.getEndereco());
        updatePTuristico.setInt(4,cs.getCidade().getCod());
        updatePTuristico.setInt(5,cs.getCod());
        updateCasaShow.setTime(1, Time.valueOf(cs.getHrinicio()));
        ArrayList<String> dias = new ArrayList<>(Arrays.asList("0","DOM","SEG", "TER", "QUA", "QUI", "SEX", "SAB"));
        updateCasaShow.setString(2,dias.get(cs.getDiafech()));
        if (cs.getRestaurante() != null){
            updateCasaShow.setInt(3,cs.getRestaurante().getCod());
        }else{
            updateCasaShow.setNull(3, Types.NULL);
        }
        if (cs.getPrecomedio() != 0){
            updateCasaShow.setFloat(4,cs.getPrecomedio());
        }else{
            updateCasaShow.setNull(4,Types.NULL);
        }
        if (cs.getEspecialidade() != -1){
            ArrayList<String> esp = new ArrayList<>(Arrays.asList("0","OUTRO", "BRA","ITA","JAP","MEX"));
            updateCasaShow.setString(5,esp.get(cs.getEspecialidade()));
        }else{
            updateCasaShow.setNull(5,Types.NULL);
        }
        updateCasaShow.setInt(6,cs.getCod());
        updatePTuristico.executeUpdate();
        updateCasaShow.executeUpdate();
    }
    
    public void deleteCasaShow(CasaShow cs){
        try{
            deleteCasaShow.setInt(1,cs.getCod());
            deleteCasaShow.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(){
        ArrayList<CasaShow> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllCasaShow.executeQuery();
            ArrayList<String> dias = new ArrayList<>(Arrays.asList("0","DOM","SEG", "TER", "QUA", "QUI", "SEX", "SAB"));
            ArrayList<String> esp = new ArrayList<>(Arrays.asList("0","OUTRO", "BRA","ITA","JAP","MEX"));
            while(rs.next()){
                CasaShow cs = new CasaShow(rs.getInt("codpt"),
                rs.getString("nome"),
                rs.getString("endereco"),
                new Cidade(rs.getInt("codcd"),"","",0),
                rs.getString("descricao"),
                LocalTime.parse(rs.getTime("hrinicio").toString()),
                dias.indexOf(rs.getString("diafech")));
                if(rs.getInt("codr") != 0){
                    cs.setRestaurante(new Restaurante(rs.getInt("codr"),"","",null,0));
                    cs.setPrecomedio(rs.getFloat("precomedio"));
                    cs.setEspecialidade(esp.indexOf(rs.getString("especialidade")));
                }
                list.add(cs);
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
                cd,
                rs.getString("descricao"),
                LocalTime.parse(rs.getTime("hrinicio").toString()),
                dias.indexOf(rs.getString("diafech"))));
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
            rs = selectCountCasaShow.executeQuery();
            if(rs.next()){
                res = rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
