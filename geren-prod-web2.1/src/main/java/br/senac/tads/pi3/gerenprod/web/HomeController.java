package br.senac.tads.pi3.gerenprod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.tads.pi3.gerenprod.dao.impl.ProdutoDaoImpl;
import br.senac.tads.pi3.gerenprod.model.Produto;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDao;

@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoDao produtoDao = ProdutoDaoImpl.getInstance();
	
	public HomeController() {
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Produto> produtos = produtoDao.findAllProdutos();

		request.setAttribute("produtoList", produtos);

		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
