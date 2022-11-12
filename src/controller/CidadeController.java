/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Cidade;
import model.dao.CidadeDAO;
import view.AddCidade;
import view.UpCidade;

/**
 *
 * @author User
 */
public class CidadeController {
    
    public void addCidade(AddCidade form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String estado = form.getjCBEstado().getSelectedItem().toString();
        int populacao = Integer.parseInt(form.getjTFPopulacao().getText());
        Cidade cd = new Cidade(-1,
                nome.isBlank() ? null : nome,
                estado.isBlank() ? null : estado,
                populacao);
        CidadeDAO.getInstance().addCidade(cd);
    }
    
    public void updateCidade(UpCidade form) throws SQLException {
        Cidade cd = (Cidade) form.getjCBCidades().getSelectedItem();
        String nome = form.getjTFNome().getText();
        String estado = form.getjCBEstado().getSelectedItem().toString();
        int populacao = Integer.parseInt(form.getjTFPopulacao().getText());
        cd.setNome(nome.isBlank() ? null : nome);
        cd.setEstado(estado.isBlank() ? null : estado);
        cd.setPopulacao(populacao);
        CidadeDAO.getInstance().updateCidade(cd);
    }

    public void deleteCidade(UpCidade form){
        Cidade cd = (Cidade) form.getjCBCidades().getSelectedItem();
        CidadeDAO.getInstance().deleteCidade(cd);
    }
     
    public void showCidade(UpCidade form){
        Cidade cd = (Cidade) form.getjCBCidades().getSelectedItem();
        form.getjTFNome().setText(cd.getNome());
        form.getjCBEstado().setSelectedItem(cd.getEstado());
        form.getjTFPopulacao().setText("%d".formatted(cd.getPopulacao()));
    }
    
    public ArrayList<Cidade> loadAllCidade(){
        return CidadeDAO.getInstance().loadAllCidade();
    }
    
}
