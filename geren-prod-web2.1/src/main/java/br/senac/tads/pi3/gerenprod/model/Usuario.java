/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bruna
 */
public class Usuario {
  
  private int idUsuario, idDepartamento, idFilial;
  private String nome, email, senha, nomeFilial, nomeDepartamento;
  private boolean ativo;

  public Usuario() {
    this.idUsuario = 0;
    this.idDepartamento = 0;
    this.idFilial = 0;
    this.nome = "";
    this.email = "";
    this.senha = "";
    this.ativo = true;
    this.nomeFilial = "";
    this.nomeDepartamento = "";
  }

  public Usuario(int idUsuario, int idDepartamento, int idFilial, String nome, String email, String senha, boolean ativo, String nomeFilial, String nomeDepartamento) {
    this.idUsuario = idUsuario;
    this.idDepartamento = idDepartamento;
    this.idFilial = idFilial;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.ativo = ativo;
    this.nomeFilial = nomeFilial;
    this.nomeDepartamento = nomeDepartamento;
  }

  public void setSession(HttpServletRequest request) {
    
    HttpSession sessao = request.getSession();
    
    sessao.setAttribute("usuario.idUsuario", this.idUsuario);
    sessao.setAttribute("usuario.idDepartamento", this.idDepartamento);
    sessao.setAttribute("usuario.idFilial", this.idFilial);
    sessao.setAttribute("usuario.nome", this.nome);
    sessao.setAttribute("usuario.email", this.email);
    sessao.setAttribute("usuario.senha", this.senha);
    sessao.setAttribute("usuario.ativo", this.ativo);
    sessao.setAttribute("usuario.nomeFilial", this.nomeFilial);
    sessao.setAttribute("usuario.nomeDepartamento", this.nomeDepartamento);
  }
  
  public void getSession(HttpServletRequest request) {
    
    HttpSession sessao = request.getSession();
    
    this.idUsuario = (int) sessao.getAttribute("usuario.idUsuario");
    this.idDepartamento = (int) sessao.getAttribute("usuario.idDepartamento");
    this.idFilial = (int) sessao.getAttribute("usuario.idFilial");
    this.nome = (String) sessao.getAttribute("usuario.nome");
    this.email = (String) sessao.getAttribute("usuario.email");
    this.senha = (String) sessao.getAttribute("usuario.senha");
    this.ativo = (boolean) sessao.getAttribute("usuario.ativo");
    this.nomeFilial = (String) sessao.getAttribute("usuario.nomeFilial");
    this.nomeDepartamento = (String) sessao.getAttribute("usuario.nomeDepartamento");
  }
  
  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public int getIdDepartamento() {
    return idDepartamento;
  }

  public void setIdDepartamento(int idDepartamento) {
    this.idDepartamento = idDepartamento;
  }

  public int getIdFilial() {
    return idFilial;
  }

  public void setIdFilial(int idFilial) {
    this.idFilial = idFilial;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
  
  public String getNomeFilial() {
    return nomeFilial;
  }

  public void setNomeFilial(String nomeFilial) {
    this.nomeFilial = nomeFilial;
  }

  public String getNomeDepartamento() {
    return nomeDepartamento;
  }

  public void setNomeDepartamento(String nomeDepartamento) {
    this.nomeDepartamento = nomeDepartamento;
  }
}
