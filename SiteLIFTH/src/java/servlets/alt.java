package servlets;

import classes.Artigo;
import classes.DigitalDAO;
import classes.Evento;
import classes.Integrante;
import classes.Projeto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "alt", urlPatterns = {"/alt.do"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class alt extends HttpServlet {
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
        String t = request.getParameter("t");
        
        DigitalDAO dao = new DigitalDAO();
        
        switch (t) {
            case "integrante":      
                try {
                    Integrante i = new Integrante();
                    
                    HttpSession session = request.getSession();
                    boolean usutipo = (boolean) session.getAttribute("usuariot");
                    
                    i.setRa(Integer.parseInt(request.getParameter("ra")));
                    
                    i = dao.consultarI2(i.getRa());
                    
                    System.out.println(i.getCurriculo());
                                        
                    if (!"".equals(request.getParameter("nome"))) {
                        i.setNome(request.getParameter("nome"));
                    }
                    
                    if (!"".equals(request.getParameter("curso"))) {
                        i.setCurso(request.getParameter("curso"));
                    }
                    
                    if (!"".equals(request.getParameter("email"))) {
                        i.setEmail(request.getParameter("email"));
                    }
                    
                    if (!"".equals(request.getParameter("telefone"))) {
                        i.setTel(request.getParameter("telefone")); 
                    }
                    
                    if (!"".equals(request.getParameter("turma"))) {
                        i.setTurma(request.getParameter("turma"));
                    }
                    
                    if (!"".equals(request.getParameter("curriculo"))) {
                        i.setCurriculo(request.getParameter("curriculo")); 
                    }
                    
                    if (!"".equals(request.getParameter("usuario"))) {
                        i.setUsuario(request.getParameter("usuario"));
                    }
                    
                    if (!"".equals(request.getParameter("senha"))) {
                        i.setSenha(request.getParameter("senha"));
                    }
                    
                    if(usutipo == true){
                        i.setTipo(Boolean.parseBoolean(request.getParameter("tipo")));
                    } else {
                        i.setTipo(false);
                    }
                    
                    if(request.getPart("foto") != null) {
                        try{
                            i.setFoto(request.getPart("foto").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            i.setFoto(dao.consultarFoto(i.getRa()));
                        }
                    }
                    
                    dao.alterarI(i);
                            
                    request.setAttribute("falha","Integrante Alterado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                    
                } catch(SQLException e) {
                    request.setAttribute("falha","Integrante não pode ser alterado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
            break;
            case "artigo":
                try {
                                       
                    Artigo a = new Artigo();
                    a.setTitulo(request.getParameter("titulo"));
                    a = dao.consultarA(a.getTitulo());
                    
                    if(!"".equals(request.getParameter("texto"))){
                        a.setTexto(request.getParameter("texto"));
                    } 
                    
                    if(!"".equals(request.getParameter("previa"))){
                        a.setPrevia(request.getParameter("previa"));
                    }
                    
                    if(!"".equals(request.getParameter("autor"))){
                        a.setAutor(request.getParameter("autor"));
                    }
                    

                   if (request.getPart("foto1") != null) {
                        try{
                            a.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            a.setFoto1(dao.consultarA(a.getTitulo()).getFoto1());
                        }
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            a.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            a.setFoto2(dao.consultarA(a.getTitulo()).getFoto2());
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            a.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            a.setFoto3(dao.consultarA(a.getTitulo()).getFoto3());
                        }
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            a.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            a.setFoto4(dao.consultarA(a.getTitulo()).getFoto4());
                        }
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            a.setFoto5(request.getPart("foto5").getSubmittedFileName());
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            a.setFoto5(dao.consultarA(a.getTitulo()).getFoto5());
                        }
                    }
                    
                    if (!"".equals(request.getParameter("video1"))) {
                        a.setVideo1(request.getParameter("video1"));
                    } else {
                        a.setVideo1(dao.consultarA(a.getTitulo()).getVideo1());
                    }
                    
                    if (!"".equals(request.getParameter("video2"))) {
                        a.setVideo2(request.getParameter("video2"));
                    } else {
                        a.setVideo2(dao.consultarA(a.getTitulo()).getVideo2());
                    }
                    
                    if (!"".equals(request.getParameter("video3"))) {
                        a.setVideo3(request.getParameter("video3"));
                    } else {
                        a.setVideo3(dao.consultarA(a.getTitulo()).getVideo3());
                    }
                    
                    DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/YYYY");
                    DateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss");
                    Date deploy = new Date();
                    
                    a.setDeployData(dateFormat1.format(deploy));
                    a.setDeployHora(dateFormat2.format(deploy));
                    
                    dao.alterarA(a);
                    
                    request.setAttribute("falha","Artigo alterado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                } catch (SQLException e) {
                    request.setAttribute("falha","Artigo não pode ser Alterado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
            break;
            case "projeto":
                try {
                    
                    Projeto p = new Projeto();
                    p.setNome(request.getParameter("nome"));
                    p = dao.consultarP(p.getNome());
                    
                    if(!"".equals(request.getParameter("componentes"))){
                        p.setComponentes(request.getParameter("componentes"));
                    }                    
                    
                    if(!"".equals(request.getParameter("integrantes"))){
                        p.setIntegrantes(request.getParameter("integrantes"));
                    }
                    
                    if(!"".equals(request.getParameter("descricao"))){
                        p.setDescricao(request.getParameter("descricao"));
                    }
                    
                    if(!"".equals(request.getParameter("previa"))){
                        p.setPrevia(request.getParameter("previa"));
                    }
                    
                    if (request.getPart("foto1") != null) {
                        try{
                            p.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            p.setFoto1(dao.consultarP(p.getNome()).getFoto1());
                        }
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            p.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            p.setFoto2(dao.consultarP(p.getNome()).getFoto2());
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            p.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            p.setFoto3(dao.consultarP(p.getNome()).getFoto3());
                        }
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            p.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            p.setFoto4(dao.consultarP(p.getNome()).getFoto4());
                        }
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            p.setFoto5(request.getPart("foto5").getSubmittedFileName());
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            p.setFoto5(dao.consultarP(p.getNome()).getFoto5());
                        }
                    }
                    
                    if (!"".equals(request.getParameter("video"))) {
                        p.setVideo(request.getParameter("video"));
                    } else {
                        p.setVideo(dao.consultarP(p.getNome()).getVideo());
                    }
                    
                    dao.alterarP(p);
                            
                    request.setAttribute("falha","Projeto alterado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                    
                } catch(SQLException e) {
                    request.setAttribute("falha","Projeto não pode ser Alterado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
            break;
            case "evento":
                try {
                    
                    Evento ev = new Evento();
                    ev.setNome(request.getParameter("nome"));
                    ev = dao.consultarE(ev.getNome());
            
                    if (!"".equals(request.getParameter("texto"))) {
                        ev.setTexto(request.getParameter("texto"));
                    }
                    
                    if (!"".equals(request.getParameter("organizador"))) {
                        ev.setOrg(request.getParameter("organizador"));
                    }
                    
                    if (!"".equals(request.getParameter("previa"))) {
                        ev.setPrevia(request.getParameter("previa"));
                    }
                    
                    if (!"".equals(request.getParameter("data"))) {
                        ev.setData(request.getParameter("data"));
                    }
                    
                    if (!"".equals(request.getParameter("hora"))) {
                        ev.setHora(request.getParameter("hora"));
                    }
                    
                    if (!"".equals(request.getParameter("local"))) {
                        ev.setLocal(request.getParameter("local"));
                    }
                      
                    if (request.getPart("foto1") != null) {
                        try{
                            ev.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            ev.setFoto1(dao.consultarE(ev.getNome()).getFoto1());
                        }
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            ev.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            ev.setFoto2(dao.consultarE(ev.getNome()).getFoto2());
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            ev.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            ev.setFoto3(dao.consultarE(ev.getNome()).getFoto3());
                        }
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            ev.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            ev.setFoto4(dao.consultarE(ev.getNome()).getFoto4());
                        }
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            ev.setFoto5(request.getPart("foto5").getSubmittedFileName());
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException | NullPointerException e) {
                            ev.setFoto5(dao.consultarE(ev.getNome()).getFoto5());
                        }
                    }
                    
                    if (!"".equals(request.getParameter("video1"))) {
                        ev.setVideo1(request.getParameter("video1"));
                    } else {
                        ev.setVideo1(ev.getVideo1());
                    }
                    
                    if (!"".equals(request.getParameter("video2"))) {
                        ev.setVideo2(request.getParameter("video2"));
                    } else {
                        ev.setVideo2(ev.getVideo2());
                    }
                    
                    if (!"".equals(request.getParameter("video3"))) {
                        ev.setVideo3(request.getParameter("video3"));
                    } else {
                        ev.setVideo3(ev.getVideo3());
                    }
                    
                    dao.alterarE(ev);
                            
                    request.setAttribute("falha","Evento alterado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                    
                } catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha","Evento não pode ser Alterado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
                break;
            default:
        break;
        }
    }
}
