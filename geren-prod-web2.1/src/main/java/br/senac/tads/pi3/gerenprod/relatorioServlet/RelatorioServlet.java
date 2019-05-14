/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.gerenprod.relatorioServlet;

import br.senac.tads.pi3.gerenprod.dao.Auxiliar;
import br.senac.tads.pi3.gerenprod.dao.CrudInterface;
import br.senac.tads.pi3.gerenprod.dao.RelatorioDAO;
import br.senac.tads.pi3.gerenprod.model.Relatorio;
import br.senac.tads.pi3.gerenprod.model.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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

    private final CrudInterface RelatorioDAO = new RelatorioDAO() {
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Usuario u = new Usuario(request);

        if (!u.acessaRelatorio()) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }
        ArrayList<Relatorio> relatorios = RelatorioDAO.listar(1);

        request.setAttribute("relatorios", relatorios);
        request.getRequestDispatcher("/relatorio.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ArrayList<Relatorio> relatorios = RelatorioDAO.listar(1);
            
            
            Date dataInicial = Auxiliar.InputDateToUtilDate(request.getParameter("dataInicial"));
            Date dataFinal = Auxiliar.InputDateToUtilDate(request.getParameter("dataFinal"));

            relatorios = RelatorioDAO.getAluguelByDates(dataInicial, dataFinal);
            request.setAttribute("relatorios", relatorios);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Relatorio.jsp");
            dispatcher.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
