package servlets;

import classes.DigitalDAO;
import classes.Evento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "eventos", urlPatterns = {"/eventos.do"})
public class eventos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int caso = Integer.parseInt(request.getParameter("caso"));
        int val = Integer.parseInt(request.getParameter("val"));
        
        DigitalDAO dao = new DigitalDAO();
        ArrayList<Evento> eventos = new ArrayList<>();
        
        try {
            switch (caso) {
                case 0: {
                        eventos = dao.listarE(val);
                        request.setAttribute("lista", eventos);
                        request.setAttribute("val", val);
                        RequestDispatcher view = request.getRequestDispatcher("listareventos.jsp");
                        view.forward(request, response);
                        break;}
                case 1: {
                        if(val <= 0){
                            val = 0;
                            eventos = dao.listarE(val);
                        } else {
                            val-=5;
                            eventos = dao.listarE(val);
                        }
                        request.setAttribute("val", val);
                        request.setAttribute("lista", eventos);
                        RequestDispatcher view = request.getRequestDispatcher("listareventos.jsp");
                        view.forward(request, response);
                        break;}
                case 2: {
                        boolean fim = false;
                        eventos = dao.listarE(val);
                        for(Evento e : eventos){
                            if(e.getId() == dao.consultarMaxIdE()) {
                                fim = true;
                            }
                        }
                        if (!fim) {
                            val+=5;
                            eventos = dao.listarE(val);
                        } else {
                            eventos = dao.listarE(val);
                        }
                        request.setAttribute("val", val);
                        request.setAttribute("lista", eventos);
                        RequestDispatcher view = request.getRequestDispatcher("listareventos.jsp");
                        view.forward(request, response);
                        break;}
                default:
                break;
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
