/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author User
 */
public class Quarto{
    private int codq;
    private int nome;
    private float valor;
    private int nrquartos;
    private int nrhospedes;
    
    public Quarto(int codq, int nome, float valor, int nrquartos, int nrhospedes){
        this.codq = codq;
        this.nome = nome;
        this.valor = valor;
        this.nrquartos = nrquartos;
        this.nrhospedes = nrhospedes;
    }

    public int getCod() {
        return codq;
    }

    public void setCod(int codq) {
        this.codq = codq;
    }
    
    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getNrquartos() {
        return nrquartos;
    }

    public void setNrquartos(int nrquartos) {
        this.nrquartos = nrquartos;
    }

    public int getNrhospedes() {
        return nrhospedes;
    }

    public void setNrhospedes(int nrhospedes) {
        this.nrhospedes = nrhospedes;
    }
}
