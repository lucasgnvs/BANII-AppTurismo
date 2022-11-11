/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.AddPTuristico;

/**
 *
 * @author User
 */
public class PTuristicoController {
    
    public void addPTuristico(AddPTuristico form) throws SQLException {
        String value = form.getButtonGroup1().getSelection().getActionCommand();
        switch(value){
            case "casashow" -> new CasaShowController().addCasaShow(form);
            case "igreja" -> new IgrejaController().addIgreja(form);
            case "museu" -> new MuseuController().addMuseu(form);
            case "parque" -> new ParqueController().addParque(form);
        }
    }
    
}
