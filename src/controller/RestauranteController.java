/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.RestauranteDAO;
import model.entity.Cidade;
import model.entity.Restaurante;
import view.AddRestaurante;

/**
 *
 * @author User
 */
public class RestauranteController {
    
    public void addRestaurante(AddRestaurante form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        int categoria = Integer.parseInt(form.getButtonGroup1().getSelection().getActionCommand());        
        Restaurante rt = new Restaurante(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                categoria);
        RestauranteDAO.getInstance().addRestaurante(rt);
    }
    
    public ArrayList<Restaurante> loadAllRestaurante(){
        return RestauranteDAO.getInstance().loadAllRestaurante();
    }
    
    public ArrayList<Restaurante> loadAllRestaurante(Cidade cd){
        return RestauranteDAO.getInstance().loadRestauranteCidade(cd);
    }
    
}
