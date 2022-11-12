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
import model.dao.IgrejaDAO;
import model.entity.Cidade;
import model.entity.Igreja;
import view.AddPTuristico;
import view.UpAtracoes;

/**
 *
 * @author User
 */
public class IgrejaController {
    
    public void addIgreja(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
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
    
    public void updateIgreja(UpAtracoes form) throws DateTimeParseException, SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        Igreja ig = form.getListIgreja().get(index);
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
        String descricao = form.getjTAIgrejaDescricao().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String estilo = form.getjTFIgrejaEstilo().getText();
        ig.setNome(nome.isBlank() ? null : nome);
        ig.setEndereco(endereco.isBlank() ? null : endereco);
        ig.setCidade(cidade);
        ig.setDescricao(descricao.isBlank() ? null : descricao);
        ig.setData(LocalDate.parse(form.getjTFIgrejaData().getText(),format));
        ig.setEstilo(estilo.isBlank() ? null : estilo);
        IgrejaDAO.getInstance().updateIgreja(ig);
    }

    public void deleteIgreja(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        Igreja ig = form.getListIgreja().get(index);
        IgrejaDAO.getInstance().deleteIgreja(ig);
    }
     
    public void showIgreja(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Igreja ig = form.getListIgreja().get(index);
        form.getjTFNome().setText(ig.getNome());
        form.getjTFEndereco().setText(ig.getEndereco());
        Cidade cidade = form.getjCBCidadeAsList().stream().filter(cd -> cd.getCod() == ig.getCidade().getCod()).findFirst().get();
        form.getjCBCidade().setSelectedItem(cidade);
        form.getjTAIgrejaDescricao().setText(ig.getDescricao());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFIgrejaData().setText(ig.getData().format(format));
        form.getjTFIgrejaEstilo().setText(ig.getEstilo());
    }

    public ArrayList<Igreja> loadAllIgreja(){
        return IgrejaDAO.getInstance().loadAllIgreja();
    }
    
    public ArrayList<Igreja> loadAllIgreja(Cidade cd){
        return IgrejaDAO.getInstance().loadIgrejaCidade(cd);
    }
    
}
