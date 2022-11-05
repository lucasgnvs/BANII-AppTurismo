/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class AtracaoInclusa {
    private LocalDate data;
    private AtracaoTuristica atracaoTuristica;
    
    public AtracaoInclusa(LocalDate data, AtracaoTuristica atracaoTuristica){
        this.data = data;
        this.atracaoTuristica = atracaoTuristica;
    }
    
    @Override
    public String toString(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return "%s - %s".formatted(data.format(format), getAtracaoTuristica());
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public AtracaoTuristica getAtracaoTuristica() {
        return atracaoTuristica;
    }

    public void setAtracaoTuristica(AtracaoTuristica atracaoTuristica) {
        this.atracaoTuristica = atracaoTuristica;
    }
    
}
