package br.com.lojagames.controllers;

import br.com.lojagames.dao.FilialDAO;
import br.com.lojagames.dao.ProdutoDAO;
import br.com.lojagames.models.Produto;
import br.com.lojagames.models.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "NivelCombustivelServlet", urlPatterns = {"/gerente-vendas/nivel-combustivel"})
public class NivelCombustivelServlet extends HttpServlet {
    
    FilialDAO fiDao = new FilialDAO();
    ProdutoDAO pDao = new ProdutoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
   
        int idFilial = fiDao.idFilialPorEmail(usuario.getEmail());
        ArrayList<Produto> produtos = pDao.combustivelPorFilial(idFilial);
        
         if (!produtos.isEmpty()) {
            request.setAttribute("produtosAttr", produtos);
            
        } else {
            request.setAttribute("naoEncontradoAttr", true);
        }
        
        request.getRequestDispatcher("/WEB-INF/nivel-combustivel.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
