/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import model.dao.CasaShowDAO;
import model.entity.Cidade;
import model.entity.CasaShow;
import model.entity.Restaurante;
import view.AddPTuristico;
import view.UpAtracoes;

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
    
    public void updateCasaShow(UpAtracoes form) throws DateTimeParseException, SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        CasaShow cs = form.getListCasaShow().get(index);
//        cs.set();
//        CasaShowDAO.getInstance().updateCasaShow(cs);
    }

    public void deleteCasaShow(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        CasaShow cs = form.getListCasaShow().get(index);
//        CasaShowDAO.getInstance().deleteCasaShow(cs);
    }
     
    public void showCasaShow(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        CasaShow cs = form.getListCasaShow().get(index);
        form.getjTFNome().setText(cs.getNome());
        form.getjTFEndereco().setText(cs.getEndereco());
        int indexcd = -1;
        for (Cidade cd : form.getListCidade()) {
            if (cd.getCod() == cs.getCidade().getCod()){
                indexcd = form.getListCidade().indexOf(cd);
                break;
            }
        }
        form.getjCBCidade().setSelectedIndex(indexcd);
        form.getjTACasashowDescricao().setText(cs.getDescricao());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        form.getjTFCasashowHrinicio().setText(cs.getHrinicio().format(format));
        form.getjCBCasashowDiafech().setSelectedIndex(cs.getDiafech() - 1);
        form.getjCkBCasashowRestaurante().setSelected(false);
        form.getjCBCasashowRestaurante().removeAllItems();
        if(cs.getRestaurante() != null){    
            ArrayList<Restaurante> listRestaurante = new RestauranteController().loadAllRestaurante(form.getListCidade().get(indexcd));
            for(Restaurante item : listRestaurante){
                form.getjCBCasashowRestaurante().addItem(item.toString());
            }
            form.getjCBCasashowEsp().setSelectedIndex(cs.getEspecialidade() ==  -1 ? 0 : cs.getEspecialidade() - 1);
            form.getjTFCasashowPreco().setText("%.2f".formatted(cs.getPrecomedio()));
            int indexr = -1;
            for (Restaurante rt : listRestaurante) {
                if (rt.getCod() == cs.getRestaurante().getCod()){
                    indexr = listRestaurante.indexOf(rt);
                    break;
                }
            }
            form.getjCkBCasashowRestaurante().setSelected(true);
            form.getjCBCasashowRestaurante().setSelectedIndex(indexr);
        }else{
            form.getjCBCasashowEsp().setSelectedIndex(0);
            form.getjTFCasashowPreco().setText("");
        }
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(){
        return CasaShowDAO.getInstance().loadAllCasaShow();
    }
    
    public ArrayList<CasaShow> loadAllCasaShow(Cidade cd){
        return CasaShowDAO.getInstance().loadCasaShowCidade(cd);
    }
    
}
