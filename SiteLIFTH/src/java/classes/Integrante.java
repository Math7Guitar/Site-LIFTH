package classes;

/**
 *
 * @author root
 */
public class Integrante {
    
    private String nome, curso, turma, foto, curriculo, email, tel, usuario, senha;
    private int ra, id;
    private boolean tipo;
    
    
    //Getters
    
    public String getNome() { return this.nome; }
    
    public String getCurso() { return this.curso; }
    
    public int getRa() { return this.ra; }
    
    public int getId() { return this.id; }
    
    public String getTurma() { return this.turma; }
    
    public String getFoto() { return this.foto; }
    
    public String getCurriculo() { return this.curriculo; }
    
    public String getUsuario() { return this.usuario; }
    
    public String getSenha() { return this.senha; }
    
    public String getEmail() { return this.email; }
    
    public String getTel() { return this.tel; }
    
    public boolean getTipo() { return this.tipo; }
    
    //Setters
    
    public void setNome(String n) { this.nome = n; }
    
    public void setCurso(String c) { this.curso = c; }
    
    public void setRa(int ra) { this.ra = ra; }
    
    public void setId(int id) { this.id = id; }
    
    public void setTurma(String t) { this.turma = t; }
    
    public void setFoto(String f) { this.foto = f; }
    
    public void setCurriculo(String c) { this.curriculo = c; }
    
    public void setUsuario(String u) { this.usuario = u; }
    
    public void setSenha(String s) { this.senha = s; }
    
    public void setEmail(String e) { this.email = e; }
    
    public void setTel(String t) { this.tel = t; }
    
    public void setTipo(boolean t) { this.tipo = t; }
}
