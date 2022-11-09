/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import model.dao.CidadeDAO;
import model.dao.PacoteDAO;
import model.entity.AtracaoInclusa;
import model.entity.AtracaoTuristica;
import model.entity.Cidade;
import model.entity.Pacote;
import model.entity.Hotel;
import model.entity.Restaurante;
import model.entity.PontoTuristico;
import model.entity.CasaShow;
import model.entity.Igreja;
import model.entity.Museu;
import model.entity.Parque;
import view.AddPacote;

/**
 *
 * @author User
 */
public class PacoteController {
    
    public void addPacote(AddPacote form) throws DateTimeParseException, SQLException {
        String nome = form.getjTFNome().getText();
        float valor = Float.parseFloat(form.getjTFValor().getText());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        int disp = Integer.parseInt(form.getjTFDisp().getText());
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        Pacote pc = new Pacote(-1,
                nome.isBlank() ? null : nome,
                valor,
                LocalDate.parse(form.getjTFDtinicio().getText(),format),
                LocalDate.parse(form.getjTFDtfim().getText(),format),
                disp,
                cidade);
        DefaultListModel<AtracaoInclusa> list = (DefaultListModel<AtracaoInclusa>) form.getjLtAtracoes().getModel();
        ArrayList<ArrayList<LocalDate>> datas = new ArrayList<>(Arrays.asList(new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        for(int i = 0; i < list.size(); i++){
            AtracaoInclusa inclusa = list.get(i);
            AtracaoTuristica atracao = inclusa.getAtracaoTuristica();
            LocalDate data = inclusa.getData();
            String className = atracao.getClass().getName();
            if(className == Hotel.class.getName()){
                pc.addHoteis((Hotel)atracao);
                datas.get(0).add(data);
            } else if(className == Restaurante.class.getName()){
                pc.addRestaurantes((Restaurante)atracao);
                datas.get(1).add(data);
            } else if(className == CasaShow.class.getName() ||
                      className == Igreja.class.getName() ||
                      className == Museu.class.getName() ||
                      className == Parque.class.getName()){
                pc.addPontosTuristicos((PontoTuristico)atracao);
                datas.get(2).add(data);
            }
        }
        PacoteDAO.getInstance().addPacoteInclusos(pc, datas);
    }
    
    @Deprecated
    private void addAtracaoPacote(AtracaoTuristica at, Pacote pc, LocalDate data) throws SQLException {
        String className = at.getClass().getName();
        if(className == Hotel.class.getName()){
            PacoteDAO.getInstance().addHotelPacote((Hotel)at, pc, data);
        } else if(className == Restaurante.class.getName()){
            PacoteDAO.getInstance().addRestaurantePacote((Restaurante)at, pc, data);
        } else if(className == CasaShow.class.getName() ||
                  className == Igreja.class.getName() ||
                  className == Museu.class.getName() ||
                  className == Parque.class.getName()){
            PacoteDAO.getInstance().addPontoTuristicoPacote((PontoTuristico)at, pc, data);
        }
    }
    
    public ArrayList<Pacote> loadAllPacote(){
        return PacoteDAO.getInstance().loadAllPacote();
    }
    
}
