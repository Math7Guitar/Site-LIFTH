package servlets;

import classes.DigitalDAO;
import classes.Projeto;
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
@WebServlet(urlPatterns = {"/projetos.do"})
public class projetos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int caso = Integer.parseInt(request.getParameter("caso"));
        int val = Integer.parseInt(request.getParameter("val"));
        
        DigitalDAO dao = new DigitalDAO();
	
        ArrayList<Projeto> projetos = new ArrayList<>();
		
        try {
            switch (caso) {
                case 0: {
                        projetos = dao.listarP(val);
                        request.setAttribute("lista", projetos);
                        request.setAttribute("val", val);
                        RequestDispatcher view = request.getRequestDispatcher("listarprojetos.jsp");
                        view.forward(request, response);
                        break;}
                case 1: {
                        if(val <= 0){
                            val = 0;
                            projetos = dao.listarP(val);
                        } else {
                            val-=5;
                            projetos = dao.listarP(val);
                        }
                        request.setAttribute("val", val);
                        request.setAttribute("lista", projetos);
                        RequestDispatcher view = request.getRequestDispatcher("listarprojetos.jsp");
                        view.forward(request, response);
                        break;}
                case 2: {
                        boolean fim = false;
                        projetos = dao.listarP(val);
                        for(Projeto p : projetos){
                            if(p.getId() == dao.consultarMaxIdP()) {
                                fim = true;
                            }
                        }
                        if (!fim) {
                            val+=5;
                            projetos = dao.listarP(val);
                        } else {
                            projetos = dao.listarP(val);
                        }
                        request.setAttribute("val", val);
                        request.setAttribute("lista", projetos);
                        RequestDispatcher view = request.getRequestDispatcher("listarprojetos.jsp");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
