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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.entity.Pacote;
import model.entity.Hotel;
import model.entity.CasaShow;
import model.entity.Igreja;
import model.entity.Museu;
import model.entity.Parque;
import model.entity.Restaurante;
import model.entity.PontoTuristico;
import model.entity.AtracaoInclusa;
import model.entity.Cidade;

/**
 *
 * @author User
 */
public class PacoteDAO {
    private static PacoteDAO instance;
    private PreparedStatement insertPacote;
    private PreparedStatement insertPacoteFunc;
    private PreparedStatement insertHT;
    private PreparedStatement insertRT;
    private PreparedStatement insertPT;
    private PreparedStatement selectHT;
    private PreparedStatement selectRT;
    private PreparedStatement selectPTCS;
    private PreparedStatement selectPTIG;
    private PreparedStatement selectPTMS;
    private PreparedStatement selectPTPQ;
    private PreparedStatement selectAllPacote;
    
    public static PacoteDAO getInstance(){
       if (instance == null){
           instance = new PacoteDAO();
       }
       return instance;
    }
    
    private PacoteDAO(){
        Connection con = Conexao.getConnection();
        try{
            insertPacote = con.prepareStatement("insert into pacotes (nome, valor, dtinicio, dtfim, disp, codcd) values (?, ?, ?, ?, ?, ?) returning codp");
            insertPacoteFunc = con.prepareStatement("select add_pacote(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insertHT = con.prepareStatement("insert into htsinclusos values (?, ?, ?)");
            insertRT = con.prepareStatement("insert into rtsinclusos values (?, ?, ?)");
            insertPT = con.prepareStatement("insert into ptsinclusos values (?, ?, ?)");
            selectHT = con.prepareStatement("select codh, nome, endereco, dia from htsinclusos join hoteis using (codh) where codp = ?");
            selectRT = con.prepareStatement("select codr, nome, endereco, dia from rtsinclusos join restaurantes using (codr) where codp = ?");
            selectPTCS = con.prepareStatement("select codpt, nome, endereco, dia from ptsinclusos join pturisticos using (codpt) join casashow using(codpt) where codp = ?");
            selectPTIG = con.prepareStatement("select codpt, nome, endereco, dia from ptsinclusos join pturisticos using (codpt) join igrejas using(codpt) where codp = ?");
            selectPTMS = con.prepareStatement("select codpt, nome, endereco, dia from ptsinclusos join pturisticos using (codpt) join museus using(codpt)where codp = ?");
            selectPTPQ = con.prepareStatement("select codpt, nome, endereco, dia from ptsinclusos join pturisticos using (codpt) join parques using(codpt)where codp = ?");
            selectAllPacote = con.prepareStatement("select codp, nome, valor, dtinicio, dtfim, disp, codcd from pacotes order by dtinicio desc");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public int addPacote(Pacote pc) throws SQLException {
        insertPacote.setString(1,pc.getNome());
        insertPacote.setFloat(2,pc.getValor());
        insertPacote.setDate(3,Date.valueOf(pc.getDtinicio()));
        insertPacote.setDate(4,Date.valueOf(pc.getDtfim()));
        insertPacote.setInt(5,pc.getDisp());
        insertPacote.setInt(6,pc.getCidade().getCod());
        ResultSet rs = insertPacote.executeQuery();
        return rs.next() ? rs.getInt("codp") : -1;
    }
    
    public int addPacoteInclusos(Pacote pc, ArrayList<ArrayList<LocalDate>> datas) throws SQLException {
        Connection con = Conexao.getConnection();
        insertPacoteFunc.setString(1,pc.getNome());
        insertPacoteFunc.setFloat(2,pc.getValor());
        insertPacoteFunc.setDate(3,Date.valueOf(pc.getDtinicio()));
        insertPacoteFunc.setDate(4,Date.valueOf(pc.getDtfim()));
        insertPacoteFunc.setInt(5,pc.getDisp());
        insertPacoteFunc.setInt(6,pc.getCidade().getCod());
        List<Integer> codhs = pc.getHoteis().stream().map(ht -> ht.getCod()).toList();
        List<Integer> codrs = pc.getRestaurantes().stream().map(rt -> rt.getCod()).toList();
        List<Integer> codpts = pc.getPontosTuristicos().stream().map(pt -> pt.getCod()).toList();
        insertPacoteFunc.setArray(7, con.createArrayOf("integer", codhs.toArray()));
        insertPacoteFunc.setArray(8, con.createArrayOf("integer",codrs.toArray()));
        insertPacoteFunc.setArray(9, con.createArrayOf("integer",codpts.toArray()));
        insertPacoteFunc.setArray(10, con.createArrayOf("date",datas.get(0).toArray()));
        insertPacoteFunc.setArray(11, con.createArrayOf("date",datas.get(1).toArray()));
        insertPacoteFunc.setArray(12, con.createArrayOf("date",datas.get(2).toArray()));
        ResultSet rs = insertPacoteFunc.executeQuery();
        return rs.next() ? rs.getInt("add_pacote") : -1;
    }
    
    public void addHotelPacote(Hotel ht, Pacote pc, LocalDate dt) throws SQLException {
        insertHT.setInt(1,pc.getCod());
        insertHT.setInt(2,ht.getCod());
        insertHT.setDate(3,Date.valueOf(dt));
        insertHT.executeUpdate();
    }
    
    public void addRestaurantePacote(Restaurante rt, Pacote pc, LocalDate dt) throws SQLException {
        insertRT.setInt(1,pc.getCod());
        insertRT.setInt(2,rt.getCod());
        insertRT.setDate(3,Date.valueOf(dt));
        insertRT.executeUpdate();
    }
    
    public void addPontoTuristicoPacote(PontoTuristico pt, Pacote pc, LocalDate dt) throws SQLException {
        insertPT.setInt(1,pc.getCod());
        insertPT.setInt(2,pt.getCod());
        insertPT.setDate(3,Date.valueOf(dt));
        insertPT.executeUpdate();
    }
        
    public ArrayList<Pacote> loadAllPacote(){
        ArrayList<Pacote> list = new ArrayList<>();
        ResultSet rs;
        try{
            rs = selectAllPacote.executeQuery();
            while(rs.next()){
                list.add(new Pacote(rs.getInt("codp"),
                rs.getString("nome"),
                rs.getFloat("valor"),
                LocalDate.parse(rs.getDate("dtinicio").toString()),
                LocalDate.parse(rs.getDate("dtfim").toString()),
                rs.getInt("disp"),
                new Cidade(rs.getInt("codcd"),"","",0)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<AtracaoInclusa> loadAllAtracoes(Pacote pc){
        ArrayList<AtracaoInclusa> list = new ArrayList<>();
        ResultSet rsh, rsr, rsptcs, rsptig, rsptms, rsptpq;
        try{
            selectHT.setInt(1,pc.getCod());
            selectRT.setInt(1,pc.getCod());
            selectPTCS.setInt(1,pc.getCod());
            selectPTIG.setInt(1,pc.getCod());
            selectPTMS.setInt(1,pc.getCod());
            selectPTPQ.setInt(1,pc.getCod());
            rsh = selectHT.executeQuery();
            rsr = selectRT.executeQuery();
            rsptcs = selectPTCS.executeQuery();
            rsptig = selectPTIG.executeQuery();
            rsptms = selectPTMS.executeQuery();
            rsptpq = selectPTPQ.executeQuery();
            while(rsh.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsh.getDate("dia").toString()),
                        new Hotel(rsh.getInt("codh"),
                                rsh.getString("nome"),
                                rsh.getString("endereco"),
                                null,
                                0)));
            }
            while(rsr.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsr.getDate("dia").toString()),
                        new Restaurante(rsr.getInt("codr"),
                                rsr.getString("nome"),
                                rsr.getString("endereco"),
                                null,
                                0)));
            }
            while(rsptcs.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsptcs.getDate("dia").toString()),
                        new CasaShow(rsptcs.getInt("codpt"),
                                rsptcs.getString("nome"),
                                rsptcs.getString("endereco"),
                                null,
                                "",
                                null,
                                0)));
            }
            while(rsptig.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsptig.getDate("dia").toString()),
                        new Igreja(rsptig.getInt("codpt"),
                                rsptig.getString("nome"),
                                rsptig.getString("endereco"),
                                null,
                                "",
                                null,
                                "")));
            }
            while(rsptms.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsptms.getDate("dia").toString()),
                        new Museu(rsptms.getInt("codpt"),
                                rsptms.getString("nome"),
                                rsptms.getString("endereco"),
                                null,
                                "",
                                null,
                                0)));
            }
            while(rsptpq.next()){
                list.add(new AtracaoInclusa(LocalDate.parse(rsptpq.getDate("dia").toString()),
                        new Parque(rsptpq.getInt("codpt"),
                                rsptpq.getString("nome"),
                                rsptpq.getString("endereco"),
                                null,
                                "",
                                0,
                                0)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.sort((a1, a2) -> a1.getData().isBefore(a2.getData()) ? 1 : -1);
        return list;
    }
    
}
