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
import model.dao.ClienteDAO;
import model.entity.Cliente;
import model.entity.Pacote;
import view.AddCliente;
import view.UpCliente;

/**
 *
 * @author User
 */
public class ClienteController {
    
    public void addCliente(AddCliente form) throws DateTimeParseException, SQLException {
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String email = form.getjTFEmail().getText();
        String telefone = form.getjTFTelefone().getText();
        Cliente cl = new Cliente(-1,
                nome.isBlank() ? null : nome,
                endereco.isBlank() ? null : endereco,
                LocalDate.parse(form.getjTFDtnasc().getText(),format),
                email.isBlank() ? null : email,
                telefone.isBlank() ? null : telefone);
        ClienteDAO.getInstance().addCliente(cl);
    }
    
    public void updateCliente(UpCliente form) throws DateTimeParseException, SQLException {
        Cliente cl = (Cliente) form.getjCBClientes().getSelectedItem();
        String nome = form.getjTFNome().getText();
        String endereco = form.getjTFEndereco().getText();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String email = form.getjTFEmail().getText();
        String telefone = form.getjTFTelefone().getText();
        cl.setNome(nome.isBlank() ? null : nome);
        cl.setEndereco(endereco.isBlank() ? null : endereco);
        cl.setDtnasc(LocalDate.parse(form.getjTFDtnasc().getText(),format));
        cl.setEmail(email.isBlank() ? null : email);
        cl.setTelefone(telefone.isBlank() ? null : telefone);
        ClienteDAO.getInstance().updateCliente(cl);
    }

    public void deleteCliente(UpCliente form){
        Cliente cl = (Cliente) form.getjCBClientes().getSelectedItem();
        ClienteDAO.getInstance().deleteCliente(cl);
    }
     
    public void showCliente(UpCliente form){
        Cliente cl = (Cliente) form.getjCBClientes().getSelectedItem();
        form.getjTFNome().setText(cl.getNome());
        form.getjTFEndereco().setText(cl.getEndereco());
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        form.getjTFDtnasc().setText(cl.getDtnasc().format(format));
        form.getjTFEmail().setText(cl.getEmail());
        form.getjTFEmail().setText(cl.getEmail());
        form.getjTFTelefone().setText(cl.getTelefone());
        form.getjCBPacotes().removeAllItems();
        ArrayList<Pacote> list = new ContratoController().loadAllPacote(cl);
        for(Pacote item : list){
            form.getjCBPacotes().addItem(item.toString());
        }
    }
    
    public ArrayList<Cliente> loadAllCliente(){
        return ClienteDAO.getInstance().loadAllCliente();
    }
    
}
