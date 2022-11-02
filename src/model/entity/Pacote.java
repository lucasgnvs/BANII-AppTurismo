/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author User
 */
public class Pacote extends Entidade {
    private float valor;
    private Date dtinicio;
    private Date dtfim;
    private int disp;
    private Cidade cidade;
    private ArrayList<Hotel> hoteis;
    private ArrayList<Restaurante> restaurantes;
    private ArrayList<PontoTuristico> pontosTuristicos;
        
    public Pacote(int codp, String nome, float valor, Date dtinicio, Date dtfim, int disp, Cidade cidade){
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDtinicio() {
        return dtinicio;
    }

    public void setDtinicio(Date dtinicio) {
        this.dtinicio = dtinicio;
    }

    public Date getDtfim() {
        return dtfim;
    }

    public void setDtfim(Date dtfim) {
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

    public void addHotel(Hotel hotel) {
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
