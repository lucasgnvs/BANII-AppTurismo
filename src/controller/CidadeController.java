/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.entity.Cidade;
import model.dao.CidadeDAO;
import view.AddCidade;

/**
 *
 * @author User
 */
public class CidadeController {
    
    public void addCidade(AddCidade form){
        Cidade cd = new Cidade(-1,form.getjTFNome().getText(),
                form.getjCBEstado().getSelectedItem().toString(),
                Integer.parseInt(form.getjFTFPopulacao().getText()));
        CidadeDAO.getInstance().addCidade(cd);
    }
    
}
