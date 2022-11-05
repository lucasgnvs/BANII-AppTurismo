/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.DefaultListModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.entity.AtracaoInclusa;
import model.entity.AtracaoTuristica;
import view.AddPacote;

/**
 *
 * @author User
 */
public class AtracaoInclusaController {
    
    public void addAtracao(AddPacote form) throws DateTimeParseException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate data = LocalDate.parse(form.getjTFData().getText(),format);
        AtracaoTuristica atracaoTuristica = (AtracaoTuristica) form.getjCBAtracoes().getSelectedItem();
        AtracaoInclusa atracaoInclusa = new AtracaoInclusa(data, atracaoTuristica);
        DefaultListModel<AtracaoInclusa> list = (DefaultListModel<AtracaoInclusa>) form.getjLtAtracoes().getModel();
        for(int index = 0; index < list.getSize(); index++){
            AtracaoInclusa item = list.get(index);
            if(item.getData() == data || item.getAtracaoTuristica()==atracaoTuristica){
                return;
            }
        }
        list.addElement(atracaoInclusa);
        form.getjLtAtracoes().setModel(list);
    }
    
    public void removeAtracao(AddPacote form){
        int index = form.getjLtAtracoes().getSelectedIndex();
        DefaultListModel<AtracaoInclusa> list = (DefaultListModel<AtracaoInclusa>) form.getjLtAtracoes().getModel();
        if (index != -1){
            list.remove(index);
        }
        form.getjLtAtracoes().setModel(list);
    }
    
}
