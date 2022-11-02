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
    private int categoria;

    public Restaurante(int codr, String nome, String endereco, Cidade cidade, int categoria){
        super(codr,nome,endereco,cidade);
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
