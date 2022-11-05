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
public class Fundador extends Entidade {
    private LocalDate dtnasc;
    private LocalDate dtmorte;
    private String nacionalidade;
    private String ativprof;
    
    public Fundador(int codf, String nome, LocalDate dtnasc, String nacionalidade, String ativprof){
        super(codf,nome);
        this.dtnasc = dtnasc;
        this.nacionalidade = nacionalidade;
        this.ativprof = ativprof;
    }
    
    @Override
    public String toString(){
        return "%s, %s".formatted(getNome(),getNacionalidade());
    }    

    public LocalDate getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(LocalDate dtnasc) {
        this.dtnasc = dtnasc;
    }

    public LocalDate getDtmorte() {
        return dtmorte;
    }

    public void setDtmorte(LocalDate dtmorte) {
        this.dtmorte = dtmorte;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getAtivprof() {
        return ativprof;
    }

    public void setAtivprof(String ativprof) {
        this.ativprof = ativprof;
    }
}
