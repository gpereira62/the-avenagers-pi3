package br.senac.tads.pi3.gerenprod.clienteServlet;

import br.senac.tads.pi3.gerenprod.dao.ClienteDAO;
import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author felip
 */
@WebServlet(name = "ClienteEditarServlet", urlPatterns = {"/cliente/editar"})
public class ClienteEditarServlet extends HttpServlet {

  private final CrudInterface clienteDAO = new ClienteDAO();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    String id = request.getParameter("idCliente");
    
    if (id != null) {
      int idProduto = Integer.parseInt(id);
      Cliente cliente = (Cliente) clienteDAO.mostrar(1);
      request.setAttribute("cliente", cliente);
    }
    
    ArrayList<ClienteServlet> cliente = clienteDAO.listar(1);
    
    request.setAttribute("cliente", cliente);
    request.getRequestDispatcher("/cliente.jsp").forward(request, response);
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
      Cliente c = new Cliente();
    
    c.setNomeCliente(request.getParameter("nomeCliente"));
    c.setCpf(request.getParameter("cpf"));
    c.setEmail(request.getParameter("email"));
    c.setCnh(request.getParameter("cnh"));
    c.setTelefone(request.getParameter("telefone"));
    c.setCep(request.getParameter("cep"));
    c.setRua(request.getParameter("rua"));
    c.setBairro(request.getParameter("bairro"));
    c.setCidade(request.getParameter("cidade"));
    c.setEstado(request.getParameter("estado"));
    

    boolean sucesso = clienteDAO.editar(c);
    request.setAttribute("sucesso", sucesso);
    
    if (sucesso) {
      request.setAttribute("mensagem", "Cliente alterado com sucesso!");
    } else {
      request.setAttribute("mensagem", "Não foi possível alterar o Cliente. Por favor, tente novamente!");
    }
    
    ArrayList<Cliente> cliente = clienteDAO.listar(1);
    request.setAttribute("cliente", cliente);
    request.getRequestDispatcher("/cliente.jsp").forward(request, response);
  }
}
