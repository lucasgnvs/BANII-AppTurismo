/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.ParqueDAO;
import model.entity.Cidade;
import model.entity.Parque;
import view.AddPTuristico;
import view.UpAtracoes;

/**
 *
 * @author User
 */
public class ParqueController {
    
    public void addParque(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        String descricao = form.getjTADescricao().getText();
        int nratracoes = Integer.parseInt(form.getjTFParqueNrAtracoes().getText());
        int capacidade = Integer.parseInt(form.getjTFParqueCapacidade().getText());
        Parque pq = new Parque(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                descricao.isBlank() ? null : descricao,
                nratracoes,
                capacidade);
        ParqueDAO.getInstance().addParque(pq);
    }
    
    public void updateParque(UpAtracoes form) throws SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        Parque pq = form.getListParque().get(index);
//        pq.set();
//        ParqueDAO.getInstance().updateParque(pq);
    }

    public void deleteParque(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        Parque pq = form.getListParque().get(index);
//        ParqueDAO.getInstance().deleteParque(pq);
    }
     
    public void showParque(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Parque pq = form.getListParque().get(index);
        form.getjTFNome().setText(pq.getNome());
        form.getjTFEndereco().setText(pq.getEndereco());
        int indexcd = -1;
        for (Cidade cd : form.getListCidade()) {
            if (cd.getCod() == pq.getCidade().getCod()){
                indexcd = form.getListCidade().indexOf(cd);
                break;
            }
        }
        form.getjCBCidade().setSelectedIndex(indexcd);
        form.getjTAParqueDescricao().setText(pq.getDescricao());
        form.getjTFParqueNrAtracoes().setText("%d".formatted(pq.getNratracoes()));
        form.getjTFParqueCapacidade().setText("%d".formatted(pq.getCapacidade()));
    }
    
    public ArrayList<Parque> loadAllParque(){
        return ParqueDAO.getInstance().loadAllParque();
    }
    
    public ArrayList<Parque> loadAllParque(Cidade cd){
        return ParqueDAO.getInstance().loadParqueCidade(cd);
    }
    
}
