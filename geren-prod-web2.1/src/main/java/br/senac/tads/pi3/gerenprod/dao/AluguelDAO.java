/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Aluguel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class AluguelDAO implements CrudInterface<Aluguel> {

  @Override
  public Aluguel mostrar(int ID) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean editar(Aluguel objeto) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean salvar(Aluguel a) {
    DB db = new DB(false);

    try {

      String pattern = "yyyy-MM-dd";
      DateFormat df = new SimpleDateFormat(pattern);

      String sql
        = "INSERT INTO aluguel "
        + "(DataInicial, idCliente, idFilial, idProduto)"
        + "VALUES ("
        + "'" + df.format(a.getDataInicial()) + "', "
        + a.getIdCliente() + ", "
        + a.getIdFilial() + ", "
        + a.getIdProduto() + ");";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("N�o foi possivel cadastrar o aluguel.");
      }

      sql
        = "UPDATE produto SET "
        + "Alugado = 1 "
        + "Where idProduto = " + a.getIdProduto() + ";";

      if (!db.executarAlteracao(sql)) {
        throw new Exception("N�o foi possivel cadastrar o aluguel.");
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
    return false;
  }

  @Override
  public ArrayList<Aluguel> listar(int idFilial) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
