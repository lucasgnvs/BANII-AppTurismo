/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.time.LocalTime;

/**
 *
 * @author User
 */
public class CasaShow extends PontoTuristico {
    private LocalTime hrinicio;
    private int diafech;
    private Restaurante restaurante;
    private float precomedio;
    private int especialidade;
        
    public CasaShow(int codpt, String nome, String endereco, Cidade cidade, String descricao, LocalTime hrinicio, int diafech){
        super(codpt, nome, endereco, cidade, descricao);
        this.hrinicio = hrinicio;
        this.diafech = diafech;
    }

    public LocalTime getHrinicio() {
        return hrinicio;
    }

    public void setHrinicio(LocalTime hrinicio) {
        this.hrinicio = hrinicio;
    }

    public int getDiafech() {
        return diafech;
    }

    public void setDiafech(int diafech) {
        this.diafech = diafech;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public float getPrecomedio() {
        return precomedio;
    }

    public void setPrecomedio(float precomedio) {
        this.precomedio = precomedio;
    }

    public int getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }
}
