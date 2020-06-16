package classes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author root
 */
public class DigitalDAO {
    
    Connection connection;
	
	public DigitalDAO() {
		
		try {
                    this.connection = ConnectionFactory.getConnection();
		}
		catch(ClassNotFoundException c) {
                    System.out.println("Não foi possivel por causa do ClassNotFoundException");
		}
		catch(SQLException d){
                    System.out.println("Não foi possivel por causa do SQLException");
		}
	}
        
    public void cadastrarI(Integrante i) throws SQLException {
        
        String sql = "Select Max(id) as ultimoid from Integrantes";       		
            
           PreparedStatement ps = this.connection.prepareStatement(sql);
            
           ResultSet resultado = ps.executeQuery();
		
            if (resultado.next()) {
                i.setId(resultado.getInt("ultimoid") + 1);
                ps.close();
            }
        
        String sql2 = "INSERT INTO Integrantes (id, nome, curso, ra, turma, foto, curriculo, usuario, senha, email, telefone, tipo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement ps2 = this.connection.prepareStatement(sql2);
            
            ps2.setInt(1, i.getId());
            ps2.setString(2, i.getNome());
            ps2.setString(3, i.getCurso());
            ps2.setInt(4, i.getRa());
            ps2.setString(5, i.getTurma());
            ps2.setString(6, i.getFoto());
            ps2.setString(7, i.getCurriculo());
            ps2.setString(8, i.getUsuario());
            ps2.setString(9, i.getSenha());
            ps2.setString(10, i.getEmail());
            ps2.setString(11, i.getTel());
            ps2.setBoolean(12, i.getTipo());
            
            ps2.execute();
            ps2.close();
    }
    
    public void cadastrarP(Projeto p) throws SQLException {
        
        String sql = "Select Max(id) as ultimoid from Projetos";       		
            
           PreparedStatement ps = this.connection.prepareStatement(sql);
            
           ResultSet resultado = ps.executeQuery();
		
            if (resultado.next()) {
                p.setId(resultado.getInt("ultimoid") + 1);
                ps.close();
            }
        String sql2 = "INSERT INTO Projetos (id, nome, descricao, foto1, foto2, foto3, foto4, foto5, video, componentes, integrantes, previa) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";		
            
            PreparedStatement ps2 = this.connection.prepareStatement(sql2);
        
            ps2.setInt(1, p.getId());
            ps2.setString(2, p.getNome());
            ps2.setString(3, p.getDescricao());
            ps2.setString(4, p.getFoto1());
            ps2.setString(5, p.getFoto2());
            ps2.setString(6, p.getFoto3());
            ps2.setString(7, p.getFoto4());
            ps2.setString(8, p.getFoto5());
            ps2.setString(9, p.getVideo());
            ps2.setString(10, p.getComponentes());
            ps2.setString(11, p.getIntegrantes());
            ps2.setString(12, p.getPrevia());
            
            ps2.execute();
            ps2.close();
    }
    
    public void cadastrarC(String n, String e, String t, String c) throws SQLException {
        
        String sql = "INSERT INTO Comments (nome, email, telefone, comentario) VALUES (?,?,?,?)";		
            
        PreparedStatement ps = this.connection.prepareStatement(sql);
        
        ps.setString(1, n);
        ps.setString(2, e);
        ps.setString(3, t);
        ps.setString(4, c);
                
        ps.execute();
        ps.close();
    }
    
    
    public void cadastrarA(Artigo a) throws SQLException {
        
        String sql = "Select Max(id) as ultimoid from Artigos";       		
            
           PreparedStatement ps = this.connection.prepareStatement(sql);
            
           ResultSet resultado = ps.executeQuery();
		
            if (resultado.next()) {
                a.setId(resultado.getInt("ultimoid") + 1);
                ps.close();
            }
        
        String sql2 = "INSERT INTO Artigos (id, titulo, texto, autor, foto1, foto2, foto3, foto4, foto5, video1, video2, video3, deploy, previa, deployh) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
            
        PreparedStatement ps2 = this.connection.prepareStatement(sql2); 
        
            ps2.setInt(1, a.getId());
            ps2.setString(2, a.getTitulo());
            ps2.setString(3, a.getTexto());
            ps2.setString(4, a.getAutor());
            ps2.setString(5, a.getFoto1());
            ps2.setString(6, a.getFoto2());
            ps2.setString(7, a.getFoto3());
            ps2.setString(8, a.getFoto4());
            ps2.setString(9, a.getFoto5());
            ps2.setString(10, a.getVideo1());
            ps2.setString(11, a.getVideo2());
            ps2.setString(12, a.getVideo3());
            ps2.setString(13, a.getDeployData());
            ps2.setString(14, a.getPrevia());
            ps2.setString(15, a.getDeployHora());
            ps2.execute();    
    }
    
