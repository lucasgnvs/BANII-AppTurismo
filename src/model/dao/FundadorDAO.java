/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Types;
import model.entity.Fundador;
import model.entity.Museu;

/**
 *
 * @author User
 */
public class FundadorDAO {
    private static FundadorDAO instance;
    private PreparedStatement insertFundador;
    private PreparedStatement insertFundacao;
    
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
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addFundador(Fundador fd){
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addFundacao(Fundador fd, Museu ms){
        try {
            insertFundacao.setInt(1,fd.getCod());
            insertFundacao.setInt(2,ms.getCod());
            insertFundacao.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}
