/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.aluguelServlet;

import br.senac.tads.pi3.gerenprod.dao.AluguelDAO;
import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDAO;
import br.senac.tads.pi3.gerenprod.model.Aluguel;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import br.senac.tads.pi3.gerenprod.model.Produto;
import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final CrudInterface AluguelDAO = new AluguelDAO();

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
        
        String idClienteTela = request.getParameter("idCliente");

        if (!idClienteTela.equals("")) {
            int idCliente = Integer.parseInt(idClienteTela);
            Cliente clienteSelecionado = (Cliente) ClienteDAO.mostrar(idCliente);
            request.setAttribute("clienteSelecionado", clienteSelecionado);
        }
        
        String idProdutoTela = request.getParameter("idProduto");
        
        if (!idProdutoTela.equals("")) {
            int idProduto = Integer.parseInt(idProdutoTela);
            Produto produtoSelecionado = (Produto) ProdutoDAO.mostrar(idProduto);
            request.setAttribute("produtoSelecionado", produtoSelecionado);
        }

        request.getRequestDispatcher("/aluguel.jsp").forward(request, response);
    }
    
    @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Usuario u = new Usuario(request);
    
    if(!u.acessaAluguel()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
      
    Aluguel a = new Aluguel();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    try {
        a.setDataInicial(formato.parse(request.getParameter("date")));
    } catch (ParseException ex) {
        Logger.getLogger(ClienteProdutoSelecionadoServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    a.setIdCliente(Integer.parseInt(request.getParameter("idClienteSelecionado")));
    a.setIdFilial(u.getIdFilial());
    a.setIdProduto(Integer.parseInt(request.getParameter("idProdutoSelecionado")));

    boolean sucesso = AluguelDAO.salvar(a);
    request.setAttribute("sucesso", sucesso);
    
    if (sucesso) {
      request.setAttribute("mensagem", "Aluguel feito com sucesso!");
    } else {
      request.setAttribute("mensagem", "N�o foi poss�vel fazer o aluguel. Por favor, tente novamente!");
    }
    
    ArrayList<Produto> produtos = ProdutoDAO.listar(1);
    request.setAttribute("produtos", produtos);
    ArrayList<Cliente> clientes = ClienteDAO.listar(1);
    request.setAttribute("clientes", clientes);
    
    request.getRequestDispatcher("/aluguel.jsp").forward(request, response);
  }

}
