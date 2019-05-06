/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.model;

/**
 *
 * @author caio.araujo
 */
public class Administracao extends Object {
    
    private int idFilial;
    private String nomeFilial, CNPJ, Estado, Cidade, CEP;
    private boolean ativo;

    public Administracao() {
        this.idFilial = 0;
        this.nomeFilial = "";
        this.CNPJ = "";
        this.Estado = "";
        this.Cidade = "";
        this.CEP = "";
        this.ativo = true;
    }
    
    public Administracao(int idFilial, String nomeFilial, String CNPJ, String Estado, String Cidade, String CEP, boolean ativo) {
        this.idFilial = idFilial;
        this.nomeFilial = nomeFilial;
        this.CNPJ = CNPJ;
        this.Estado = Estado;
        this.Cidade = Cidade;
        this.CEP = CEP;
        this.ativo = ativo;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
    }
    

    public String getNomeFilial() {
        return nomeFilial;
    }

    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCEP() {
        return CEP;
    }

   public void setCEP(String CEP) {
        this.CEP = CEP;
    }


    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }  
    
}
