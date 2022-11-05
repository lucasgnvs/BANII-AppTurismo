/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.HotelDAO;
import model.dao.QuartoDAO;
import model.entity.Cidade;
import model.entity.Restaurante;
import model.entity.Hotel;
import model.entity.Quarto;
import view.AddHotel;

/**
 *
 * @author User
 */
public class HotelController {
    
    public void addHotel(AddHotel form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        int categoria = Integer.parseInt(form.getButtonGroup1().getSelection().getActionCommand());
        Hotel ht = new Hotel(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                categoria);
        if (form.getjCkBRestaurante().isSelected()){
            Restaurante rt = form.getListRestaurante().get(form.getjCBRestaurante().getSelectedIndex());
            ht.setRestaurante(rt);
        }
        int codh = HotelDAO.getInstance().addHotel(ht);
        ht.setCod(codh);
        if (form.getjCkBQuartos1().isSelected()){
            Quarto qt1 = new Quarto(-1,
            1,
            Float.parseFloat(form.getjTFValor1().getText()),
            Integer.parseInt(form.getjTFNrquartos1().getText()),
            Integer.parseInt(form.getjTFNrhospedes1().getText()));
            QuartoDAO.getInstance().addQuarto(ht, qt1);
        }
        if (form.getjCkBQuartos2().isSelected()){
            Quarto qt2 = new Quarto(-1,
            2,
            Float.parseFloat(form.getjTFValor2().getText()),
            Integer.parseInt(form.getjTFNrquartos2().getText()),
            Integer.parseInt(form.getjTFNrhospedes2().getText()));
            QuartoDAO.getInstance().addQuarto(ht, qt2);
        }
        if (form.getjCkBQuartos3().isSelected()){
            Quarto qt3 = new Quarto(-1,
            3,
            Float.parseFloat(form.getjTFValor3().getText()),
            Integer.parseInt(form.getjTFNrquartos3().getText()),
            Integer.parseInt(form.getjTFNrhospedes3().getText()));
            QuartoDAO.getInstance().addQuarto(ht, qt3);
        }
    }
    
    public ArrayList<Hotel> loadAllHotel(){
        return HotelDAO.getInstance().loadAllHotel();
    }
    
    public ArrayList<Hotel> loadAllHotel(Cidade cd){
        return HotelDAO.getInstance().loadHotelCidade(cd);
    }
    
}
