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
import model.dao.PacoteDAO;
import model.entity.Pacote;
import view.AddPacote;

/**
 *
 * @author User
 */
public class PacoteController {
    
    public void addPacote(AddPacote form) throws DateTimeParseException, SQLException {
//        String nome = form.getjTFNome().getText();;
//        String endereco = form.getjTFEndereco().getText();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
//        String email = form.getjTFEmail().getText();
//        String telefone = form.getjTFTelefone().getText();
//        Pacote pc = new Pacote(-1,
//                nome.isBlank() ? null : nome,
//                endereco.isBlank() ? null : endereco,
//                LocalDate.parse(form.getjTFDtnasc().getText(),format),
//                email.isBlank() ? null : email,
//                telefone.isBlank() ? null : telefone);
//        ClienteDAO.getInstance().addCliente(cl);
    }
    
    public ArrayList<Pacote> loadAllPacote(){
        return PacoteDAO.getInstance().loadAllPacote();
    }
    
}
