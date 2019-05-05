/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.clienteServlet;

import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bruna
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario();
    u.getSession(request);
    boolean acesso = u.temAcesso("cliente");
    
    if(!acesso) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
    request.getRequestDispatcher("/cliente.jsp").forward(request, response);
  }
}
