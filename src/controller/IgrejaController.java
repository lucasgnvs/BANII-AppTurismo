/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.dao.IgrejaDAO;
import model.entity.Cidade;
import model.entity.Igreja;
import view.AddPTuristico;

/**
 *
 * @author User
 */
public class IgrejaController {
    
    public void addIgreja(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        String descricao = form.getjTADescricao().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String estilo = form.getjTFIgrejaEstilo().getText();
        Igreja ig = new Igreja(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                descricao.isBlank() ? null : descricao,
                LocalDate.parse(form.getjTFIgrejaData().getText(),format),
                estilo.isBlank() ? null : estilo);
        IgrejaDAO.getInstance().addIgreja(ig);
    }

    public ArrayList<Igreja> loadAllIgreja(){
        return IgrejaDAO.getInstance().loadAllIgreja();
    }
    
    public ArrayList<Igreja> loadAllIgreja(Cidade cd){
        return IgrejaDAO.getInstance().loadIgrejaCidade(cd);
    }
    
}
