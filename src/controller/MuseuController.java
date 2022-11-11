/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import model.dao.MuseuDAO;
import model.dao.FundadorDAO;
import model.entity.Cidade;
import model.entity.Museu;
import model.entity.Fundador;
import view.AddPTuristico;
import view.UpAtracoes;

/**
 *
 * @author User
 */
public class MuseuController {
    
    public void addMuseu(AddPTuristico form) throws SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        Cidade cidade = form.getListCidade().get(form.getjCBCidade().getSelectedIndex());
        String descricao = form.getjTADescricao().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        int nrsalas = Integer.parseInt(form.getjTFMuseuNrsalas().getText());
        Museu ms = new Museu(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                cidade,
                descricao.isBlank() ? null : descricao,
        LocalDate.parse(form.getjTFMuseuData().getText(),format),
                nrsalas);
        int codpt = MuseuDAO.getInstance().addMuseu(ms);
        ms.setCod(codpt);
        for(Fundador fd : form.getjLtMuseuFundadoresAsList()){
            FundadorDAO.getInstance().addFundacao(fd, ms);
        }
    }
    
    public void updateMuseu(UpAtracoes form) throws DateTimeParseException, SQLException {
        int index = form.getjCBAtracoes().getSelectedIndex();
        Museu ms = form.getListMuseu().get(index);
//        ms.set();
//        MuseuDAO.getInstance().updateMuseu(ms);
    }

    public void deleteMuseu(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        Museu ms = form.getListMuseu().get(index);
//        MuseuDAO.getInstance().deleteMuseu(ms);
    }
     
    public void showMuseu(UpAtracoes form){
        int index = form.getjCBAtracoes().getSelectedIndex();
        if(index == -1){
            index = 0;
        }
        Museu ms = form.getListMuseu().get(index);
        form.getjTFNome().setText(ms.getNome());
        form.getjTFEndereco().setText(ms.getEndereco());
        int indexcd = -1;
        for (Cidade cd : form.getListCidade()) {
            if (cd.getCod() == ms.getCidade().getCod()){
                indexcd = form.getListCidade().indexOf(cd);
                break;
            }
        }
        form.getjCBCidade().setSelectedIndex(indexcd);
        form.getjTAMuseuDescricao().setText(ms.getDescricao());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFMuseuData().setText(ms.getDtfundacao().format(format));
        form.getjTFMuseuNrsalas().setText("%d".formatted(ms.getNrsalas()));
        form.getjCBMuseuFundadores().removeAllItems();
        ArrayList<Fundador> list = new FundadorController().loadAllFundador();
        for(Fundador item : list){
            form.getjCBMuseuFundadores().addItem(item.toString());
        }
        DefaultListModel<Fundador> listmodel = new DefaultListModel<>();
        ArrayList<Fundador> listf = new FundadorController().loadAllFundador(ms);
        for(Fundador item : listf){
            listmodel.addElement(item);
        }
        form.getjLtMuseuFundadores().setModel(listmodel);
    }
    
    public ArrayList<Museu> loadAllMuseu(){
        return MuseuDAO.getInstance().loadAllMuseu();
    }
    
    public ArrayList<Museu> loadAllMuseu(Cidade cd){
        return MuseuDAO.getInstance().loadMuseuCidade(cd);
    }
    
}
