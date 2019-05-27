/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.model;

/**
 *
 * @author Gustavo
 */
public class ClienteFisico extends Cliente{
    private String cpf;
    
    public ClienteFisico(String cpf) {
        this.cpf = cpf;
    }
    
    public ClienteFisico() {
        this.cpf = "";
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
