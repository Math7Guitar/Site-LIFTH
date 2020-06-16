package servlets;

import classes.DigitalDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "del", urlPatterns = {"/del.do"})
public class del extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String t = request.getParameter("t");
        
        DigitalDAO dao = new DigitalDAO();
        
        switch (t) {
            case "integrante":
                try{
                    dao.excluirI(request.getParameter("nome"));
                    request.setAttribute("falha", "Integrante deletado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha", "Integrante não pode ser Deletado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            case "projeto":
                try{
                    dao.excluirP(request.getParameter("nome"));
                    request.setAttribute("falha", "Projeto deletado com Sucesso");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha", "Projeto não pode ser Deletado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            case "artigo":
                try{
                    dao.excluirA(request.getParameter("titulo"));
                    request.setAttribute("falha", "Artigo deletado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha", "Artigo não pode ser Deletado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            case "evento":
                try{
                    dao.excluirE(request.getParameter("nome"));
                    request.setAttribute("falha","Evento deletado com sucesso");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha", "Evento não pode ser Deletado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            default:
                break;
        }
    }
}
