/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Usuario;
import dao.InterfaceUsuariosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author jcrbsa
 */
public class UsuariosController implements Serializable {

    private String nome;
    private String email;
    private String senha;
    private boolean canEdit;
    private Usuario usuario;
    public static final ArrayList<Usuario> array = new ArrayList<Usuario>();
    private int quantidadeLivros;

    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }

    public void setQuantidadeLivros(int quantidadeLivros) {
        this.quantidadeLivros = quantidadeLivros;
    }
     private int tipo;
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;

    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public static ArrayList<Usuario> getArray() {
        return array;
    }

    public String addUsuario() throws LivrariaDAOException {
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(consultaLoginAux(email) != null){
            FacesMessage message = new FacesMessage("Livro já existe!");
            
            context.addMessage("form_add_user",message);
        }else{
            
        tipo = checaTipoUsuario(email);
        Usuario usuario = new Usuario(nome, email, senha,tipo);
        array.add(usuario);
         InterfaceUsuariosDAO idao = new LivrariaDAO();
        idao.salvarUsuario(usuario);
            
        }

      
        return null;
    }

    public String deleteUsuario(Usuario usuario) throws LivrariaDAOException {

        array.remove(usuario);
        InterfaceUsuariosDAO idao = new LivrariaDAO();
        idao.excluirUsuario(usuario);

        return null;
    }

    public String editUsuario(Usuario usuario) throws LivrariaDAOException {

        usuario.setCanEdit(true);
        return null;
    }

    public String saveUsuarios() throws LivrariaDAOException {

        InterfaceUsuariosDAO idao = new LivrariaDAO();

        for (Usuario usuario : array) {
            usuario.setCanEdit(false);
        }
        idao.atualizarTodosUsuario(array);

        return null;
    }

    public ArrayList<Usuario> showUsuarios() throws LivrariaDAOException {
        InterfaceUsuariosDAO test = new LivrariaDAO();
        List<Usuario> list = new ArrayList<Usuario>();
        list = test.todosUsuario();

        if (array.isEmpty()) {
            for (Usuario usuarios : list) {
                array.add(usuarios);
            }
        }
//        }else{
//            array.clear();
//            for (Usuario usuarios : list) {
//                array.add(usuarios);
//            }
//        }
        return array;
    }

    private int checaTipoUsuario(String email) {
        
        Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();

        
        Pattern p2 =  Pattern.compile("[a-z]{3,255}@[a][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m2 = p2.matcher(email); 
         boolean matchFound2 = m2.matches();
 
         
        
       
        if(matchFound)
            return 3;
        else if(matchFound2)
            return 2;
        return -1;
        
        
    }
    
    public void validaEmail(FacesContext context, UIComponent componente, Object objeto) throws ValidatorException{
        
         String email = (String)objeto;
        Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();

        
        Pattern p2 =  Pattern.compile("[a-z]{3,255}@[a][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m2 = p2.matcher(email); 
         boolean matchFound2 = m2.matches();
 
         
        
       
        if(!matchFound && !matchFound2){
        
           ((UIInput)componente).setValid(false);
            FacesMessage message = new FacesMessage("Email inválido.");
            context.addMessage(componente.getClientId(context),message);
        }
    }
        
         public void consultaLogin(FacesContext context, UIComponent componente, Object objeto) throws ValidatorException, LivrariaDAOException{
        
         
          String email = (String)objeto;
          InterfaceUsuariosDAO idao = new LivrariaDAO();
          
        
       
        if(idao.procurarLogin(email) != null){
        
           ((UIInput)componente).setValid(false);
            FacesMessage message = new FacesMessage("Email já existe!");
            context.addMessage(componente.getClientId(context),message);
        }
        
        
        
        
        
    }
         
         public Usuario consultaLoginAux(String email) throws ValidatorException, LivrariaDAOException{
        
         
          InterfaceUsuariosDAO idao = new LivrariaDAO();
          
        return idao.procurarLogin(email);
        
        
        
         }
         
   
         
         
 public Usuario atualizaUsuario()throws LivrariaDAOException{
           InterfaceUsuariosDAO  idao = new LivrariaDAO();
           idao.atualizarUsuario(usuario);
        
           return null;      
     }
    
    
}
