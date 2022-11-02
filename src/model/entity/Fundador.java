/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.util.Date;

/**
 *
 * @author User
 */
public class Fundador extends Entidade {
    private Date dtnasc;
    private Date dtmorte;
    private String nacionalidade;
    private String ativprof;
    
    public Fundador(int codf, String nome, Date dtnasc, String nacionalidade, String ativprof){
        super(codf,nome);
        this.nacionalidade = nacionalidade;
        this.ativprof = ativprof;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Date getDtmorte() {
        return dtmorte;
    }

    public void setDtmorte(Date dtmorte) {
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
