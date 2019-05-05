/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.administracaoServlet;

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
@WebServlet(name = "AdministracaoServlet", urlPatterns = {"/administracao"})
public class AdministracaoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);
    
    if(!u.acessaAdministracao()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
    request.getRequestDispatcher("/administracao.jsp").forward(request, response);

  }

}
