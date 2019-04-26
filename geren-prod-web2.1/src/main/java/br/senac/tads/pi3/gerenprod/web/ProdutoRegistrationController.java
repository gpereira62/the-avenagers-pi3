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

@WebServlet("/produto/register")
public class ProdutoRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoDao produtoDao = ProdutoDaoImpl.getInstance();

	public ProdutoRegistrationController() {
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String prodId = request.getParameter("idProduto");
		String NomeProduto = request.getParameter("NomeProduto");
		String Ano = request.getParameter("Ano");
		String Modelo = request.getParameter("Modelo");
		String Marca = request.getParameter("Marca");

		Produto produto = new Produto(NomeProduto, Ano, Modelo, Marca);

		if (prodId == null || prodId == "")
			produtoDao.saveProduto(produto);
		else {
			Long idProduto = Long.parseLong(prodId);
			produto.setIdProduto(idProduto);
			produtoDao.updateProduto(produto);
		}

		response.sendRedirect(request.getContextPath() + "/");
	}

}
