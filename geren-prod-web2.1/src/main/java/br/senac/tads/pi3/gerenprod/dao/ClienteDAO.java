/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.dao;

import br.senac.tads.pi3.gerenprod.db.DB;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import br.senac.tads.pi3.gerenprod.model.ClienteFisico;
import br.senac.tads.pi3.gerenprod.model.ClienteJuridico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Felippe
 */
public class ClienteDAO implements CrudInterface<Cliente> {

    public ArrayList<Cliente> listarFisico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteFisico WHERE Ativo = true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteFisico f = new ClienteFisico();
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
    
    public ArrayList<Cliente> listarJuridico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteJuridico WHERE Ativo = true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteJuridico j = new ClienteJuridico();
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
    
    public ArrayList<Cliente> listarAlugandoFisico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteFisico WHERE Ativo = true AND alugando is true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteFisico f = new ClienteFisico();
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
    
        public ArrayList<Cliente> listarAlugandoJuridico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteJuridico WHERE Ativo = true AND alugando is true;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteJuridico j = new ClienteJuridico();
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

    public ArrayList<Cliente> listarNaoAlugandoJuridico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteJuridico WHERE Ativo = true AND alugando is false;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteJuridico j = new ClienteJuridico();
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
    
        public ArrayList<Cliente> listarNaoAlugandoFisico(int idFilial) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteFisico WHERE Ativo = true AND alugando is false;";
            ResultSet rs = db.executarConsulta(sql);
            ArrayList<Cliente> clientes = new ArrayList();
            while (rs.next()) {
                Cliente c = new Cliente();
                ClienteFisico f = new ClienteFisico();
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
    
    public Cliente mostrarJuridico(int idCliente) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteJuridico WHERE idClienteJuridico = " + idCliente + ";";
            ResultSet rs = db.executarConsulta(sql);
            Cliente c = new Cliente();
            ClienteJuridico j = new ClienteJuridico();
            while (rs.next()) {
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
            }
            db.close();
            return c;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }
    
        public Cliente mostrarFisico(int idCliente) {
        DB db = new DB(true);
        try {
            String sql = "SELECT * FROM clienteFisico WHERE idClienteFisico = " + idCliente + ";";
            ResultSet rs = db.executarConsulta(sql);
            Cliente c = new Cliente();
            ClienteFisico f = new ClienteFisico();
            while (rs.next()) {
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
            }
            db.close();
            return c;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            db.close();
            return null;
        }
    }

    public boolean editarFisico(Cliente c, ClienteFisico f) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE clienteFisico SET "
                    + "Nome = '" + c.getNomeCliente() + "', "
                    + "CPF = '" + f.getCpf() + "', "
                    + "Email = '" + c.getEmail() + "', "
                    + "Telefone = '" + c.getTelefone() + "', "
                    + "CEP = '" + c.getCep() + "', "
                    + "Rua = '" + c.getRua() + "', "
                    + "Bairro = '" + c.getBairro() + "', "
                    + "Cidade = '" + c.getCidade() + "', "
                    + "Estado = '" + c.getEstado() + "' "
                    + "Where idClienteFisico = " + c.getIdCliente() + "; ";

            System.out.println(sql);
            
            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel atualizar o cliente.");
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
    
    public boolean editarJuridico(Cliente c, ClienteJuridico j) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE clienteJuridico SET "
                    + "Nome = '" + c.getNomeCliente() + "', "
                    + "CNPJ = '" + j.getCnpj()+ "', "
                    + "Email = '" + c.getEmail() + "', "
                    + "Telefone = '" + c.getTelefone() + "', "
                    + "CEP = '" + c.getCep() + "', "
                    + "Rua = '" + c.getRua() + "', "
                    + "Bairro = '" + c.getBairro() + "', "
                    + "Cidade = '" + c.getCidade() + "', "
                    + "Estado = '" + c.getEstado() + "' "
                    + "Where idClienteJuridico = " + c.getIdCliente() + "; ";

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

    public boolean salvarFisico(Cliente c, ClienteFisico f) {
        DB db = new DB(false);

        try {

            String sql
                    = "INSERT INTO clienteFisico "
                    + "(Nome, CPF, Email, Telefone, CEP, Rua, Bairro, Cidade, Estado, Ativo)"
                    + "VALUES ("
                    + "'" + c.getNomeCliente() + "', "
                    + "'" + f.getCpf() + "', "
                    + "'" + c.getEmail() + "', "
                    + "'" + c.getTelefone()+ "', "
                    + "'" + c.getCep() + "', "
                    + "'" + c.getRua() + "', "
                    + "'" + c.getBairro() + "', "
                    + "'" + c.getCidade() + "', "
                    + "'" + c.getEstado() + "', "
                    + "true );";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel cadastrar o cliente.");
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
    
    public boolean salvarJuridico(Cliente c, ClienteJuridico j) {
        DB db = new DB(false);

        try {

            String sql
                    = "INSERT INTO clienteJuridico "
                    + "(Nome, CNPJ, Email, CNH, Telefone, CEP, Rua, Bairro, Cidade, Estado, Ativo)"
                    + "VALUES ("
                    + "'" + c.getNomeCliente() + "', "
                    + "'" + j.getCnpj()+ "', "
                    + "'" + c.getEmail() + "', "
                    + "'" + c.getTelefone()+ "', "
                    + "'" + c.getCep() + "', "
                    + "'" + c.getRua() + "', "
                    + "'" + c.getBairro() + "', "
                    + "'" + c.getCidade() + "', "
                    + "'" + c.getEstado() + "', "
                    + "true );";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel cadastrar o cliente.");
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

    public boolean desativarFisico(int clienteID) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE clienteFisico SET "
                    + "Ativo = false "
                    + "Where idClienteFisico = " + clienteID + "; ";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel desativar o cliente.");
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
    
    public boolean desativarJuridico(int clienteID) {
        DB db = new DB(false);

        try {

            String sql
                    = "UPDATE clienteJuridico SET "
                    + "Ativo = false "
                    + "Where idClienteJuridico = " + clienteID + "; ";

            if (!db.executarAlteracao(sql)) {
                throw new Exception("Não foi possivel desativar o cliente.");
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
    public ArrayList<Cliente> listar(int idFilial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente mostrar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean salvar(Cliente objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean desativar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
