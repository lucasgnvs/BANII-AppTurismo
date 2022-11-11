/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import model.entity.Fundador;
import model.entity.Museu;

/**
 *
 * @author User
 */
public class FundadorDAO {
    private static FundadorDAO instance;
    private PreparedStatement insertFundador;
    private PreparedStatement updateFundador;
    private PreparedStatement deleteFundador;
    private PreparedStatement insertFundacao;
    private PreparedStatement selectAllFundador;
    private PreparedStatement selectFundadorMuseu;
    
    public static FundadorDAO getInstance(){
       if (instance == null){
           instance = new FundadorDAO();
       }
       return instance;
    }
    
    private FundadorDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertFundador = con.prepareStatement("insert into fundadores (nome, dtnasc, dtmorte, nacionalidade, ativprof) values (?, ?, ?, ?, ?)");
            updateFundador = con.prepareStatement("update fundadores set nome = ?, dtnasc = ?, dtmorte = ?, nacionalidade = ?, ativprof = ? where codf = ?");
            deleteFundador = con.prepareStatement("delete from fundadores where codf = ?");
            insertFundacao = con.prepareStatement("insert into fundacao values (?, ?)");
            selectAllFundador = con.prepareStatement("select codf, nome, dtnasc, dtmorte, nacionalidade, ativprof from fundadores order by nome, dtnasc");
            selectFundadorMuseu = con.prepareStatement("select codf, nome, nacionalidade from fundacao join fundadores using(codf) where codpt = ?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addFundador(Fundador fd) throws SQLException {
        insertFundador.setString(1,fd.getNome());
        insertFundador.setDate(2,Date.valueOf(fd.getDtnasc()));
        if (fd.getDtmorte() != null){
            insertFundador.setDate(3,Date.valueOf(fd.getDtmorte()));
        }else{
            insertFundador.setNull(3,Types.NULL);
        }
        insertFundador.setString(4,fd.getNacionalidade());
        insertFundador.setString(5,fd.getAtivprof());
        insertFundador.executeUpdate();
            
    }
    
    public void updateFundador(Fundador fd) throws SQLException {
        updateFundador.setString(1,fd.getNome());
        updateFundador.setDate(2,Date.valueOf(fd.getDtnasc()));
        if (fd.getDtmorte() != null){
            updateFundador.setDate(3,Date.valueOf(fd.getDtmorte()));
        }else{
            updateFundador.setNull(3,Types.NULL);
        }
        updateFundador.setString(4,fd.getNacionalidade());
        updateFundador.setString(5,fd.getAtivprof());
        updateFundador.setInt(6, fd.getCod());
        updateFundador.executeUpdate();
    }
    
    public void deleteFundador(Fundador fd){
        try{
            deleteFundador.setInt(1,fd.getCod());
            deleteFundador.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void addFundacao(Fundador fd, Museu ms) throws SQLException {
        insertFundacao.setInt(1,fd.getCod());
        insertFundacao.setInt(2,ms.getCod());
        insertFundacao.executeUpdate();
    }
    
    public ArrayList<Fundador> loadAllFundador(){
        ArrayList<Fundador> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllFundador.executeQuery();
            while(rs.next()){
                Fundador fd = new Fundador(rs.getInt("codf"),
                rs.getString("nome"),
                LocalDate.parse(rs.getDate("dtnasc").toString()),
                rs.getString("nacionalidade"),
                rs.getString("ativprof"));
                try{
                    fd.setDtmorte(LocalDate.parse(rs.getDate("dtmorte").toString()));
                }catch(NullPointerException e){}
                list.add(fd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Fundador> loadAllFundador(Museu ms){
        ArrayList<Fundador> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectFundadorMuseu.setInt(1, ms.getCod());
            rs = selectFundadorMuseu.executeQuery();
            while(rs.next()){
                list.add( new Fundador(rs.getInt("codf"),
                rs.getString("nome"),
                null,
                rs.getString("nacionalidade"),
                ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
