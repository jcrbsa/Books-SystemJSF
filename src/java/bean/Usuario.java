/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Vector;
import java.util.Enumeration;

/**
 *
 * @author jcrbsa
 */
public class Usuario {
    
   
    private String nome;

    private String email;
    private String senha;
    private boolean canEdit;

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

   
    private Vector livrosRetirados;

    Usuario(String st) {
        nome = st;
        livrosRetirados = new Vector(5);
    }

    public Usuario(String login, String password) {
        email = login;
        senha = password;
    }
    public Usuario(String nome,String login, String password) {
        this.nome = nome;
        email = login;
        senha = password;
    }
    
       public String getNome() {
        return nome;
    }
    
     public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public boolean retiraLivro(Livro it) {
        if (isAptoARetirar()) {
            if (it.empresta(this, getPrazoMaximo())) {
                livrosRetirados.addElement(it);
                return (true);
            } else {
                return (false);
            }
        } else {
            return (false);
        }

    }

  /*  public boolean devolveLivro(Livro it) {
        if (it.retorna(this)) {
            livrosRetirados.removeElement(it);
            return (true);
        } else {
            return (false);
        }
    }*/

    public int getCotaMaxima() {
        return 2;
    }

    public int getPrazoMaximo() {
        return 4;
    }

    public boolean isADevolver() {
        return ((livrosRetirados.size() >= getCotaMaxima()
                || temPrazoVencido())
                ? true : false);
    }

    public boolean isAptoARetirar() {
        return (!isADevolver());
    }

    public boolean temPrazoVencido() {
        Livro livro;
        Enumeration lista = livrosRetirados.elements();
        while (lista.hasMoreElements()) {
            livro = (Livro) lista.nextElement();
            if (livro.isEmAtraso()) {
                return (true);
            }
        }
        return (false);
    }

    public boolean isProfessor() {
        return (false);
    }

    public void listaCarga() {
        System.out.println(toString() + " Limite: " + getCotaMaxima()
                + " Carga atual: " + livrosRetirados.size());
        Enumeration lista = livrosRetirados.elements();
        while (lista.hasMoreElements()) {
            System.out.println(lista.nextElement());
        }
    }
}
