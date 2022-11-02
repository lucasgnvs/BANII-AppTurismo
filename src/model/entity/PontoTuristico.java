/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author User
 */
public abstract class PontoTuristico extends AtracaoTuristica {
    private String descricao;
    
    public PontoTuristico(int codpt, String nome, String endereco, Cidade cidade, String descricao){
        super(codpt, nome, endereco, cidade);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
