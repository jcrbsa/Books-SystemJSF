/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import dao.InterfaceLivrosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import bean.Livros;
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
 * @author richardsonandrade
 */

public class LivrosController implements Serializable  {

  
    private String isbn;
    private String titulo;
    private int edicao;
    private String publicacao;
    private String descricao;

    private Livros livro;
    
   public DataModel<Livros> model;
   public static final ArrayList<Livros> array = new ArrayList<Livros>();


 

    public String novoLivro(){
        this.setLivro(new Livros());
        return "novo";
    }
    
    public Livros getLivro() {
        return livro;
    }
    
    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public DataModel<Livros> getModel() {
        return model;
    }
    
   public void setModel(DataModel<Livros> model) {
        this.model = model;
    }
   
    
   public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
   
 
      public static ArrayList<Livros> getArray() {
        return array;
    }
        
    public DataModel todos() throws LivrariaDAOException{
        InterfaceLivrosDAO  idao = new LivrariaDAO();
        List<Livros> test = idao.todosLivros();
        model =  (new ListDataModel<Livros>(test));
        return model;
    }

     public Livros getLivroFromEditOrDelete() throws LivrariaDAOException{
        Livros livro =  (Livros)model.getRowData();
        return livro;

    }
     
     public String editar()throws LivrariaDAOException{
           Livros livro =  getLivroFromEditOrDelete();
           setLivro(livro);
        return "editar";
         
     }

      public String update()throws LivrariaDAOException{
           InterfaceLivrosDAO  idao = new LivrariaDAO();
           idao.atualizar(livro);
        return "sucesso_atu";      
     }   
        public String excluir()throws LivrariaDAOException{
           InterfaceLivrosDAO  idao = new LivrariaDAO();
           Livros livro =  getLivroFromEditOrDelete();
           idao.excluir(livro);
           return "sucesso_exc";
         
     }
   
         public String create()throws LivrariaDAOException{
           InterfaceLivrosDAO  idao = new LivrariaDAO();  
           idao.salvar(livro);
           return "sucesso_ins";     
     }

     public String addLivros()throws LivrariaDAOException {		 
      Livros livro = new Livros(isbn,titulo, edicao,publicacao, descricao);
           array.add(livro);
  
           InterfaceLivrosDAO  idao = new LivrariaDAO();  
           idao.salvar(livro);
      return null;
   }

   public String deleteLivros(Livros livro)throws LivrariaDAOException {
       
        array.remove(livro);
        InterfaceLivrosDAO  idao = new LivrariaDAO();
        idao.excluir(livro);	
      
      return null;
   }

   public String editLivros(Livros livro)throws LivrariaDAOException{

      livro.setCanEdit(true);
      return null;
   }

   public String saveLivros()throws LivrariaDAOException{
       
       InterfaceLivrosDAO  idao = new LivrariaDAO();
           
      for (Livros livro : array){
         livro.setCanEdit(false);
      }		
      idao.atualizarTodos(array);

      return null;
   }
   
         
  
    public ArrayList<Livros> showLivros() throws LivrariaDAOException {
     InterfaceLivrosDAO test = new LivrariaDAO();
         List<Livros> list = new ArrayList<Livros>();
         list = test.todosLivros();
         
       if( array.isEmpty()){
        for (Livros livros : list) {
            array.add(livros);
        }
       }
        return array;
}

     public void validaISBN(FacesContext context, UIComponent componente, Object objeto) throws ValidatorException{
        
        String isbnDigitado = (String)objeto;
        Pattern p =  Pattern.compile("\\d{1,3}-\\d{1,2}-\\d{3,5}-\\d{3,4}-[0-9xX]{1}");
        Matcher m = p.matcher(isbnDigitado);
        boolean matchFound = m.matches();
        
        if(!matchFound){
            ((UIInput)componente).setValid(false);
            FacesMessage message = new FacesMessage("ISBN inválido.");
            context.addMessage(componente.getClientId(context),message);
        }
        
    }
    
    



}