    public void cadastrarE(Evento e) throws SQLException {
        String sql = "Select Max(id) as ultimoid from Eventos";       		
            
           PreparedStatement ps = this.connection.prepareStatement(sql);
            
           ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                e.setId(resultado.getInt("ultimoid") + 1);
                ps.close();
            }
        
        String sql2 = "INSERT INTO Eventos (id, nome, texto, organizador, data, local, foto1, foto2, foto3, foto4, foto5, video1, video2, video3, previa, hora) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
            
        PreparedStatement ps2 = this.connection.prepareStatement(sql2);
            
            ps2.setInt(1, e.getId());
            ps2.setString(2, e.getNome());
            ps2.setString(3, e.getTexto());
            ps2.setString(4, e.getOrg());
            ps2.setString(5, e.getData());
            ps2.setString(6, e.getLocal());
            ps2.setString(7, e.getFoto1());
            ps2.setString(8, e.getFoto2());
            ps2.setString(9, e.getFoto3());
            ps2.setString(10, e.getFoto4());
            ps2.setString(11, e.getFoto5());
            ps2.setString(12, e.getVideo1());
            ps2.setString(13, e.getVideo2());
            ps2.setString(14, e.getVideo3());
            ps2.setString(15, e.getPrevia());
            ps2.setString(16, e.getHora());
            ps2.execute();
    }
    
    
    public LogarUsu logar(String u) throws SQLException {
        String sql = "SELECT usuario, senha, tipo FROM Integrantes WHERE usuario = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
		
	ps.setString(1, u);
		
	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            
            LogarUsu user = new LogarUsu();
            
            user.setUser(resultado.getString("usuario"));
            user.setSenha(resultado.getString("senha"));
            user.setTipo(resultado.getBoolean("tipo"));
                        
            ps.close();
                return user;
            } else {
                ps.close();
                return null;
            }
    }
    
    
    public int consultarMaxIdE() throws SQLException {
        String sql = "Select Max(id) as ultimoid from Eventos";       		    
        PreparedStatement ps = this.connection.prepareStatement(sql);
            
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("ultimoid");
            ps.close();
            return id;
        } else {
            ps.close();
            return 0;
        }
    }
    
    public int consultarMaxIdP() throws SQLException {
        String sql = "Select Max(id) as ultimoid from Projetos";       		    
        PreparedStatement ps = this.connection.prepareStatement(sql);
            
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("ultimoid");
            ps.close();
            return id;
        } else {
            ps.close();
            return 0;
        }
    }
    
    public int consultarMaxIdA() throws SQLException {
        String sql = "Select Max(id) as ultimoid from Artigos";       		    
        PreparedStatement ps = this.connection.prepareStatement(sql);
            
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("ultimoid");
            ps.close();
            return id;
        } else {
            ps.close();
            return 0;
        }
    }
    
    public int consultarMaxIdI() throws SQLException {
        String sql = "Select Max(id) as ultimoid from Integrantes";       		    
        PreparedStatement ps = this.connection.prepareStatement(sql);
            
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            int id = resultado.getInt("ultimoid");
            ps.close();
            return id;
        } else {
            ps.close();
            return 0;
        }
    }
    
    
    public Projeto consultarP(String nome) throws SQLException {
        String sql = "SELECT * FROM Projetos WHERE nome = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
		
	ps.setString(1, nome);
		
	ResultSet resultado = ps.executeQuery();
		
            if (resultado.next()) {
                Projeto projeto = new Projeto();
                projeto.setId(resultado.getInt("id"));
                projeto.setNome(resultado.getString("nome"));
                projeto.setDescricao(resultado.getString("descricao"));
                projeto.setComponentes(resultado.getString("componentes"));
                projeto.setFoto1(resultado.getString("foto1"));
                projeto.setFoto2(resultado.getString("foto2"));
                projeto.setFoto3(resultado.getString("foto3"));
                projeto.setFoto4(resultado.getString("foto4"));
                projeto.setFoto5(resultado.getString("foto5"));
                projeto.setVideo(resultado.getString("video"));
                projeto.setIntegrantes(resultado.getString("integrantes"));
                projeto.setPrevia(resultado.getString("previa"));
                
                ps.close();
                return projeto;
            } else {
                ps.close();
                return null;
            }
	}
    
    
    public Integrante consultarI(String nome) throws SQLException {
        String sql = "SELECT * FROM Integrantes WHERE nome = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
		
	ps.setString(1, nome);
		
	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            Integrante integ = new Integrante();
            integ.setId(resultado.getInt("id"));
            integ.setNome(resultado.getString("nome"));
            integ.setCurso(resultado.getString("curso"));
            integ.setRa(resultado.getInt("ra"));
            integ.setTurma(resultado.getString("turma"));
            integ.setFoto(resultado.getString("foto"));
            integ.setCurriculo(resultado.getString("curriculo"));
            integ.setEmail(resultado.getString("email"));
            integ.setTel(resultado.getString("telefone"));
            integ.setTipo(resultado.getBoolean("tipo"));
            
            ps.close();
            return integ;
	} else {
            ps.close();
            return null;
	}
    }
    
    
    public Integrante consultarI2(int ra) throws SQLException {
        String sql = "SELECT * FROM Integrantes WHERE ra = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
		
	ps.setInt(1, ra);
		
	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            Integrante integ = new Integrante();
            integ.setId(resultado.getInt("id"));
            integ.setNome(resultado.getString("nome"));
            integ.setCurso(resultado.getString("curso"));
            integ.setRa(resultado.getInt("ra"));
            integ.setTurma(resultado.getString("turma"));
            integ.setFoto(resultado.getString("foto"));
            integ.setCurriculo(resultado.getString("curriculo"));
            integ.setEmail(resultado.getString("email"));
            integ.setTel(resultado.getString("telefone"));
            integ.setTipo(resultado.getBoolean("tipo"));
            integ.setUsuario(resultado.getString("usuario"));
            integ.setSenha(resultado.getString("senha"));
            
            ps.close();
            return integ;
	} else {
            ps.close();
            return null;
	}
    }
	
    
    public String consultarFoto(int ra) throws SQLException {
        String sql = "SELECT foto FROM Integrantes WHERE ra = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
	
	ps.setInt(1, ra);
		
	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            String foto = resultado.getString("foto");
            
            ps.close();
            return foto;
	} else {
            ps.close();
            return null;
	}
    }
    
    
    public Artigo consultarA(String titulo) throws SQLException {
        String sql = "SELECT * FROM Artigos WHERE titulo = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
	ps.setString(1, titulo);
		
	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            Artigo a = new Artigo();
            a.setId(resultado.getInt("id"));
            a.setTitulo(resultado.getString("titulo"));
            a.setTexto(resultado.getString("texto"));
            a.setAutor(resultado.getString("autor"));
            a.setFoto1(resultado.getString("foto1"));
            a.setFoto2(resultado.getString("foto2"));
            a.setFoto3(resultado.getString("foto3"));
            a.setFoto4(resultado.getString("foto4"));
            a.setFoto5(resultado.getString("foto5"));
            a.setVideo1(resultado.getString("video1"));
            a.setVideo2(resultado.getString("video2"));
            a.setVideo3(resultado.getString("video3"));
            a.setDeployData(resultado.getString("deploy"));
            a.setDeployHora(resultado.getString("deployh"));
            a.setPrevia(resultado.getString("previa"));
            
            ps.close();
            return a;
	} else {
            ps.close();
            return null;
	}
    }
    
    public Evento consultarE(String nome) throws SQLException {
        String sql = "SELECT * FROM Eventos WHERE nome = ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
	ps.setString(1, nome);

	ResultSet resultado = ps.executeQuery();
		
	if (resultado.next()) {
            Evento e = new Evento();
            e.setId(resultado.getInt("id"));
            e.setNome(resultado.getString("nome"));
            e.setTexto(resultado.getString("texto"));
            e.setOrg(resultado.getString("organizador"));
            e.setData(resultado.getString("data"));
            e.setLocal(resultado.getString("local"));
            e.setFoto1(resultado.getString("foto1"));
            e.setFoto2(resultado.getString("foto2"));
            e.setFoto3(resultado.getString("foto3"));
            e.setFoto4(resultado.getString("foto4"));
            e.setFoto5(resultado.getString("foto5"));
            e.setVideo1(resultado.getString("video1"));
            e.setVideo2(resultado.getString("video2"));
            e.setVideo3(resultado.getString("video3"));
            e.setPrevia(resultado.getString("previa"));
            e.setHora(resultado.getString("hora"));
            
            ps.close();
            return e;
	} else {
            ps.close();
            return null;
	}
    }
    
    
    public void alterarI(Integrante i) throws SQLException {
        String sql = "UPDATE Integrantes SET nome = ?, curso = ?, turma = ?, foto = ?, curriculo = ?, usuario = ?, senha = ?, email = ?, telefone = ?, tipo = ? WHERE ra = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        
        ps.setString(1, i.getNome());
        ps.setString(2, i.getCurso());
        ps.setString(3, i.getTurma());
        ps.setString(4, i.getFoto());
        ps.setString(5, i.getCurriculo());
        ps.setString(6, i.getUsuario());
        ps.setString(7, i.getSenha());
        ps.setString(8, i.getEmail());
        ps.setString(9, i.getTel());
        ps.setBoolean(10, i.getTipo());
        ps.setInt(11, i.getRa());
        
        ps.executeUpdate();
        ps.close();
    }
    
    
    public void alterarP(Projeto p) throws SQLException {
        String sql = "UPDATE Projetos Set descricao = ?, foto1 = ?, foto2 = ?, foto3 = ?, foto4 = ?, foto5 = ?, video = ?, componentes = ?, integrantes = ?, previa = ? WHERE nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        
        ps.setString(1, p.getDescricao());
        ps.setString(2, p.getFoto1());
        ps.setString(3, p.getFoto2());
        ps.setString(4, p.getFoto3());
        ps.setString(5, p.getFoto4());
        ps.setString(6, p.getFoto5());
        ps.setString(7, p.getVideo());
        ps.setString(8, p.getComponentes());
        ps.setString(9, p.getIntegrantes());
        ps.setString(10, p.getPrevia());
        ps.setString(11, p.getNome());
        
        ps.executeUpdate();
        ps.close();
    }
    
    
    public void alterarA(Artigo a) throws SQLException {
        String sql = "UPDATE Artigos Set texto = ?, autor = ?, foto1 = ?, foto2 = ?, foto3 = ?, foto4 = ?, foto5 = ?, video1 = ?, video2 = ?, video3 = ?, deploy = ?, previa = ?, deployh = ? WHERE titulo = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        
        ps.setString(1, a.getTexto());
        ps.setString(2, a.getAutor());
        ps.setString(3, a.getFoto1());
        ps.setString(4, a.getFoto2());
        ps.setString(5, a.getFoto3());
        ps.setString(6, a.getFoto4());
        ps.setString(7, a.getFoto5());
        ps.setString(8, a.getVideo1());
        ps.setString(9, a.getVideo2());
        ps.setString(10, a.getVideo3());
        ps.setString(11, a.getDeployData());
        ps.setString(12, a.getPrevia());
        ps.setString(13, a.getDeployHora());
        ps.setString(14, a.getTitulo());
        
        ps.executeUpdate();
        ps.close();
    }
    
    
    public void alterarE(Evento e) throws SQLException {	
        String sql = "UPDATE Eventos SET texto = ?, organizador = ?, data = ?, local = ?, foto1 = ?, foto2 = ?, foto3 = ?, foto4 = ?, foto5 = ?, video1 = ?, video2 = ?, video3 = ?, previa = ?, hora = ? WHERE nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        
        ps.setString(1, e.getTexto());
        ps.setString(2, e.getOrg());
        ps.setString(3, e.getData());
        ps.setString(4, e.getLocal());
        ps.setString(5, e.getFoto1());
        ps.setString(6, e.getFoto2());
        ps.setString(7, e.getFoto3());
        ps.setString(8, e.getFoto4());
        ps.setString(9, e.getFoto5());
        ps.setString(10, e.getVideo1());
        ps.setString(11, e.getVideo2());
        ps.setString(12, e.getVideo3());
        ps.setString(13, e.getPrevia());
        ps.setString(14, e.getHora());
        ps.setString(15, e.getNome());
        
        ps.executeUpdate();
        ps.close();
    }
    

    public void excluirI(String nome) throws SQLException {
        String sql = "DELETE FROM Integrantes WHERE nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, nome);
        ps.execute();
        ps.close();
    }
    
    
    public void excluirP(String nome) throws SQLException {
        String sql = "DELETE FROM Projetos WHERE nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, nome);
        ps.execute();
        ps.close();
    }    
    
    
    public void excluirA(String titulo) throws SQLException {
        String sql = "DELETE FROM Artigos WHERE titulo = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, titulo);
        ps.execute();
        ps.close();
    }  
    
    
    public void excluirE(String nome) throws SQLException {
        String sql = "DELETE FROM Eventos WHERE nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, nome);
        ps.execute();
        ps.close();
    }  
    
	
    public ArrayList<Integrante> listarI(int start) throws SQLException {
        String sql = "SELECT * FROM Integrantes limit 10 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, start);
	ResultSet resultado = ps.executeQuery();
	ArrayList<Integrante> listaDeIntegrantes = new ArrayList<>();
		
            while (resultado.next()) {
			
		Integrante integrante = new Integrante ();
		integrante.setId(resultado.getInt("id"));	
		integrante.setNome(resultado.getString("nome"));
		integrante.setCurso(resultado.getString("curso"));
		integrante.setRa(resultado.getInt("ra"));
		integrante.setTurma(resultado.getString("turma"));
                integrante.setFoto(resultado.getString("foto"));
                integrante.setCurriculo(resultado.getString("curriculo"));
                integrante.setUsuario(resultado.getString("usuario"));
                integrante.setSenha(resultado.getString("senha"));
                integrante.setEmail(resultado.getString("email"));
                integrante.setTel(resultado.getString("telefone"));
                integrante.setTipo(resultado.getBoolean("tipo"));
			
		listaDeIntegrantes.add(integrante);		
            }
            
            ps.close();
            return listaDeIntegrantes;
    }
    
    public ArrayList<Integrante> listarI2(String t, int start) throws SQLException {
        String sql = "SELECT * FROM Integrantes WHERE nome LIKE %?% limit 5 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, t);
        ps.setInt(2, start);
	ResultSet resultado = ps.executeQuery();
	ArrayList<Integrante> listaDeIntegrantes = new ArrayList<>();
		
            while (resultado.next()) {
			
		Integrante integrante = new Integrante ();
		integrante.setId(resultado.getInt("id"));	
		integrante.setNome(resultado.getString("nome"));
		integrante.setCurso(resultado.getString("curso"));
		integrante.setRa(resultado.getInt("ra"));
		integrante.setTurma(resultado.getString("turma"));
                integrante.setFoto(resultado.getString("foto"));
                integrante.setCurriculo(resultado.getString("curriculo"));
                integrante.setUsuario(resultado.getString("usuario"));
                integrante.setSenha(resultado.getString("senha"));
                integrante.setEmail(resultado.getString("email"));
                integrante.setTel(resultado.getString("telefone"));
                integrante.setTipo(resultado.getBoolean("tipo"));
			
		listaDeIntegrantes.add(integrante);		
            }
            
            ps.close();
            return listaDeIntegrantes;
    }
    
    
    public ArrayList<Projeto> listarP(int start) throws SQLException {
        String sql = "SELECT * FROM Projetos limit 5 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, start);
        
	ResultSet resultado = ps.executeQuery();
	ArrayList<Projeto> listaDeProjetos = new ArrayList<>();
		
            while (resultado.next()) {
			
		Projeto projeto = new Projeto();
                projeto.setId(resultado.getInt("id"));
		projeto.setNome(resultado.getString("nome"));
		projeto.setDescricao(resultado.getString("descricao"));
		projeto.setComponentes(resultado.getString("componentes"));
		projeto.setFoto1(resultado.getString("foto1"));
                projeto.setFoto2(resultado.getString("foto2"));
                projeto.setFoto3(resultado.getString("foto3"));
                projeto.setFoto4(resultado.getString("foto4"));
                projeto.setFoto5(resultado.getString("foto5"));
                projeto.setVideo(resultado.getString("video"));
                projeto.setIntegrantes(resultado.getString("integrantes"));
                projeto.setPrevia(resultado.getString("previa"));
                
		listaDeProjetos.add(projeto);		
            }
	
            ps.close();
            return listaDeProjetos;
    }

    public ArrayList<Artigo> listarA(int start) throws SQLException {
        String sql = "SELECT * FROM Artigos limit 5 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, start);
	ResultSet resultado = ps.executeQuery();
	ArrayList<Artigo> listaDeArtigos = new ArrayList<>();
		
            while (resultado.next()) {
			
		Artigo artigo = new Artigo();
		artigo.setId(resultado.getInt("id"));
		artigo.setTitulo(resultado.getString("titulo"));
		artigo.setTexto(resultado.getString("texto"));
		artigo.setAutor(resultado.getString("autor"));
                artigo.setFoto1(resultado.getString("foto1"));
                artigo.setFoto2(resultado.getString("foto2"));
                artigo.setFoto3(resultado.getString("foto3"));
                artigo.setFoto4(resultado.getString("foto4"));
                artigo.setFoto5(resultado.getString("foto5"));
                artigo.setVideo1(resultado.getString("video1"));
                artigo.setVideo2(resultado.getString("video2"));
                artigo.setVideo3(resultado.getString("video3"));
		artigo.setDeployData(resultado.getString("deploy"));
                artigo.setDeployHora(resultado.getString("deployh"));
                artigo.setPrevia(resultado.getString("previa"));
                
		listaDeArtigos.add(artigo);		
            }
	
            ps.close();
            return listaDeArtigos;
    }
    
    public ArrayList<Artigo> listarA2(String t, int start) throws SQLException {
        String sql = "SELECT * FROM Artigos WHERE titulo LIKE %?% limit 5 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, t);
        ps.setInt(2, start);
	ResultSet resultado = ps.executeQuery();
	ArrayList<Artigo> listaDeArtigos = new ArrayList<>();
		
            while (resultado.next()) {
			
		Artigo artigo = new Artigo();
		artigo.setId(resultado.getInt("id"));
		artigo.setTitulo(resultado.getString("titulo"));
		artigo.setTexto(resultado.getString("texto"));
		artigo.setAutor(resultado.getString("autor"));
                artigo.setFoto1(resultado.getString("foto1"));
                artigo.setFoto2(resultado.getString("foto2"));
                artigo.setFoto3(resultado.getString("foto3"));
                artigo.setFoto4(resultado.getString("foto4"));
                artigo.setFoto5(resultado.getString("foto5"));
                artigo.setVideo1(resultado.getString("video1"));
                artigo.setVideo2(resultado.getString("video2"));
                artigo.setVideo3(resultado.getString("video3"));
		artigo.setDeployData(resultado.getString("deploy"));
                artigo.setDeployHora(resultado.getString("deployh"));
                artigo.setPrevia(resultado.getString("previa"));
                
		listaDeArtigos.add(artigo);		
            }
	
            ps.close();
            return listaDeArtigos;
    }
    
    public ArrayList<Evento> listarE(int start) throws SQLException {
        String sql = "SELECT * FROM Eventos limit 5 offset ?";
	PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, start);
	ResultSet resultado = ps.executeQuery();
	ArrayList<Evento> listaDeEventos = new ArrayList<>();
		
            while (resultado.next()) {
			
		Evento evento = new Evento();
		evento.setId(resultado.getInt("id"));
		evento.setNome(resultado.getString("nome"));
		evento.setTexto(resultado.getString("texto"));
		evento.setOrg(resultado.getString("organizador"));
                evento.setData(resultado.getString("data"));
                evento.setLocal(resultado.getString("local"));
                evento.setFoto1(resultado.getString("foto1"));
                evento.setFoto2(resultado.getString("foto2"));
                evento.setFoto3(resultado.getString("foto3"));
                evento.setFoto4(resultado.getString("foto4"));
                evento.setFoto5(resultado.getString("foto5"));
                evento.setVideo1(resultado.getString("video1"));
                evento.setVideo2(resultado.getString("video2"));
                evento.setVideo3(resultado.getString("video3"));
                evento.setPrevia(resultado.getString("previa"));
                evento.setHora(resultado.getString("hora"));
                
		listaDeEventos.add(evento);		
            }
	
            ps.close();
            return listaDeEventos;	
    }
    
    public void salvarFoto(InputStream foto, String nomeFoto) throws FileNotFoundException, IOException {
        try (FileOutputStream Foto = new FileOutputStream(nomeFoto)) {
            byte[] b = new byte[1024];
            while(foto.available() > 0){
                foto.read(b);
                Foto.write(b);
            }
            foto.close();
            Foto.close();
        }
    }
}

