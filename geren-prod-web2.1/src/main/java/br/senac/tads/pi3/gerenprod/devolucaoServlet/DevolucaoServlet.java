/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.devolucaoServlet;

import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.model.Cliente;
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
@WebServlet(name = "DevolucaoServlet", urlPatterns = {"/devolucao"})
public class DevolucaoServlet extends HttpServlet {

  private final CrudInterface clienteDAO = new ClienteDAO();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);
    
    if(!u.acessaDevolucao()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
    ArrayList<Cliente> clientes = clienteDAO.listar(u.getIdFilial());
    
    request.setAttribute("clientes", clientes);
    request.getRequestDispatcher("/devolucao.jsp").forward(request, response);
  }
}
