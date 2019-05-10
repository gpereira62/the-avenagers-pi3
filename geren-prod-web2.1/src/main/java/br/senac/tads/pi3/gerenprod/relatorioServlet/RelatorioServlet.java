/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.relatorioServlet;

import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.RelatorioDAO;
import br.senac.tads.pi3.gerenprod.model.Relatorio;
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
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/relatorio"})
public class RelatorioServlet extends HttpServlet {
  private final CrudInterface RelatorioDAO = new RelatorioDAO() {};
    
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);
    
    if(!u.acessaRelatorio()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    ArrayList<Relatorio> relatorios = RelatorioDAO.listar(1);

    request.setAttribute("relatorios", relatorios);
    request.getRequestDispatcher("/relatorio.jsp").forward(request, response);
  }
}
