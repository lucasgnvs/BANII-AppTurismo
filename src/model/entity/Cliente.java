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
public class Cliente extends Entidade {
    private LocalDate dtnasc;
    private String email;
    private String endereco;
    private String telefone;
    
    public Cliente(int codc, String nome, String endereco, LocalDate dtnasc, String email, String telefone){
        super(codc,nome);
        this.dtnasc = dtnasc;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    @Override
    public String toString(){
        return "%s - %s".formatted(getNome(),getEmail());
    }

    public LocalDate getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(LocalDate dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
