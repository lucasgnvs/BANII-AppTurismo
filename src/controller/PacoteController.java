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
    
    
    public void updatePacote(UpPacote form) throws DateTimeParseException, SQLException {
        int index = form.getjCBPacotes().getSelectedIndex();
        Pacote pc = form.getListPacote().get(index);
//        cp.set();
//        PacoteDAO.getInstance().updatePacote(pc);
    }

    public void deletePacote(UpPacote form){
        int index = form.getjCBPacotes().getSelectedIndex();
        Pacote pc = form.getListPacote().get(index);
//        PacoteDAO.getInstance().deletePacote(pc);
    }
     
    public void showPacote(UpPacote form){
        int index = form.getjCBPacotes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Pacote pc = form.getListPacote().get(index);
        form.getjTFNome().setText(pc.getNome());
        int indexcd = -1;
        for (Cidade cd : form.getListCidade()) {
            if (cd.getCod() == pc.getCidade().getCod()){
                indexcd = form.getListCidade().indexOf(cd);
                break;
            }
        }
        form.getjCBCidade().setSelectedIndex(indexcd);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFDtinicio().setText(pc.getDtinicio().format(format));
        form.getjTFDtfim().setText(pc.getDtfim().format(format));
        form.getjTFValor().setText("%.2f".formatted(pc.getValor()));
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
