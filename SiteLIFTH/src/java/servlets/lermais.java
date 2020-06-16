package servlets;

import classes.Artigo;
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
@WebServlet(name = "lermais", urlPatterns = {"/lermais.do"})
public class lermais extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        DigitalDAO dao = new DigitalDAO();
        Artigo art = new Artigo();
        
        try {
               art = dao.consultarA(request.getParameter("titulo"));
               request.setAttribute("art",art);
               RequestDispatcher view = request.getRequestDispatcher("lermais.jsp");
               view.forward(request, response);
           } catch (SQLException e) {
               e.printStackTrace();
           }  
    }
}
