/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.ContratoDAO;
import model.entity.Cliente;
import model.entity.Pacote;
import view.AddContrato;

/**
 *
 * @author User
 */
public class ContratoController {
    
    public void addContrato(AddContrato form) throws SQLException {
        Pacote pc = form.getListPacote().get(form.getjCBPacote().getSelectedIndex());
        Cliente cl = form.getListCliente().get(form.getjCBCliente().getSelectedIndex());
        ContratoDAO.getInstance().addContrato(pc, cl);
    }
    
    public ArrayList<Pacote> loadAllPacote(Cliente cl) {
        return ContratoDAO.getInstance().loadAllPacote(cl);
    }
    
}
