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
    
    public ArrayList<Parque> loadAllParque(){
        return ParqueDAO.getInstance().loadAllParque();
    }
    
    public ArrayList<Parque> loadAllParque(Cidade cd){
        return ParqueDAO.getInstance().loadParqueCidade(cd);
    }
    
}
