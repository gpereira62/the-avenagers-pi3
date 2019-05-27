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
public class ClienteJuridico extends Cliente{
    private String cnpj;

    public ClienteJuridico(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public ClienteJuridico() {
        this.cnpj = "";
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
