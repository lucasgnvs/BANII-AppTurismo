/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class Pacote extends Entidade {
    private float valor;
    private LocalDate dtinicio;
    private LocalDate dtfim;
    private int disp;
    private Cidade cidade;
    private ArrayList<Hotel> hoteis;
    private ArrayList<Restaurante> restaurantes;
    private ArrayList<PontoTuristico> pontosTuristicos;
        
    public Pacote(int codp, String nome, float valor, LocalDate dtinicio, LocalDate dtfim, int disp, Cidade cidade){
        super(codp, nome);
        this.valor = valor;
        this.dtinicio = dtinicio;
        this.dtfim = dtfim;
        this.disp = disp;
        this.cidade = cidade;
        this.hoteis = new ArrayList<>();
        this.restaurantes = new ArrayList<>();
        this.pontosTuristicos = new ArrayList<>();
    }
    
    @Override
    public String toString(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        return "%s - (%s - %s)".formatted(getNome(),getDtinicio().format(format),getDtfim().format(format));
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(LocalDate dtinicio) {
        this.dtinicio = dtinicio;
    }

    public LocalDate getDtfim() {
        return dtfim;
    }

    public void setDtfim(LocalDate dtfim) {
        this.dtfim = dtfim;
    }

    public int getDisp() {
        return disp;
    }

    public void setDisp(int disp) {
        this.disp = disp;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Hotel> getHoteis() {
        return hoteis;
    }

    public void addHoteis(Hotel hotel) {
        this.hoteis.add(hotel);
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void addRestaurantes(Restaurante restaurante) {
        this.restaurantes.add(restaurante);
    }

    public ArrayList<PontoTuristico> getPontosTuristicos() {
        return pontosTuristicos;
    }

    public void addPontosTuristicos(PontoTuristico pontoTuristico) {
        this.pontosTuristicos.add(pontoTuristico);
    }
}
