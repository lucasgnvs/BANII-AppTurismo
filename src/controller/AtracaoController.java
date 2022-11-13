/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import view.UpAtracoes;

/**
 *
 * @author User
 */

public class AtracaoController {
    
    public void executeAtracao(UpAtracoes form, AtracaoExecuteTipo opcao) throws SQLException {
        String value = form.getButtonGroupAtracoes().getSelection().getActionCommand();
        switch(value){
            case "hotel" -> {
                switch(opcao){
                    case SHOW -> new HotelController().showHotel(form);
                    case UPDATE -> new HotelController().updateHotel(form);
                    case DELETE -> new HotelController().deleteHotel(form);
                }
            }
            case "restaurante" -> {
                switch(opcao){
                    case SHOW -> new RestauranteController().showRestaurante(form);
                    case UPDATE -> new RestauranteController().updateRestaurante(form);
                    case DELETE -> new RestauranteController().deleteRestaurante(form);
                }
            }
            case "casashow" -> {
                switch(opcao){
                    case SHOW -> new CasaShowController().showCasaShow(form);
                    case UPDATE -> new CasaShowController().updateCasaShow(form);
                    case DELETE -> new CasaShowController().deleteCasaShow(form);
                }
            }
            case "igreja" -> {
                switch(opcao){
                    case SHOW -> new IgrejaController().showIgreja(form);
                    case UPDATE -> new IgrejaController().updateIgreja(form);
                    case DELETE -> new IgrejaController().deleteIgreja(form);
                }
            }
            case "museu" -> {
                switch(opcao){
                    case SHOW -> new MuseuController().showMuseu(form);
                    case UPDATE -> new MuseuController().updateMuseu(form);
                    case DELETE -> new MuseuController().deleteMuseu(form);
                }
            }
            case "parque" -> {
                switch(opcao){
                    case SHOW -> new ParqueController().showParque(form);
                    case UPDATE -> new ParqueController().updateParque(form);
                    case DELETE -> new ParqueController().deleteParque(form);
                }
            }
        }
    }

    public int loadTotal(){
        return new HotelController().loadTotal() +
        new RestauranteController().loadTotal() +
        new PTuristicoController().loadTotal();
    }
        
}
