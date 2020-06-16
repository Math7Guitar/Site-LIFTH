package servlets;

import classes.DigitalDAO;
import classes.LogarUsu;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/Logar.do"})
public class Logar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
        try {
            DigitalDAO dao = new DigitalDAO();
            String user = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            LogarUsu login = new LogarUsu();
            login = dao.logar(user);
            
            HttpSession session = request.getSession();

            if((login.getUser().equals(user)) && (login.getSenha().equals(senha))) {
                session.setAttribute("usuario", login.getUser());
                session.setAttribute("usuariot", login.getTipo());
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("falha", "Usuario e/ou Senha inválidos");
                RequestDispatcher paginaJSP = request.getRequestDispatcher("msg.jsp");
                paginaJSP.forward(request, response);
            }
	} catch (SQLException e) {
            e.printStackTrace();
	}
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
