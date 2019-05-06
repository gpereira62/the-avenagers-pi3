/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.aluguelServlet;

import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDAO;
import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import br.senac.tads.pi3.gerenprod.model.Produto;
import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
@WebServlet(name = "AluguelServlet", urlPatterns = {"/aluguel"})
public class AluguelServlet extends HttpServlet {

      private final CrudInterface ProdutoDAO = new ProdutoDAO();
      private final CrudInterface ClienteDAO = new ClienteDAO();
    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
    Usuario u = new Usuario(request);
    
    if(!u.acessaAluguel()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
      ArrayList<Produto> produtos = ProdutoDAO.listar(1);
      request.setAttribute("produtos", produtos);
      ArrayList<Cliente> clientes = ClienteDAO.listar(1);
      request.setAttribute("clientes", clientes);
      
      request.getRequestDispatcher("/aluguel.jsp").forward(request, response);
  }
  
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
        
    
    }
}
