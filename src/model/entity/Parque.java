/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author User
 */
public class Parque extends PontoTuristico {
    private int nratracoes;
    private int capacidade;
        
    public Parque(int codpt, String nome, String endereco, Cidade cidade, String descricao, int nratracoes, int capacidade){
        super(codpt, nome, endereco, cidade, descricao);
        this.nratracoes = nratracoes;
        this.capacidade = capacidade;
    }

    public int getNratracoes() {
        return nratracoes;
    }

    public void setNratracoes(int nratracoes) {
        this.nratracoes = nratracoes;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
