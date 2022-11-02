/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import model.entity.Pacote;
import model.entity.Hotel;
import model.entity.Restaurante;
import model.entity.PontoTuristico;

/**
 *
 * @author User
 */
public class PacoteDAO {
    private static PacoteDAO instance;
    private PreparedStatement insertPacote;
    private PreparedStatement insertHT;
    private PreparedStatement insertRT;
    private PreparedStatement insertPT;
    
    public static PacoteDAO getInstance(){
       if (instance == null){
           instance = new PacoteDAO();
       }
       return instance;
    }
    
    private PacoteDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertPacote = con.prepareStatement("insert into pacotes (nome, valor, dtinicio, dtfim, disp, codcd) values (?, ?, ?, ?, ?, ?)");
            insertHT = con.prepareStatement("insert into htsinclusos values (?, ?, ?)");
            insertRT = con.prepareStatement("insert into rtsinclusos values (?, ?, ?)");
            insertPT = con.prepareStatement("insert into ptsinclusos values (?, ?, ?)");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean addPacote(Pacote pc){
        try {
            insertPacote.setString(1,pc.getNome());
            insertPacote.setFloat(2,pc.getValor());
            insertPacote.setDate(3,Date.valueOf(pc.getDtinicio()));
            insertPacote.setDate(4,Date.valueOf(pc.getDtfim()));
            insertPacote.setInt(5,pc.getDisp());
            insertPacote.setInt(6,pc.getCidade().getCod());
            insertPacote.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addHotelPacote(Hotel ht, Pacote pc, LocalDate dt){
        try {
            insertHT.setInt(1,pc.getCod());
            insertHT.setInt(2,ht.getCod());
            insertHT.setDate(3,Date.valueOf(dt));
            insertHT.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addRestaurantePacote(Restaurante rt, Pacote pc, LocalDate dt){
        try {
            insertRT.setInt(1,pc.getCod());
            insertRT.setInt(2,rt.getCod());
            insertRT.setDate(3,Date.valueOf(dt));
            insertRT.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean addPontoTuristicoPacote(PontoTuristico pt, Pacote pc, LocalDate dt){
        try {
            insertPT.setInt(1,pc.getCod());
            insertPT.setInt(2,pt.getCod());
            insertPT.setDate(3,Date.valueOf(dt));
            insertPT.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
        
}
