/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.aluguelServlet;

import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDAO;
import br.senac.tads.pi3.gerenprod.model.Cliente;
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
 * @author Gustavo
 */

@WebServlet(name = "ClienteProdutoSelecionadoServlet", urlPatterns = {"/aluguel/selecionar"})
public class ClienteProdutoSelecionadoServlet extends HttpServlet {

    private final CrudInterface ClienteDAO = new ClienteDAO();
    private final CrudInterface ProdutoDAO = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArrayList<Produto> produtos = ProdutoDAO.listar(1);
        request.setAttribute("produtos", produtos);
        ArrayList<Cliente> clientes = ClienteDAO.listar(1);
        request.setAttribute("clientes", clientes);
        
        String idClienteTela = request.getParameter("idCliente");

        if (idClienteTela != "") {
            int idCliente = Integer.parseInt(idClienteTela);
            Cliente clienteSelecionado = (Cliente) ClienteDAO.mostrar(idCliente);
            request.setAttribute("clienteSelecionado", clienteSelecionado);
        }
        
        String idProdutoTela = request.getParameter("idProduto");
        
        if (idProdutoTela != "") {
            int idProduto = Integer.parseInt(idProdutoTela);
            Produto produtoSelecionado = (Produto) ProdutoDAO.mostrar(idProduto);
            request.setAttribute("produtoSelecionado", produtoSelecionado);
        }

        request.getRequestDispatcher("/aluguel.jsp").forward(request, response);
    }
    
    @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
  }

}
