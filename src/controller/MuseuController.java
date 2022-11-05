/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.dao.MuseuDAO;
import model.dao.FundadorDAO;
import model.entity.Cidade;
import model.entity.Museu;
import model.entity.Fundador;
import view.AddPTuristico;

/**
 *
 * @author User
 */
public class MuseuController {
    
    public void addMuseu(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        String descricao = form.getjTADescricao().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        int nrsalas = Integer.parseInt(form.getjTFMuseuNrsalas().getText());
        Museu ms = new Museu(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                descricao.isBlank() ? null : descricao,
        LocalDate.parse(form.getjTFMuseuData().getText(),format),
                nrsalas);
        int codpt = MuseuDAO.getInstance().addMuseu(ms);
        ms.setCod(codpt);
        for(Fundador fd : form.getjLtMuseuFundadoresAsList()){
            FundadorDAO.getInstance().addFundacao(fd, ms);
        }
    }
    
    public ArrayList<Museu> loadAllMuseu(){
        return MuseuDAO.getInstance().loadAllMuseu();
    }
    
    public ArrayList<Museu> loadAllMuseu(Cidade cd){
        return MuseuDAO.getInstance().loadMuseuCidade(cd);
    }
    
}
