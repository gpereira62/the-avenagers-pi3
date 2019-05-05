/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.produtoServlet;

import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDAO;
import br.senac.tads.pi3.gerenprod.model.Produto;
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
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produto"})
public class ProdutoServlet extends HttpServlet {

  private final CrudInterface produtoDAO = new ProdutoDAO();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    ArrayList<ProdutoServlet> produtos = produtoDAO.listar(1);
    
    request.setAttribute("produtos", produtos);
    request.getRequestDispatcher("/produto.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Produto p = new Produto();
    
    p.setNomeProduto(request.getParameter("nomeProduto"));
    p.setAno(request.getParameter("ano"));
    p.setModelo(request.getParameter("modelo"));
    p.setMarca(request.getParameter("marca"));
    p.setPlaca(request.getParameter("placa"));
    p.setPrecoDiaria(Double.parseDouble(request.getParameter("precoDiaria")));
    p.setIdFilial(1);

    boolean sucesso = produtoDAO.salvar(p);
    request.setAttribute("sucesso", sucesso);
    
    if (sucesso) {
      request.setAttribute("mensagem", "Produto cadastrado com sucesso!");
    } else {
      request.setAttribute("mensagem", "N�o foi poss�vel cadastrar o produto. Por favor, tente novamente!");
    }
    
    ArrayList<ProdutoServlet> produtos = produtoDAO.listar(1);
    request.setAttribute("produtos", produtos);
    request.getRequestDispatcher("/produto.jsp").forward(request, response);
  }
}
