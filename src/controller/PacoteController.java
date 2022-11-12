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
import view.UpPacote;

enum ExecuteTipo{ADD,UPDATE,DELETE}

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
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
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
    
    private void addAtracaoPacote(AtracaoTuristica at, Pacote pc, LocalDate data, ExecuteTipo opcao) throws SQLException {
        String className = at.getClass().getName();
        if(className == Hotel.class.getName()){
            switch(opcao){
                case ADD -> PacoteDAO.getInstance().addHotelPacote((Hotel)at, pc, data);
                case UPDATE -> PacoteDAO.getInstance().updateHotelPacote((Hotel)at, pc, data);
                case DELETE -> PacoteDAO.getInstance().deleteHotelPacote((Hotel)at, pc, data);
            }
        } else if(className == Restaurante.class.getName()){
            switch(opcao){
                case ADD -> PacoteDAO.getInstance().addRestaurantePacote((Restaurante)at, pc, data);
                case UPDATE -> PacoteDAO.getInstance().updateRestaurantePacote((Restaurante)at, pc, data);
                case DELETE -> PacoteDAO.getInstance().deleteRestaurantePacote((Restaurante)at, pc, data);
            }
        } else if(className == CasaShow.class.getName() ||
                  className == Igreja.class.getName() ||
                  className == Museu.class.getName() ||
                  className == Parque.class.getName()){
            switch(opcao){
                case ADD -> PacoteDAO.getInstance().addPontoTuristicoPacote((PontoTuristico)at, pc, data);
                case UPDATE -> PacoteDAO.getInstance().updatePontoTuristicoPacote((PontoTuristico)at, pc, data);
                case DELETE -> PacoteDAO.getInstance().deletePontoTuristicoPacote((PontoTuristico)at, pc, data);
            }
        }
    }
    
    public void updatePacote(UpPacote form) throws DateTimeParseException, SQLException {
        Pacote pc = (Pacote) form.getjCBPacotes().getSelectedItem();
        String nome = form.getjTFNome().getText();
        float valor = Float.parseFloat(form.getjTFValor().getText());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        int disp = Integer.parseInt(form.getjTFDisp().getText());
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
        pc.setNome(nome.isBlank() ? null : nome);
        pc.setValor(valor);
        pc.setDtinicio(LocalDate.parse(form.getjTFDtinicio().getText(),format));
        pc.setDtfim(LocalDate.parse(form.getjTFDtfim().getText(),format));
        pc.setDisp(disp);
        pc.setCidade(cidade);
        PacoteDAO.getInstance().updatePacote(pc);
        ArrayList<AtracaoInclusa> list = form.getjLtAtracoesAsList();
        ArrayList<AtracaoInclusa> listdb = PacoteDAO.getInstance().loadAllAtracoes(pc);
        for(AtracaoInclusa ai : new ArrayList<>(list)){
            for(AtracaoInclusa aidb : new ArrayList<>(listdb)){
                if(ai.getAtracaoTuristica().getCod() == aidb.getAtracaoTuristica().getCod()){
                    list.remove(ai);
                    listdb.remove(aidb);
                    addAtracaoPacote(ai.getAtracaoTuristica(), pc, ai.getData(), ExecuteTipo.UPDATE);
                }
            }
        }
        for(AtracaoInclusa ai : list){
            addAtracaoPacote(ai.getAtracaoTuristica(), pc, ai.getData(), ExecuteTipo.ADD);
        }
        for(AtracaoInclusa aidb : listdb){
            addAtracaoPacote(aidb.getAtracaoTuristica(), pc, aidb.getData(), ExecuteTipo.DELETE);
        }
        
    }

    public void deletePacote(UpPacote form){
        Pacote pc = (Pacote) form.getjCBPacotes().getSelectedItem();
        PacoteDAO.getInstance().deletePacote(pc);
    }
     
    public void showPacote(UpPacote form){
        Pacote pc = (Pacote) form.getjCBPacotes().getSelectedItem();
        form.getjTFNome().setText(pc.getNome());
        Cidade cidade = form.getjCBCidadeAsList().stream().filter(cd -> cd.getCod() == pc.getCidade().getCod()).findFirst().get();
        form.getjCBCidade().setSelectedItem(cidade);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFDtinicio().setText(pc.getDtinicio().format(format));
        form.getjTFDtfim().setText(pc.getDtfim().format(format));
        form.getjTFValor().setText(Float.toString(pc.getValor()));
        form.getjTFDisp().setText("%d".formatted(pc.getDisp()));
        DefaultListModel<AtracaoInclusa> listmodel = new DefaultListModel<>();
        ArrayList<AtracaoInclusa> listai = PacoteDAO.getInstance().loadAllAtracoes(pc);
        for(AtracaoInclusa item : listai){
            listmodel.addElement(item);
        }
        form.getjLtAtracoes().setModel(listmodel);
    }
    
    public ArrayList<Pacote> loadAllPacote(){
        return PacoteDAO.getInstance().loadAllPacote();
    }
    
}
