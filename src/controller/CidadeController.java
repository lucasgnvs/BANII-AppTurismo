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
    
    public ArrayList<Cidade> loadAllCidade(){
        return CidadeDAO.getInstance().loadAllCidade();
    }
    
}
