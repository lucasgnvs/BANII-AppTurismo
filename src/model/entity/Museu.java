/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Museu extends PontoTuristico {
    private LocalDate dtfundacao;
    private int nrsalas;
    final private ArrayList<Fundador> fundadores;
    
    public Museu(int codpt, String nome, String endereco, Cidade cidade, String descricao, LocalDate dtfundacao, int nrsalas){
        super(codpt, nome, endereco, cidade, descricao);
        this.dtfundacao = dtfundacao;
        this.nrsalas = nrsalas;
        this.fundadores = new ArrayList<>();
    }

    public LocalDate getDtfundacao() {
        return dtfundacao;
    }

    public void setDtfundacao(LocalDate dtfundacao) {
        this.dtfundacao = dtfundacao;
    }

    public int getNrsalas() {
        return nrsalas;
    }

    public void setNrsalas(int nrsalas) {
        this.nrsalas = nrsalas;
    }

    public ArrayList<Fundador> getFundadores() {
        return fundadores;
    }

    public void addFundador(Fundador fundador) {
        this.fundadores.add(fundador);
    }
}
