/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JRadioButton;
import model.dao.HotelDAO;
import model.dao.QuartoDAO;
import model.entity.Cidade;
import model.entity.Restaurante;
import model.entity.Hotel;
import model.entity.Quarto;
import view.AddHotel;
import view.UpAtracoes;

/**
 *
 * @author User
 */
public class HotelController {
    
    public void addHotel(AddHotel form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
        int categoria = Integer.parseInt(form.getButtonGroup1().getSelection().getActionCommand());
        Hotel ht = new Hotel(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                categoria);
        if (form.getjCkBRestaurante().isSelected()){
            Restaurante rt = (Restaurante) form.getjCBRestaurante().getSelectedItem();
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
    
    public void updateHotel(UpAtracoes form) throws DateTimeParseException, SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        Hotel ht = form.getListHotel().get(index);
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = (Cidade) form.getjCBCidade().getSelectedItem();
        int categoria = Integer.parseInt(form.getButtonGroupHotelCat().getSelection().getActionCommand());
        ht.setNome(nome.isBlank() ? null : nome);
        ht.setEndereco(endereco.isBlank() ? null : endereco);
        ht.setCidade(cidade);
        ht.setCategoria(categoria);
        if (form.getjCkBHotelRestaurante().isSelected()){
            Restaurante rt = (Restaurante) form.getjCBHotelRestaurante().getSelectedItem();
            ht.setRestaurante(rt);
        }else{
            ht.setRestaurante(null);
        }
        HotelDAO.getInstance().updateHotel(ht);
        ArrayList<Quarto> listq = QuartoDAO.getInstance().loadAllQuarto(ht);
        boolean[] listqa = {false,false,false,false};
        int[] listqcod = {-1,-1,-1,-1};
        for(Quarto qt : listq){
            listqa[qt.getNome()] = true;
            listqcod[qt.getNome()] = qt.getCod();
        }
        if(form.getjCkBHotelQuartos1().isSelected()){
            Quarto qt1 = new Quarto(listqcod[1],
            1,
            Float.parseFloat(form.getjTFValor1().getText()),
            Integer.parseInt(form.getjTFNrquartos1().getText()),
            Integer.parseInt(form.getjTFNrhospedes1().getText()));
            if(listqa[1]){
                QuartoDAO.getInstance().updateQuarto(qt1);
            }else{
                QuartoDAO.getInstance().addQuarto(ht, qt1);
            }
        }else{
            if(listqa[1]){
                QuartoDAO.getInstance().deleteQuarto(new Quarto(listqcod[1],-1,0,0,0));
            }
        }
        if(form.getjCkBHotelQuartos2().isSelected()){
            Quarto qt2 = new Quarto(listqcod[2],
            2,
            Float.parseFloat(form.getjTFValor2().getText()),
            Integer.parseInt(form.getjTFNrquartos2().getText()),
            Integer.parseInt(form.getjTFNrhospedes2().getText()));
            if(listqa[2]){
                QuartoDAO.getInstance().updateQuarto(qt2);
            }else{
                QuartoDAO.getInstance().addQuarto(ht, qt2);
            }
        }else{
            if(listqa[2]){
                QuartoDAO.getInstance().deleteQuarto(new Quarto(listqcod[2],-1,0,0,0));
            }
        }
        if(form.getjCkBHotelQuartos3().isSelected()){
            Quarto qt3 = new Quarto(listqcod[3],
            3,
            Float.parseFloat(form.getjTFValor3().getText()),
            Integer.parseInt(form.getjTFNrquartos3().getText()),
            Integer.parseInt(form.getjTFNrhospedes3().getText()));
            if(listqa[3]){
                QuartoDAO.getInstance().updateQuarto(qt3);
            }else{
                QuartoDAO.getInstance().addQuarto(ht, qt3);
            }
        }else{
            if(listqa[3]){
                QuartoDAO.getInstance().deleteQuarto(new Quarto(listqcod[3],-1,0,0,0));
            }
        }
    }

    public void deleteHotel(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        Hotel ht = form.getListHotel().get(index);
        HotelDAO.getInstance().deleteHotel(ht);
    }
     
    public void showHotel(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Hotel ht = form.getListHotel().get(index);
        form.getjTFNome().setText(ht.getNome());
        form.getjTFEndereco().setText(ht.getEndereco());
        Cidade cidade = form.getjCBCidadeAsList().stream().filter(cd -> cd.getCod() == ht.getCidade().getCod()).findFirst().get();
        form.getjCBCidade().setSelectedItem(cidade);
        ArrayList<JRadioButton> botao = new ArrayList<>(Arrays.asList(null,form.getjRBCat1(), form.getjRBCat2(), form.getjRBCat3(), form.getjRBCat4(), form.getjRBCat5()));
        form.getButtonGroupHotelCat().setSelected(botao.get(ht.getCategoria()).getModel(),true);
        form.getjCkBHotelRestaurante().setSelected(false);
        form.getjCBHotelRestaurante().removeAllItems();
        if(ht.getRestaurante() != null){    
            ArrayList<Restaurante> listRestaurante = new RestauranteController().loadAllRestaurante(cidade);
            for(Restaurante item : listRestaurante){
                form.getjCBHotelRestaurante().addItem(item);
            }
            int indexr = -1;
            for (Restaurante rt : listRestaurante) {
                if (rt.getCod() == ht.getRestaurante().getCod()){
                    indexr = listRestaurante.indexOf(rt);
                    break;
                }
            }
            form.getjCkBHotelRestaurante().setSelected(true);
            form.getjCBHotelRestaurante().setSelectedIndex(indexr);
        }
        ArrayList<Quarto> listq = QuartoDAO.getInstance().loadAllQuarto(ht);
        form.getjCkBHotelQuartos1().setSelected(false);
        form.getjTFNrquartos1().setText("");
        form.getjTFNrhospedes1().setText("");
        form.getjTFValor1().setText("");
        form.getjCkBHotelQuartos2().setSelected(false);
        form.getjTFNrquartos2().setText("");
        form.getjTFNrhospedes2().setText("");
        form.getjTFValor2().setText("");
        form.getjCkBHotelQuartos3().setSelected(false);
        form.getjTFNrquartos3().setText("");
        form.getjTFNrhospedes3().setText("");
        form.getjTFValor3().setText("");
        for(Quarto qt : listq){
            switch(qt.getNome()){
                case 1 -> {
                    form.getjCkBHotelQuartos1().setSelected(true);
                    form.getjTFNrquartos1().setText("%d".formatted(qt.getNrquartos()));
                    form.getjTFNrhospedes1().setText("%d".formatted(qt.getNrhospedes()));
                    form.getjTFValor1().setText(Float.toString(qt.getValor()));
                }
                case 2 -> {
                    form.getjCkBHotelQuartos2().setSelected(true);
                    form.getjTFNrquartos2().setText("%d".formatted(qt.getNrquartos()));
                    form.getjTFNrhospedes2().setText("%d".formatted(qt.getNrhospedes()));
                    form.getjTFValor2().setText(Float.toString(qt.getValor()));
                }
                case 3 -> {
                    form.getjCkBHotelQuartos3().setSelected(true);
                    form.getjTFNrquartos3().setText("%d".formatted(qt.getNrquartos()));
                    form.getjTFNrhospedes3().setText("%d".formatted(qt.getNrhospedes()));
                    form.getjTFValor3().setText(Float.toString(qt.getValor()));
                }
            }
        }
    }
    
    public ArrayList<Hotel> loadAllHotel(){
        return HotelDAO.getInstance().loadAllHotel();
    }
    
    public ArrayList<Hotel> loadAllHotel(Cidade cd){
        return HotelDAO.getInstance().loadHotelCidade(cd);
    }
    
}
