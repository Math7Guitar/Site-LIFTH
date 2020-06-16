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
@WebServlet(name = "zoom", urlPatterns = {"/zoom.do"})
public class zoom extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String t = request.getParameter("t");
        int f = Integer.parseInt(request.getParameter("f"));
        String foto = null;
        DigitalDAO dao = new DigitalDAO();
                      
           switch(t){
                case "p":
                    try {
                        switch(f){
                            case 1: { foto = dao.consultarP(request.getParameter("n")).getFoto1(); break; }
                            case 2: { foto = dao.consultarP(request.getParameter("n")).getFoto2(); break; }
                            case 3: { foto = dao.consultarP(request.getParameter("n")).getFoto3(); break; }
                            case 4: { foto = dao.consultarP(request.getParameter("n")).getFoto4(); break; }
                            default:
                            break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                break;
                case "a":
                    try {
                        switch(f){
                            case 1: { foto = dao.consultarA(request.getParameter("n")).getFoto1(); break; }
                            case 2: { foto = dao.consultarA(request.getParameter("n")).getFoto2(); break; }
                            case 3: { foto = dao.consultarA(request.getParameter("n")).getFoto3(); break; }
                            case 4: { foto = dao.consultarA(request.getParameter("n")).getFoto4(); break; }
                            default:
                            break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                break;
                case "e":
                    try {
                        switch(f){
                            case 1: { foto = dao.consultarE(request.getParameter("n")).getFoto1(); break; }
                            case 2: { foto = dao.consultarE(request.getParameter("n")).getFoto2(); break; }
                            case 3: { foto = dao.consultarE(request.getParameter("n")).getFoto3(); break; }
                            case 4: { foto = dao.consultarE(request.getParameter("n")).getFoto4(); break; }
                            default:
                            break;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                break;
                default:
                break;
           }
           request.setAttribute("foto",foto);
           RequestDispatcher view = request.getRequestDispatcher("zoom.jsp");
           view.forward(request, response);
    }

}
