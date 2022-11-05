/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.dao.CasaShowDAO;
import model.entity.Cidade;
import model.entity.CasaShow;
import view.AddPTuristico;

/**
 *
 * @author User
 */
public class CasaShowController {
 
    public void addCasaShow(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        String descricao = form.getjTADescricao().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        int diafech = form.getjCBCasashowDiafech().getSelectedIndex() + 1;
        CasaShow cs = new CasaShow(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                descricao.isBlank() ? null : descricao,
                LocalTime.parse(form.getjTFCasashowHrinicio().getText(),format),
                diafech);
        if(form.getjCkBCasashowRestaurante().isSelected()){
            cs.setRestaurante(form.getListRestaurante().get(form.getjCBCasashowRestaurante().getSelectedIndex()));
            cs.setPrecomedio(Float.parseFloat(form.getjTFCasashowPreco().getText()));
            cs.setEspecialidade(form.getjCBCasashowEsp().getSelectedIndex() + 1);
        }
        CasaShowDAO.getInstance().addCasaShow(cs);
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(){
        return CasaShowDAO.getInstance().loadAllCasaShow();
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(Cidade cd){
        return CasaShowDAO.getInstance().loadCasaShowCidade(cd);
    }
    
}
