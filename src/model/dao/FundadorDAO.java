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
import model.entity.Pacote;

/**
 *
 * @author User
 */
public class FundadorDAO {
    private static FundadorDAO instance;
    private PreparedStatement insertFundador;
    private PreparedStatement insertFundacao;
    private PreparedStatement selectAllFundador;
    
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
            insertFundacao = con.prepareStatement("insert into fundacao values (?, ?)");
            selectAllFundador = con.prepareStatement("select codf, nome, dtnasc, dtmorte, nacionalidade, ativprof from fundadores order by nome, dtnasc");
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
                }catch(Exception e){}//java.lang.NullPointerException
                list.add(fd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
