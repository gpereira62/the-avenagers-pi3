/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Aluguel;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import br.senac.tads.pi3.gerenprod.model.ClienteFisico;
import br.senac.tads.pi3.gerenprod.model.ClienteJuridico;
import br.senac.tads.pi3.gerenprod.model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class AluguelDAO implements CrudInterface<Aluguel> {

  public Aluguel mostrarFisico(int ID) {
    DB db = new DB(true);
    try {
      String sql = "select clienteFisico.*, aluguel.*, produto.* from clienteFisico inner join aluguel on aluguel.idClienteFisico = clienteFisico.idClienteFisico inner join produto on produto.idProduto = aluguel.idProduto where clienteFisico.idClienteFisico = " + ID + ";";
      ResultSet rs = db.executarConsulta(sql);
      Produto p = new Produto();
      Aluguel a = new Aluguel();
      Cliente c = new Cliente();
      ClienteFisico f = new ClienteFisico();
      while (rs.next()) {
        p.setIdProduto(rs.getInt("idProduto"));
        p.setNomeProduto(rs.getString("NomeProduto"));
        p.setAno(rs.getString("Ano"));
        p.setIdioma(rs.getString("Idioma"));
        p.setAutor(rs.getString("Autor"));
        p.setEditora(rs.getString("Editora"));
        p.setNumeroPagina(rs.getString("NumeroPagina"));
        p.setPrecoDiaria(rs.getDouble("PrecoDiaria"));
        p.setAlugado(rs.getBoolean("Alugado"));
        p.setAtivo(rs.getBoolean("Ativo"));
        
        c.setIdCliente(rs.getInt("idClienteFisico"));
        c.setNomeCliente(rs.getString("Nome"));
        f.setCpf(rs.getString("CPF"));
        c.setEmail(rs.getString("Email"));
        c.setTelefone(rs.getString("Telefone"));
        c.setCep(rs.getString("CEP"));
        c.setRua(rs.getString("Rua"));
        c.setBairro(rs.getString("Bairro"));
        c.setCidade(rs.getString("Cidade"));
        c.setEstado(rs.getString("Estado"));
        c.setAtivo(rs.getBoolean("Ativo"));
        
        a.setIdAluguel(rs.getInt("idAluguel"));
        a.setDataInicial(rs.getDate("Datainicial"));
        a.setIdCliente(rs.getInt("idClienteFisico"));
        a.setIdProduto(rs.getInt("idProduto"));
        a.setIdFilial(rs.getInt("idFilial"));
        a.setCliente(c);
        a.setProduto(p);
      }
      db.close();
      return a;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      db.close();
      return null;
    }
  }

  public Aluguel mostrarJuridico(int ID) {
    DB db = new DB(true);
    try {
      String sql = "select clienteJuridico.*, aluguel.*, produto.* from clienteJuridico inner join aluguel on aluguel.idClienteJuridico = clienteJuridico.idClienteJuridico inner join produto on produto.idProduto = aluguel.idProduto where clienteJuridico.idClienteJuridico = " + ID + ";";
      ResultSet rs = db.executarConsulta(sql);
      Produto p = new Produto();
      Aluguel a = new Aluguel();
      Cliente c = new Cliente();
      ClienteJuridico j = new ClienteJuridico();
      while (rs.next()) {
        p.setIdProduto(rs.getInt("idProduto"));
        p.setNomeProduto(rs.getString("NomeProduto"));
        p.setAno(rs.getString("Ano"));
        p.setIdioma(rs.getString("Idioma"));
        p.setAutor(rs.getString("Autor"));
        p.setEditora(rs.getString("Editora"));
        p.setNumeroPagina(rs.getString("NumeroPagina"));
        p.setPrecoDiaria(rs.getDouble("PrecoDiaria"));
        p.setAlugado(rs.getBoolean("Alugado"));
        p.setAtivo(rs.getBoolean("Ativo"));
        
        c.setIdCliente(rs.getInt("idClienteJuridico"));
        c.setNomeCliente(rs.getString("Nome"));
        j.setCnpj(rs.getString("CNPJ"));
        c.setEmail(rs.getString("Email"));
        c.setTelefone(rs.getString("Telefone"));
        c.setCep(rs.getString("CEP"));
        c.setRua(rs.getString("Rua"));
        c.setBairro(rs.getString("Bairro"));
        c.setCidade(rs.getString("Cidade"));
        c.setEstado(rs.getString("Estado"));
        c.setAtivo(rs.getBoolean("Ativo"));
        
        a.setIdAluguel(rs.getInt("idAluguel"));
        a.setDataInicial(rs.getDate("Datainicial"));
        a.setIdCliente(rs.getInt("idClienteJuridico"));
        a.setIdProduto(rs.getInt("idProduto"));
        a.setIdFilial(rs.getInt("idFilial"));
        a.setCliente(c);
        a.setProduto(p);
      }
      db.close();
      return a;
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      db.close();
      return null;
    }
  }
  
  @Override
  public boolean editar(Aluguel objeto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public boolean salvarFisico(Aluguel a) {
    DB db = new DB(false);

    try {

      String pattern = "yyyy-MM-dd";
      DateFormat df = new SimpleDateFormat(pattern);

      String sql
        = "INSERT INTO aluguel "
        + "(DataInicial, idClienteFisico, idFilial, idProduto)"
        + "VALUES ("
        + "'" + df.format(a.getDataInicial()) + "', "
        + a.getIdCliente() + ", "
        + a.getIdFilial() + ", "
        + a.getIdProduto() + ");";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
      }

      sql
        = "UPDATE produto SET "
        + "Alugado = 1 "
        + "Where idProduto = " + a.getIdProduto() + ";";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
      }
      
      sql
        = "UPDATE ClienteFisico SET "
        + "Alugando = 1 "
        + "Where idClienteFisico = " + a.getIdCliente()+ ";";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
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
  
  public boolean salvarJuridico(Aluguel a) {
    DB db = new DB(false);

    try {

      String pattern = "yyyy-MM-dd";
      DateFormat df = new SimpleDateFormat(pattern);

      String sql
        = "INSERT INTO aluguel "
        + "(DataInicial, idClienteJuridico, idFilial, idProduto)"
        + "VALUES ("
        + "'" + df.format(a.getDataInicial()) + "', "
        + a.getIdCliente() + ", "
        + a.getIdFilial() + ", "
        + a.getIdProduto() + ");";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
      }

      sql
        = "UPDATE produto SET "
        + "Alugado = 1 "
        + "Where idProduto = " + a.getIdProduto() + ";";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
      }
      
      sql
        = "UPDATE ClienteJuridico SET "
        + "Alugando = 1 "
        + "Where idClienteJuridico = " + a.getIdCliente()+ ";";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel cadastrar o aluguel.");
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

  public boolean devolverFisico(Aluguel a) {
    DB db = new DB(false);

    try {

      String pattern = "yyyy-MM-dd";
      DateFormat df = new SimpleDateFormat(pattern);

      String sql
        = "UPDATE aluguel SET "
        + "DataFinal = '" + df.format(a.getDataFinal()) + "', "
        + "ValorTotal = " + a.getPrecoTotal() + " "
        + "Where idAluguel = " + a.getIdAluguel()+ ";";
      
      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
      }

      sql
        = "UPDATE produto SET "
        + "Alugado = 0 "
        + "Where idProduto = " + a.getIdProduto() + ";";

      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
      }
      
      sql
        = "UPDATE clienteFisico SET "
        + "Alugando = 0 "
        + "Where idClienteFisico = " + a.getIdCliente()+ ";";

      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
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
  
    public boolean devolverJuridico(Aluguel a) {
    DB db = new DB(false);

    try {

      String pattern = "yyyy-MM-dd";
      DateFormat df = new SimpleDateFormat(pattern);

      String sql
        = "UPDATE aluguel SET "
        + "DataFinal = '" + df.format(a.getDataFinal()) + "', "
        + "ValorTotal = " + a.getPrecoTotal() + " "
        + "Where idAluguel = " + a.getIdAluguel()+ ";";
      
      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
      }

      sql
        = "UPDATE produto SET "
        + "Alugado = 0 "
        + "Where idProduto = " + a.getIdProduto() + ";";

      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
      }
      
      sql
        = "UPDATE clienteJuridico SET "
        + "Alugando = 0 "
        + "Where idClienteJuridico = " + a.getIdCliente()+ ";";

      System.out.println(sql);
      
      if (!db.executarAlteracao(sql)) {
        throw new Exception("Não foi possivel devolver o produto.");
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
  public boolean desativar(int ID) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ArrayList<Aluguel> listar(int idFilial) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

    @Override
    public Aluguel mostrar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvar(Aluguel objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
