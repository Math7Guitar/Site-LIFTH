/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author root
 */
public class LogarUsu {
    
    private String user, senha;
    private boolean tipo;
    
    //Getters
    public String getUser() { return this.user; }
    
    public String getSenha() { return this.senha; }
    
    public boolean getTipo() { return this.tipo; }
    
    //Setters
    
    public void setUser(String u) { this.user = u; }
    
    public void setSenha(String s) { this.senha = s; }
    
    public void setTipo(boolean t) { this.tipo = t; }
    
}
