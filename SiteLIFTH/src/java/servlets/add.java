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

@WebServlet(name = "add", urlPatterns = {"/add.do"})
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class add extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String t = request.getParameter("t");
        
        DigitalDAO dao = new DigitalDAO();
                    
        switch (t) {
            case "integrante":      
                try {
                    
                    Integrante i = new Integrante();
                    
                    HttpSession session = request.getSession();
                    boolean usutipo = (boolean) session.getAttribute("usuariot");
            
                    i.setNome(request.getParameter("nome"));
                    i.setRa(Integer.parseInt(request.getParameter("ra")));
                    i.setCurso(request.getParameter("curso"));
                    i.setEmail(request.getParameter("email"));
                    i.setTel(request.getParameter("telefone"));
                    i.setTurma(request.getParameter("turma"));
                    i.setCurriculo(request.getParameter("curriculo"));  
                    i.setFoto(request.getPart("foto").getSubmittedFileName());
                    i.setUsuario(request.getParameter("usuario"));
                    i.setSenha(request.getParameter("senha"));
                    if(usutipo == true){
                        i.setTipo(Boolean.parseBoolean(request.getParameter("tipo")));
                    } else {
                        i.setTipo(false);
                    }
                    
                    i.setFoto(request.getPart("foto").getSubmittedFileName());
                        
                    InputStream foto = request.getPart("foto").getInputStream();
                    String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto").getSubmittedFileName();
                        
                    dao.salvarFoto(foto, nomeFoto);
                    
                    dao.cadastrarI(i);
                            
                    request.setAttribute("falha","Integrante cadastrado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                    
                } catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha","Integrante não pode ser cadastrado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
                break;
            
            case "projeto":
                try {      
                    
                    Projeto p = new Projeto();
                                
                    p.setNome(request.getParameter("nome"));
                    p.setComponentes(request.getParameter("componentes"));
                    p.setIntegrantes(request.getParameter("integrantes"));
                    p.setDescricao(request.getParameter("descricao"));
                    p.setPrevia(request.getParameter("previa"));
                    p.setVideo(request.getParameter("video"));
                    
                    
                    if (request.getPart("foto1") != null) {
                        try{
                            p.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            p.setFoto1("LIFTHlogo2.jpg");
                        } 
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            p.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            p.setFoto2(null);
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            p.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            p.setFoto3(null);
                        } 
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            p.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            p.setFoto4(null);
                        } 
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            p.setFoto5(request.getPart("foto5").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            p.setFoto5(null);
                        } 
                    }
                    
                    dao.cadastrarP(p);
                            
                    request.setAttribute("falha","Projeto cadastrado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                    
                } catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha","Projeto não pode ser cadastrado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }
                break;
            
            case "artigo":
                try {        
                    Artigo a = new Artigo();
                    DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/YYYY");
                    DateFormat dateFormat2 = new SimpleDateFormat("hh:mm:ss");
                    Date deploy = new Date();
                    
                    a.setTitulo(request.getParameter("titulo"));
                    a.setTexto(request.getParameter("texto"));
                    a.setPrevia(request.getParameter("previa"));
                    a.setAutor(request.getParameter("autor"));
                    
                    if (request.getPart("foto1") != null) {
                        try{
                            a.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            a.setFoto1("LIFTHlogo2.jpg");
                        } 
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            a.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            a.setFoto2(null);
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            a.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            a.setFoto3(null);
                        } 
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            a.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            a.setFoto4(null);
                        } 
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            a.setFoto5(request.getPart("foto5").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException e) {
                            a.setFoto5(null);
                        } 
                    }
                                        
                    if (request.getParameter("video1") != null) {
                        a.setVideo1(request.getParameter("video1"));
                    } else { 
                        a.setVideo1(null);
                    }
                    
                    if (request.getParameter("video2") != null) {
                        a.setVideo2(request.getParameter("video2"));
                    } else { 
                        a.setVideo2(null);
                    }
                    
                    if (request.getParameter("video3") != null) {
                        a.setVideo3(request.getParameter("video3"));
                    } else { 
                        a.setVideo3(null);
                    }
                    
                    a.setDeployData(dateFormat1.format(deploy));
                    a.setDeployHora(dateFormat2.format(deploy));
                    
                    dao.cadastrarA(a);
                    
                    request.setAttribute("falha","Artigo cadastrado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha","Artigo não pode ser cadastrado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            
            case "evento":
                try {
                    Evento e = new Evento();
                    
                    e.setNome(request.getParameter("nome"));
                    e.setOrg(request.getParameter("organizador"));
                    e.setTexto(request.getParameter("texto"));
                    e.setPrevia(request.getParameter("previa"));
                    e.setLocal(request.getParameter("local"));
                    e.setData(request.getParameter("data"));
                    e.setHora(request.getParameter("hora"));
                    
                    if (request.getPart("foto1") != null) {
                        try{
                            e.setFoto1(request.getPart("foto1").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto1").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto1").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException ex) {
                            e.setFoto1("LIFTHlogo2.jpg");
                        } 
                    }
                    
                    if (request.getPart("foto2") != null) {
                        try{
                            e.setFoto2(request.getPart("foto2").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto2").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto2").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException ex) {
                            e.setFoto2(null);
                        } 
                    }
                    
                    if (request.getPart("foto3") != null) {
                        try{
                            e.setFoto3(request.getPart("foto3").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto3").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto3").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException ex) {
                            e.setFoto3(null);
                        } 
                    }
                    
                    if (request.getPart("foto4") != null) {
                        try{
                            e.setFoto4(request.getPart("foto4").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto4").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto4").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException ex) {
                            e.setFoto4(null);
                        } 
                    }
                    
                    if (request.getPart("foto5") != null) {
                        try{
                            e.setFoto5(request.getPart("foto5").getSubmittedFileName());
                        
                            InputStream foto = request.getPart("foto5").getInputStream();
                            String nomeFoto = getServletContext().getRealPath("/")+"/imagens/" + request.getPart("foto5").getSubmittedFileName();
                        
                            dao.salvarFoto(foto, nomeFoto);
                        } catch(FileNotFoundException ex) {
                            e.setFoto5(null);
                        } 
                    }
                    
                    if (request.getParameter("video1") != null) {
                        e.setVideo1(request.getParameter("video1"));
                    } else { 
                        e.setVideo1(null);
                    }
                    
                    if (request.getParameter("video2") != null) {
                        e.setVideo2(request.getParameter("video2"));
                    } else { 
                        e.setVideo2(null);
                    }
                    
                    if (request.getParameter("video3") != null) {
                        e.setVideo3(request.getParameter("video3"));
                    } else { 
                        e.setVideo3(null);
                    }
                    
                    dao.cadastrarE(e);
                    
                    request.setAttribute("falha","Evento cadastrado com Sucesso!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }catch(SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("falha","Evento não pode ser cadastrado!");
                    RequestDispatcher view = request.getRequestDispatcher("msg.jsp");
                    view.forward(request, response);
                }   break;
            default:
            break;
        }
    }
}
