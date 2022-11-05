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
import view.AddCliente;

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
    
    public ArrayList<Cliente> loadAllCliente(){
        return ClienteDAO.getInstance().loadAllCliente();
    }
    
}
