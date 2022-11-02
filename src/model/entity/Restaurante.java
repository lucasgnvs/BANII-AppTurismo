/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author User
 */
public class Restaurante extends AtracaoTuristica {
    private String categoria;

    public Restaurante(int codr, String nome, String endereco, Cidade cidade, String categoria){
        super(codr,nome,endereco,cidade);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
