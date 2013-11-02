/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Usuario;
import dao.InterfaceUsuariosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.DataModel;

/**
 *
 * @author jcrbsa
 */
public class UsuariosController {
    
    
     private String nome;
    private String email;
        
    private String senha;
    private boolean canEdit;
    
     private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   public static final ArrayList<Usuario> array = new ArrayList<Usuario>();

    

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
   
      public String addUsuario()throws LivrariaDAOException {		 
      Usuario usuario = new Usuario(nome,email,senha);
           array.add(usuario);
  
           InterfaceUsuariosDAO  idao = new LivrariaDAO();  
           idao.salvarUsuario(usuario);
      return null;
   }

   public String deleteUsuario(Usuario usuario)throws LivrariaDAOException {
       
        array.remove(usuario);
        InterfaceUsuariosDAO  idao = new LivrariaDAO();
        idao.excluirUsuario(usuario);	
      
      return null;
   }

   public String editUsuario(Usuario usuario)throws LivrariaDAOException{

      usuario.setCanEdit(true);
      return null;
   }

   public String saveUsuario()throws LivrariaDAOException{
       
       InterfaceUsuariosDAO idao = new LivrariaDAO();
           
      for (Usuario usuario : array){
         usuario.setCanEdit(false);
      }		
      idao.atualizarTodosUsuario(array);

      return null;
   }
   
         
  
    public ArrayList<Usuario> showUsuario() throws LivrariaDAOException {
     InterfaceUsuariosDAO test = new LivrariaDAO();
         List<Usuario> list = new ArrayList<Usuario>();
         list = test.todosUsuario();
         
       if( array.isEmpty()){
        for (Usuario usuarios : list) {
            array.add(usuarios);
        }
       }
        return array;
}
    
    
    
}
