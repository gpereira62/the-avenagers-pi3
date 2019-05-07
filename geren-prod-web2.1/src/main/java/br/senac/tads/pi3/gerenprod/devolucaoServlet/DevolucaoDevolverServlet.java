/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.devolucaoServlet;

import br.senac.tads.pi3.gerenprod.dao.AluguelDAO;
import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.model.Aluguel;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
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
@WebServlet(name = "DevolucaoDevolverServlet", urlPatterns = {"/devolucao/devolver"})
public class DevolucaoDevolverServlet extends HttpServlet {

  private final ClienteDAO clienteDAO = new ClienteDAO();
  private final AluguelDAO aluguelDAO = new AluguelDAO();
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);

    if (!u.acessaAluguel()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }

    Aluguel a = new Aluguel();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    try {
      a.setDataInicial(formato.parse(request.getParameter("dataRetirada")));
      a.setDataFinal(formato.parse(request.getParameter("date")));
    } catch (ParseException ex) {
      request.setAttribute("mensagem", "Não foi possível realizar a devolução. Por favor, tente novamente!");
    }

    a.setIdAluguel(Integer.parseInt(request.getParameter("idAluguel")));
    a.setIdCliente(Integer.parseInt(request.getParameter("idClienteSelecionado")));
    a.setIdProduto(Integer.parseInt(request.getParameter("idProdutoSelecionado")));
    
    double precoDiaria = Double.parseDouble(request.getParameter("precoDiaria"));
    long quantidadeDias = DAYS.between(LocalDate.parse(request.getParameter("dataRetirada")), LocalDate.parse(request.getParameter("date")));
    
    double total = (double)quantidadeDias * precoDiaria;
    
    a.setPrecoTotal(total);
    
    boolean sucesso = aluguelDAO.salvar(a);
    request.setAttribute("sucesso", sucesso);

    if (sucesso) {
      request.setAttribute("mensagem", "Devolução realizada com sucesso!");
    } else {
      request.setAttribute("mensagem", "Não foi possível realizar a devolução. Por favor, tente novamente!");
    }

    ArrayList<Cliente> clientes = clienteDAO.listarAlugando(u.getIdFilial());
    
    request.setAttribute("clientes", clientes);
    request.getRequestDispatcher("/aluguel.jsp").forward(request, response);
  }

}
