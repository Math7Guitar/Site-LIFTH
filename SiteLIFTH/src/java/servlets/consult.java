package servlets;

import classes.Artigo;
import classes.DigitalDAO;
import classes.Evento;
import classes.Integrante;
import classes.Projeto;
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
@WebServlet(name = "consult", urlPatterns = {"/consult.do"})
public class consult extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String t = request.getParameter("t");
        
        DigitalDAO dao = new DigitalDAO();
        
        switch (t) {
            case "integrante": {
                    try{
                        Integrante i = new Integrante();
                        i = dao.consultarI(request.getParameter("nome"));
                        request.setAttribute("integ", i);
                        RequestDispatcher view = request.getRequestDispatcher("saibamais.jsp");
                        view.forward(request, response);
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }       
                    break;
                }
            case "projeto": {                   
                    try{
                        Projeto p = new Projeto();
                        p = dao.consultarP(request.getParameter("nome"));
                        request.setAttribute("proj", p);
                        RequestDispatcher view = request.getRequestDispatcher("vermais.jsp");
                        view.forward(request, response);
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            case "artigo": {
                    try{
                        Artigo a = new Artigo();
                        a = dao.consultarA(request.getParameter("titulo"));
                        request.setAttribute("art", a);
                        RequestDispatcher view = request.getRequestDispatcher("lermais.jsp");
                        view.forward(request, response);
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            case "evento": {
                    try{
                        Evento e = new Evento();
                        e = dao.consultarE(request.getParameter("nome"));
                        request.setAttribute("event", e);
                        RequestDispatcher view = request.getRequestDispatcher("eventosmais.jsp");
                        view.forward(request, response);
                    }catch(SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            default:
        break;
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
