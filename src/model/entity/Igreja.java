/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Igreja extends PontoTuristico {
    private LocalDate data;
    private String estilo;
        
    public Igreja(int codpt, String nome, String endereco, Cidade cidade, String descricao, LocalDate data, String estilo){
        super(codpt, nome, endereco, cidade, descricao);
        this.data = data;
        this.estilo = estilo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
