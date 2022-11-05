/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author User
 */
public class Cidade extends Entidade {
    private String estado;
    private int populacao;
        
    public Cidade(int codcd, String nome, String estado, int populacao){
        super(codcd, nome);
        this.estado = estado;
        this.populacao = populacao;
    }
    
    @Override
    public String toString(){
        return "%s, %s".formatted(getNome(),getEstado());
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
}
