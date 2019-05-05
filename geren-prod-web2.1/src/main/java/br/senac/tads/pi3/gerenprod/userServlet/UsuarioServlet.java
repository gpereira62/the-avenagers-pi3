package br.senac.tads.pi3.gerenprod.userServlet;

import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.UsuarioDAO;
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
 * @author felip
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

  private final CrudInterface usuarioDAO = new UsuarioDAO();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);
    
    if(!u.acessaProduto()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
    ArrayList<UsuarioServlet> usuario = usuarioDAO.listar(1);
    
    request.setAttribute("usuario", usuario);
    request.getRequestDispatcher("/usuario.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

    Usuario u = new Usuario(request);
    
    if(!u.acessaProduto()) {
      response.sendRedirect(request.getContextPath() + "/");
      return;
    }
    
    Usuario usuario = new Usuario();
    
    usuario.setNome(request.getParameter("nomeCliente"));
    usuario.setEmail(request.getParameter("cpf"));
    usuario.setSenha(request.getParameter("email"));

    boolean sucesso = usuarioDAO.salvar(usuario);
    request.setAttribute("sucesso", sucesso);
    
    if (sucesso) {
      request.setAttribute("mensagem", "Usu�rio cadastrado com sucesso!");
    } else {
      request.setAttribute("mensagem", "N�o foi poss�vel cadastrar o Usu�rio. Por favor, tente novamente!");
    }
    
    ArrayList<UsuarioServlet> usuarios = usuarioDAO.listar(1);
    request.setAttribute("usuarios", usuarios);
    request.getRequestDispatcher("/usuario.jsp").forward(request, response);
  }
}
