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
import model.dao.FundadorDAO;
import model.entity.Fundador;
import model.entity.Museu;
import view.AddFundador;
import view.UpFundador;

/**
 *
 * @author User
 */
public class FundadorController {
    
    public void addFundador(AddFundador form) throws DateTimeParseException, SQLException {
        String nome = form.getjTFNome().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String nacionalidade = form.getjTFNacionalidade().getText();
        String ativprof = form.getjTFAtivprof().getText();
        Fundador fd = new Fundador(-1,
                nome.isBlank() ? null : nome,
                LocalDate.parse(form.getjTFDtnasc().getText(),format),
                nacionalidade.isBlank() ? null : nacionalidade,
                ativprof.isBlank() ? null : ativprof);
        if(form.getjCkBMorte().isSelected()){
            fd.setDtmorte(LocalDate.parse(form.getjTFDtmorte().getText(),format));
        }
        FundadorDAO.getInstance().addFundador(fd);
    }

    public void updateFundador(UpFundador form) throws DateTimeParseException, SQLException {
        Fundador fd = (Fundador) form.getjCBFundadores().getSelectedItem();
        String nome = form.getjTFNome().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String nacionalidade = form.getjTFNacionalidade().getText();
        String ativprof = form.getjTFAtivprof().getText();
        fd.setNome(nome.isBlank() ? null : nome);
        fd.setDtnasc(LocalDate.parse(form.getjTFDtnasc().getText(),format));
        fd.setNacionalidade(nacionalidade.isBlank() ? null : nacionalidade);
        fd.setAtivprof(ativprof.isBlank() ? null : ativprof);
        if(form.getjCkBMorte().isSelected()){
            fd.setDtmorte(LocalDate.parse(form.getjTFDtmorte().getText(),format));
        }else{
            fd.setDtmorte(null);
        }
        FundadorDAO.getInstance().updateFundador(fd);
    }

    public void deleteFundador(UpFundador form){
        Fundador fd = (Fundador) form.getjCBFundadores().getSelectedItem();
        FundadorDAO.getInstance().deleteFundador(fd);
    }
     
    public void showFundador(UpFundador form){
        Fundador fd = (Fundador) form.getjCBFundadores().getSelectedItem();
        form.getjTFNome().setText(fd.getNome());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFDtnasc().setText(fd.getDtnasc().format(format));
        if(fd.getDtmorte() != null){
            form.getjCkBMorte().setSelected(true);
            form.getjTFDtmorte().setText(fd.getDtmorte().format(format));
        }else{
            form.getjCkBMorte().setSelected(false);
            form.getjTFDtmorte().setText("");
        }
        form.getjTFNacionalidade().setText(fd.getNacionalidade());
        form.getjTFAtivprof().setText(fd.getAtivprof());
    }
    
    public ArrayList<Fundador> loadAllFundador(){
        return FundadorDAO.getInstance().loadAllFundador();
    }
    
    public ArrayList<Fundador> loadAllFundador(Museu ms){
        return FundadorDAO.getInstance().loadAllFundador(ms);
    }
    
}

