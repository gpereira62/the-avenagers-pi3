/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Felippe
 */
public class ClienteDAO implements CrudInterface<Cliente> {

    @Override
    public ArrayList<Cliente> listar(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM cliente WHERE Ativo = true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("Nome"));
                c.setCpf(rs.getString("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setCnh(rs.getString("CNH"));
                c.setTelefone(rs.getString("Telefone"));
                c.setCep(rs.getString("CEP"));
                c.setRua(rs.getString("Rua"));
                c.setBairro(rs.getString("Bairro"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setAtivo(rs.getBoolean("Ativo"));
                clientes.add(c);
            }
            db.close();
            return clientes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }
    
    public ArrayList<Cliente> listarAlugando(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM cliente WHERE Ativo = true AND alugando is true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("Nome"));
                c.setCpf(rs.getString("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setCnh(rs.getString("CNH"));
                c.setTelefone(rs.getString("Telefone"));
                c.setCep(rs.getString("CEP"));
                c.setRua(rs.getString("Rua"));
                c.setBairro(rs.getString("Bairro"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setAtivo(rs.getBoolean("Ativo"));
                clientes.add(c);
            }
            db.close();
            return clientes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }

    public ArrayList<Cliente> listarNaoAlugando(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM cliente WHERE Ativo = true AND alugando is false;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("Nome"));
                c.setCpf(rs.getString("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setCnh(rs.getString("CNH"));
                c.setTelefone(rs.getString("Telefone"));
                c.setCep(rs.getString("CEP"));
                c.setRua(rs.getString("Rua"));
                c.setBairro(rs.getString("Bairro"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setAtivo(rs.getBoolean("Ativo"));
                clientes.add(c);
            }
            db.close();
            return clientes;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }
    
    @Override
    public Cliente mostrar(int idCliente) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM cliente WHERE idCliente = " + idCliente + ";";
            ResultSet rs = db.executarConsulta(sql);
            Cliente c = new Cliente();
            while (rs.next()) {
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNomeCliente(rs.getString("Nome"));
                c.setCpf(rs.getString("CPF"));
                c.setEmail(rs.getString("Email"));
                c.setCnh(rs.getString("CNH"));
                c.setTelefone(rs.getString("Telefone"));
                c.setCep(rs.getString("CEP"));
                c.setRua(rs.getString("Rua"));
                c.setBairro(rs.getString("Bairro"));
                c.setCidade(rs.getString("Cidade"));
                c.setEstado(rs.getString("Estado"));
                c.setAtivo(rs.getBoolean("Ativo"));
            }
            db.close();
            return c;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }

    @Override
    public boolean editar(Cliente c) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE cliente SET "
                    + "Nome = '" + c.getNomeCliente() + "', "
                    + "CPF = '" + c.getCpf() + "', "
                    + "Email = '" + c.getEmail() + "', "
                    + "CNH = '" + c.getCnh() + "', "
                    + "Telefone = '" + c.getTelefone() + "', "
                    + "CEP = '" + c.getCep() + "', "
                    + "Rua = '" + c.getRua() + "', "
                    + "Bairro = '" + c.getBairro() + "', "
                    + "Cidade = '" + c.getCidade() + "', "
                    + "Estado = '" + c.getEstado() + "' "
                    + "Where idCliente = " + c.getIdCliente() + "; ";

            System.out.println(sql);
            
            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel atualizar o produto.");
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
    public boolean salvar(Cliente c) {
        DB db = new DB(false);

        try {

            String sql
                    = "INSERT INTO cliente "
                    + "(Nome, CPF, Email, CNH, Telefone, CEP, Rua, Bairro, Cidade, Estado, Ativo)"
                    + "VALUES ("
                    + "'" + c.getNomeCliente() + "', "
                    + "'" + c.getCpf() + "', "
                    + "'" + c.getEmail() + "', "
                    + "'" + c.getCnh() + "', "
                    + "'" + c.getTelefone()+ "', "
                    + "'" + c.getCep() + "', "
                    + "'" + c.getRua() + "', "
                    + "'" + c.getBairro() + "', "
                    + "'" + c.getCidade() + "', "
                    + "'" + c.getEstado() + "', "
                    + "true );";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel cadastrar o produto.");
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
    public boolean desativar(int clienteID) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE cliente SET "
                    + "Ativo = false "
                    + "Where idCliente = " + clienteID + "; ";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel desativar o produto.");
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
