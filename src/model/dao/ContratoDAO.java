/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import model.entity.Pacote;
import model.entity.Cliente;

/**
 *
 * @author User
 */
public class ContratoDAO {
    private static ContratoDAO instance;
    private PreparedStatement insertContrato;
    private PreparedStatement selectContratoPacote;
    
    public static ContratoDAO getInstance(){
       if (instance == null){
           instance = new ContratoDAO();
       }
       return instance;
    }
    
    private ContratoDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertContrato = con.prepareStatement("insert into contratos values (?, ?)");
            selectContratoPacote = con.prepareStatement("select codp, nome, dtinicio, dtfim from contratos join pacotes using (codp) where codc = ?");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addContrato(Pacote pc, Cliente cl) throws SQLException {
        insertContrato.setInt(1,pc.getCod());
        insertContrato.setInt(2,cl.getCod());
        insertContrato.executeUpdate();
    }
    
    public ArrayList<Pacote> loadAllPacote(Cliente cl) {
        ArrayList<Pacote> list = new ArrayList<>();
        ResultSet rs;
        try{
            selectContratoPacote.setInt(1, cl.getCod());
            rs = selectContratoPacote.executeQuery();
            while(rs.next()){
                list.add(new Pacote(rs.getInt("codp"),
                rs.getString("nome"),
                0,
                LocalDate.parse(rs.getDate("dtinicio").toString()),
                LocalDate.parse(rs.getDate("dtfim").toString()),
                0,
                null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
            
}
