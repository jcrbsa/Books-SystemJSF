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

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.ArrayDataModel;
/**
 *
 * @author richardsonandrade
 */
public class LivrosController  {

    private Livros livro;
    
    public DataModel<Livros> model;
    

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
        
    public DataModel todos() throws LivrariaDAOException{
        InterfaceLivrosDAO  idao = new LivrariaDAO();
        List<Livros> test = idao.todosLivros();
        model =  (new ListDataModel<Livros>(test));

       
        return model;
    }
    
   	
    
     public Livros getLivroFromEditOrDelete() throws LivrariaDAOException{
        Livros livro =  (Livros)getModel().getRowData();
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
           Livros livro =  getLivroFromEditOrDelete();
           idao.salvar(livro);
           return "sucesso_ins";
         
     }

      
      
      
      
      
     
     
     
        
    
}
