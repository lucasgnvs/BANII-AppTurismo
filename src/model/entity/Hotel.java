/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Hotel extends AtracaoTuristica {
    private int categoria;
    private Restaurante restaurante;
    final private ArrayList<Quarto> quartos;
    
    public Hotel(int codh, String nome, String endereco, Cidade cidade, int categoria){
        super(codh,nome,endereco,cidade);
        this.categoria = categoria;
        quartos = new ArrayList<>();
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public void addQuarto(Quarto quarto) {
        this.quartos.add(quarto);
    }
}
