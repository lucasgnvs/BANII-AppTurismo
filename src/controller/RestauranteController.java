/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import model.dao.RestauranteDAO;
import model.entity.Cidade;
import model.entity.Restaurante;
import view.AddRestaurante;
import view.UpAtracoes;

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
    
    
    public void updateRestaurante(UpAtracoes form) throws DateTimeParseException, SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        Restaurante rt = form.getListRestaurante().get(index);
//        ht.set();
//        RestauranteDAO.getInstance().updateRestaurante(rt);
    }

    public void deleteRestaurante(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        Restaurante rt = form.getListRestaurante().get(index);
//        RestauranteDAO.getInstance().deleteRestaurante(rt);
    }
     
    public void showRestaurante(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Restaurante rt = form.getListRestaurante().get(index);
        form.getjTFNome().setText(rt.getNome());
        form.getjTFEndereco().setText(rt.getEndereco());
        int indexcd = -1;
        for (Cidade cd : form.getListCidade()) {
            if (cd.getCod() == rt.getCidade().getCod()){
                indexcd = form.getListCidade().indexOf(cd);
                break;
            }
        }
        form.getjCBCidade().setSelectedIndex(indexcd);
        HashMap<Integer, JRadioButton> botao = new HashMap<>();
        botao.put(1,form.getjRBRestauranteCat1());
        botao.put(2,form.getjRBRestauranteCat2());
        form.getButtonGroupRestauranteCat().setSelected(botao.get(rt.getCategoria()).getModel(), true);
    }
    
    public ArrayList<Restaurante> loadAllRestaurante(){
        return RestauranteDAO.getInstance().loadAllRestaurante();
    }
    
    public ArrayList<Restaurante> loadAllRestaurante(Cidade cd){
        return RestauranteDAO.getInstance().loadRestauranteCidade(cd);
    }
    
}
