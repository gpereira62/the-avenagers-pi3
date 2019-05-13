/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Relatorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mac-ale
 */
public abstract class RelatorioDAO implements CrudInterface<Relatorio> {

    @Override
    public ArrayList<Relatorio> listar(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT\n"
                    + "idAluguel,\n"
                    + "Nome,\n"
                    + "nomeProduto,\n"
                    + "precoDiaria,\n"
                    + "valorTotal\n"
                    + "FROM Aluguel\n"
                    + "INNER JOIN Cliente ON Cliente.idCliente = Aluguel.idCliente\n"
                    + "INNER JOIN Produto ON Produto.idProduto = Aluguel.idProduto";

            ResultSet rs = db.executarConsulta(sql);
            
            ArrayList<Relatorio> relatorios = new ArrayList<>();
            while (rs.next()) {
                Relatorio relat = new Relatorio();
                relat.setIdAluguel(rs.getInt("idAluguel"));
                relat.setNomeCliente(rs.getString("Nome"));
                relat.setNomeProduto(rs.getString("nomeProduto"));
                relat.setPrecoDiaria(rs.getDouble("precoDiaria"));
                relat.setValorTotal(rs.getDouble("valorTotal"));
                relatorios.add(relat);
            }

            db.close();
            return relatorios;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }

    @Override
    public Relatorio mostrar(int ID) {
        DB db = new DB(true);
        try {
            String sql = "SELECT\n"
                    + "idAluguel,\n"
                    + "Nome,\n"
                    + "NomeProduto,\n"
                    + "PrecoDiaria,\n"
                    + "ValorTotal\n"
                    + "FROM Aluguel\n"
                    + "INNER JOIN Cliente ON Cliente.idCliente = Aluguel.idCliente\n"
                    + "INNER JOIN Produto ON Produto.idProduto = Aluguel.idProduto";

            ResultSet rs = db.executarConsulta(sql);
            Relatorio relat = new Relatorio();
            while (rs.next()) {
                relat.setIdAluguel(rs.getInt("idAluguel"));
                relat.setNomeCliente(rs.getString("Nome"));
                relat.setPrecoDiaria(rs.getDouble("PrecoDiaria"));
                relat.setValorTotal(rs.getDouble("ValorTotal"));
            }

            db.close();
            return relat;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }

    @Override
    public boolean editar(Relatorio objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvar(Relatorio objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
