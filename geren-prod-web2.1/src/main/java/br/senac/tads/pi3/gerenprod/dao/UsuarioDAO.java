/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class UsuarioDAO implements CrudInterface<Usuario> {

  public Usuario login (Usuario usuario) {
    DB db = new DB(true);
    try {
      
      String sql = "select usuario.idUsuario, usuario.NomeUsuario, usuario.Email, usuario.Senha, usuario.Ativo, usuario.idDepartamento, departamento.NomeDepartamento, usuario.idFilial, filial.NomeFilial from usuario inner join departamento on departamento.idDepartamento = usuario.idDepartamento inner join filial on filial.idFilial = usuario.idFilial "
                 + "where usuario.Email = '" + usuario.getEmail() + "' and usuario.Senha = '" + usuario.getSenha() + "' and usuario.Ativo = true;";
      
      ResultSet rs = db.executarConsulta(sql) != null ? db.executarConsulta(sql) : null;
      
      if(rs == null) {
        return usuario;
      }
      
      while (rs.next()) {
        usuario = new Usuario();
        usuario.setIdUsuario(rs.getInt("idUsuario"));
        usuario.setNome(rs.getString("NomeUsuario"));
        usuario.setEmail(rs.getString("Email"));
        usuario.setSenha(rs.getString("Senha"));
        usuario.setAtivo(rs.getBoolean("Ativo"));
        usuario.setIdDepartamento(rs.getInt("idDepartamento"));
        usuario.setIdFilial(rs.getInt("idFilial"));
        usuario.setNomeDepartamento(rs.getString("NomeDepartamento"));
        usuario.setNomeFilial(rs.getString("NomeFilial"));
      }
      db.close();
      
      return usuario;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      db.close();
      return null;
    }
  }

  @Override
  public ArrayList<Usuario> listar(int idFilial) {
    DB db = new DB(true);
    try {
      String sql = "SELECT * FROM produto WHERE idFilial = " + idFilial + " AND Ativo = true;";
      ResultSet rs = db.executarConsulta(sql);
      ArrayList<Usuario> usuario = new ArrayList<>();
      while (rs.next()) {
        Usuario u = new Usuario();
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNome(rs.getString("NomeUsuario"));
        u.setEmail(rs.getString("Email"));
        u.setSenha(rs.getString("Senha"));
        usuario.add(u);
      }
      db.close();
      return usuario;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      db.close();
      return null;
    }
  }
  
  @Override
  public Usuario mostrar(int idUsuario) {
    DB db = new DB(true);
    try {
      String sql = "SELECT * FROM produto WHERE idProduto = " + idUsuario + ";";
      ResultSet rs = db.executarConsulta(sql);
      Usuario u = new Usuario();
      while (rs.next()) {
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNome(rs.getString("NomeUsuario"));
        u.setEmail(rs.getString("Email"));
        u.setSenha(rs.getString("Senha"));
      }
      db.close();
      return u;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      db.close();
      return null;
    }
  }

  @Override
  public boolean editar(Usuario u) {
    DB db = new DB(false);

    try {

      String sql
              = "UPDATE produto SET "
              + "NomeProduto = '" + u.getNome() + "', "
              + "Ano = '" + u.getEmail() + "', "
              + "Modelo = '" + u.getSenha() + "', "
              + "Where idUsuario = " + u.getIdUsuario() + "; ";
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("N�o foi pons�vel atualizar o usuario.");
      }

      db.commit();
      db.close();
      return true;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      db.rollback();
      db.close();
      return false;
    }
  }

  @Override
  public boolean salvar(Usuario u) {
    DB db = new DB(false);

    try {

      String sql
              = "INSERT INTO produto "
              + "(NomeUsuario, Email, Senha, idFilial, Ativo)"
              + "VALUES ("
              + "'" + u.getNome() + "', "
              + "'" + u.getEmail() + "', "
              + "'" + u.getSenha() + "', "
              + u.getIdFilial() + ", "
              + "true );";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("N�o foi poss�vel cadastrar o produto.");
      }

      db.commit();
      db.close();
      return true;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      db.rollback();
      db.close();
      return false;
    }
  }

  @Override
  public boolean desativar(int usuarioID) {
    DB db = new DB(false);

    try {

      String sql
              = "UPDATE produto SET "
              + "Ativo = false "
              + "Where idProduto = " + usuarioID + "; ";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("N�o foi poss�vel desativar o usu�rio.");
      }

      db.commit();
      db.close();
      return true;

    } catch (Exception e) {
      System.out.println(e.getMessage());
      db.rollback();
      db.close();
      return false;
    }
  }
}