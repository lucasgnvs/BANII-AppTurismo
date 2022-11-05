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
import view.AddFundador;
import view.AddPTuristico;

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

    public ArrayList<Fundador> loadAllFundador(){
        return FundadorDAO.getInstance().loadAllFundador();
    }
}

