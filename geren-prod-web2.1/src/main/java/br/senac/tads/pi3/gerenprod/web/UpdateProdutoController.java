package br.senac.tads.pi3.gerenprod.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.tads.pi3.gerenprod.dao.impl.ProdutoDaoImpl;
import br.senac.tads.pi3.gerenprod.model.Produto;
import br.senac.tads.pi3.gerenprod.dao.ProdutoDao;

@WebServlet("/produto/update")
public class UpdateProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProdutoController() {
		// Do Nothing
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prodId = request.getParameter("prodId");

		if (prodId == "" || prodId == null)
			request.getRequestDispatcher("/").forward(request, response);
		else {
			Long idProduto = Long.parseLong(prodId);
			ProdutoDao produtoDao = ProdutoDaoImpl.getInstance();
			Produto produto = produtoDao.findProdutoById(idProduto);

			request.setAttribute("produto", produto);

			request.getRequestDispatcher("/").forward(request, response);
		}
	}
}
