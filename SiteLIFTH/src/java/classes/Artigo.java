package classes;

/**
 *
 * @author root
 */
public class Artigo {
    
    private String titulo, texto, autor, foto1, foto2, foto3, foto4, foto5, video1, video2, video3, deployd, deployh, previa;
    private int id;
    
    // Métodos Getters
    public String getTitulo() { return this.titulo; }
            
    public String getTexto() { return this.texto; }
            
    public String getAutor() { return this.autor; }
    
    public String getFoto1() { return this.foto1; }
    
    public String getFoto2() { return this.foto2; }
    
    public String getFoto3() { return this.foto3; }
    
    public String getFoto4() { return this.foto4; }
    
    public String getFoto5() { return this.foto5; }
    
    public String getVideo1() { return this.video1; }
    
    public String getVideo2() { return this.video2; }
    
    public String getVideo3() { return this.video3; }
    
    public String getDeployData() { return this.deployd; }
    
    public String getDeployHora() { return this.deployh; }
    
    public String getPrevia() { return this.previa; }
    
    public int getId() { return this.id; }
    
    
    //Métodos Setters
    public void setTitulo(String t) { this.titulo = t; }
            
    public void setTexto(String t) { this.texto = t; }
            
    public void setAutor(String a) { this.autor = a; }
    
    public void setFoto1(String f) { this.foto1 = f; }
    
    public void setFoto2(String f) { this.foto2 = f; }
    
    public void setFoto3(String f) { this.foto3 = f; }
    
    public void setFoto4(String f) { this.foto4 = f; }
    
    public void setFoto5(String f) { this.foto5 = f; }
    
    public void setVideo1(String v) { this.video1 = v; }
    
    public void setVideo2(String v) { this.video2 = v; }
    
    public void setVideo3(String v) { this.video3 = v; }
    
    public void setDeployData(String d) { this.deployd = d; }
    
    public void setDeployHora(String d) { this.deployh = d; }

    public void setPrevia(String p) { this.previa = p; }
    
    public void setId(int id) { this.id = id; }
}
