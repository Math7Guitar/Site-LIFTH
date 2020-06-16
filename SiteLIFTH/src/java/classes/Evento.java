package classes;

/**
 *
 * @author root
 */
public class Evento {
    
    private String nome, texto, organizador, data, local, foto1, foto2, foto3, foto4, foto5, video1, video2, video3, previa, hora;
    private int id;
    
    // Métodos Getters
    public String getNome() { return this.nome; }
            
    public String getTexto() { return this.texto; }
            
    public String getOrg() { return this.organizador; }
    
    public String getData() { return this.data; }
    
    public String getHora() { return this.hora; }
    
    public String getLocal() { return this.local; }
    
    public String getFoto1() { return this.foto1; }
    
    public String getFoto2() { return this.foto2; }
    
    public String getFoto3() { return this.foto3; }
    
    public String getFoto4() { return this.foto4; }
    
    public String getFoto5() { return this.foto5; }
    
    public String getVideo1() { return this.video1; }
    
    public String getVideo2() { return this.video2; }
    
    public String getVideo3() { return this.video3; }
    
    public String getPrevia() { return this.previa; }
    
    public int getId() { return this.id; }
    
    
    //Métodos Setters
    public void setNome(String n) { this.nome = n; }
            
    public void setTexto(String t) { this.texto = t; }
            
    public void setOrg(String o) { this.organizador = o; }
    
    public void setData(String d) { this.data = d; }
    
    public void setHora(String h) { this.hora = h; }
    
    public void setLocal(String l) { this.local = l; }
    
    public void setFoto1(String f) { this.foto1 = f; }
    
    public void setFoto2(String f) { this.foto2 = f; }
    
    public void setFoto3(String f) { this.foto3 = f; }
    
    public void setFoto4(String f) { this.foto4 = f; }
    
    public void setFoto5(String f) { this.foto5 = f; }
    
    public void setVideo1(String v) { this.video1 = v; }
    
    public void setVideo2(String v) { this.video2 = v; }
    
    public void setVideo3(String v) { this.video3 = v; }
    
    public void setPrevia(String p) { this.previa = p;}
    
    public void setId(int id) { this.id = id; }
}
