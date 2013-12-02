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
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;



import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

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
    private String autor;
    private boolean checkBox = false;
    private boolean render =false;
    private String aluno;
    private String professor;
    private int display = 1;

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }
    public void mudaDisplay(int display){
        this.setDisplay(display);
    }
    

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    private Livros livro;
    
   public DataModel<Livros> model;
   public static final ArrayList<Livros> array = new ArrayList<Livros>();

    public ArrayList<Livros> arrayConsulta;
    public static ArrayList<Livros> arrayLivrosSolicitados =  new ArrayList<Livros>();

    public static ArrayList<Livros> getArrayLivrosSolicitados() {
        return arrayLivrosSolicitados;
    }

    public ArrayList<Livros> getArrayConsulta() {
        if(arrayConsulta ==  null){
            System.out.println("NULL getter");
        }
            
        return arrayConsulta;
    }
   
    
public ArrayList<Livros> arrayConsulta2;

    public ArrayList<Livros> getArrayConsulta2() {
        return arrayConsulta2;
    }

    public void setArrayConsulta2(ArrayList<Livros> arrayConsulta2) {
        this.arrayConsulta2 = arrayConsulta2;
    }

   
     
 
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
   
         public String create(UIComponent componente)throws LivrariaDAOException{
           InterfaceLivrosDAO  idao = new LivrariaDAO();  
           idao.salvar(livro);
           return "sucesso_ins";     
     }

     public String addLivros()throws LivrariaDAOException {		 
     
        
       FacesContext context = FacesContext.getCurrentInstance();
  
        if(consultaLivro(isbn)!= null){
           
            FacesMessage message = new FacesMessage("Livro já existe!");
            
            context.addMessage("message_isbn",message);
        }else{
            
       livro = new Livros(isbn,titulo, edicao,publicacao);
           array.add(livro);
  
           InterfaceLivrosDAO  idao = new LivrariaDAO();  
           idao.salvar(livro);
        }
        titulo = "";
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
    public ArrayList<Livros> procuraLivrosAutor() throws LivrariaDAOException {
     InterfaceLivrosDAO test = new LivrariaDAO();

         arrayConsulta  = test.procurarLivroAutor(autor);
      
        return arrayConsulta;
}
    
    public ArrayList<Livros> procuraLivrosTitulo() throws LivrariaDAOException {
     InterfaceLivrosDAO test = new LivrariaDAO();
        
       arrayConsulta = test.procurarLivroTitulo(titulo);

        return arrayConsulta;
}
    public ArrayList<Livros> mostrarLivrosReservadosAluno() throws LivrariaDAOException {
     InterfaceLivrosDAO test = new LivrariaDAO();
        
       arrayConsulta2 = test.livrosReservadosAluno(2, aluno);

        return arrayConsulta2;
}
    
    
     public ArrayList<Livros> mostrarLivrosReservadosProfessor() throws LivrariaDAOException {
     InterfaceLivrosDAO test = new LivrariaDAO();
        
       arrayConsulta2 = test.livrosReservadosProfessor(3, professor);

        return arrayConsulta2;
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
     
     public Livros consultaLivro(String isbn) throws ValidatorException, LivrariaDAOException{
        
         
    
          InterfaceLivrosDAO idao = new LivrariaDAO();
          
        
       
        return idao.procurarLivro(isbn);
                }
         public static ArrayList<Livros> arrayLivrosTest =  new ArrayList<Livros>();

    public static ArrayList<Livros> getArrayLivrosTest() {
        return arrayLivrosTest;
    }

    public static void setArrayLivrosTest(ArrayList<Livros> arrayLivrosTest) {
        LivrosController.arrayLivrosTest = arrayLivrosTest;
    }
     
     public String confereCheckBoxPedido() throws LivrariaDAOException{

              
         InterfaceLivrosDAO idao = new LivrariaDAO();
        
         for (Livros livro : arrayConsulta2){
             if(livro.isCheckBox() == true){
                 
             idao.emprestarLivro( livro.getIsbn(), true);
             arrayLivrosTest.add(livro);
           
             }
      }	
         
     return null;
     }
     
     public String confereCheckBox(String email, int quantidade,int tipo) throws LivrariaDAOException{

              
         InterfaceLivrosDAO idao = new LivrariaDAO();
         String test = email;
         for (Livros livro : arrayConsulta){
             if(livro.isCheckBox() == true){
                 quantidade++;
                 if(quantidade <= 3){
             idao.solicitarLivros(test, livro.getIsbn(), quantidade, tipo);
             arrayLivrosSolicitados.add(livro);
               render = true;
                 }
             }
      }	
         
     return null;
     }
     
     
     
      
   public  ArrayList<Livros> consultarLivrosPedidos(String email) throws LivrariaDAOException{
    InterfaceLivrosDAO idao = new LivrariaDAO();
     
       List<Livros> list = new ArrayList<Livros>();
       list = idao.livrosPedidos(email);
        
   
    
       if( arrayLivrosSolicitados.isEmpty()){
        for (Livros livros : list) {
            arrayLivrosSolicitados.add(livros);
        }
       }
           
     
    return arrayLivrosSolicitados; 
}
 
         
 public int consultaQuantidadelLivrosUsuario(String email) throws LivrariaDAOException{
     
         InterfaceLivrosDAO idao = new LivrariaDAO();
            return idao.quantidadelLivrosUsuario(email);
 }        
 
 
  
         
 
    public String sair(){
        
        autor = "";
        titulo = "";
        aluno = "";
        professor = "";
        arrayLivrosSolicitados.clear();
        display = 1;
        return "login";
        
    }
     
     
private int maxPorPagina =3;
private int paginaAtual=0;


public int getTotal() throws LivrariaDAOException{
    InterfaceLivrosDAO idao = new LivrariaDAO();
    
    return idao.totalDeLivros();
}
    public int getMaxPorPagina() {
        return maxPorPagina;
    }

    public void setMaxPorPagina(int maxPorPagina) {
        this.maxPorPagina = maxPorPagina;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    
public String pPrimeiraPagina(){
    
    paginaAtual = 0;

        System.out.println("<< Pagina Atual" +  paginaAtual);

    return "crudLivros";
}

public String pPaginaAnterior(){
    
    paginaAtual -= maxPorPagina;
        if(paginaAtual < 0 ){
            paginaAtual =0;
        }
    System.out.println("< Pagina Atual" +  paginaAtual);
    return "crudLivros";
}

public String pProximaPagina() throws LivrariaDAOException{
    
    paginaAtual += maxPorPagina;
        if(paginaAtual >= getTotal() ){
            paginaAtual = getTotal() - maxPorPagina;
            
        }
          if(paginaAtual < 0 ){
            paginaAtual =0;
        }
    System.out.println("> Pagina Atual" +  paginaAtual);
    
    return "crudLivros";
}

public String pUltimaPagina() throws LivrariaDAOException{
    

            paginaAtual = getTotal() - maxPorPagina;
            
          if(paginaAtual < 0 ){
            paginaAtual =0;
        }
    System.out.println(">> Pagina Atual" +  paginaAtual);
    
    return "crudLivros";
}

public String pPrimeiraPaginaUser(){
    
    paginaAtual = 0;


    return "sessionUser";
}

public String pPaginaAnteriorUser(){
    
    paginaAtual -= maxPorPagina;
        if(paginaAtual < 0 ){
            paginaAtual =0;
        }

    return "sessionUser";
}

public String pProximaPaginaUser() throws LivrariaDAOException{
      
       
    paginaAtual += maxPorPagina;
        if(paginaAtual >= arrayConsulta.size() )
        {
            paginaAtual = arrayConsulta.size() - maxPorPagina;
            
        }
          if(paginaAtual < 0 ){
            paginaAtual =0;
        }

        return "sessionUser";
    
              
}

public String pUltimaPaginaUser() throws LivrariaDAOException{
    

    
            paginaAtual = arrayConsulta.size() - maxPorPagina;
            
          if(paginaAtual < 0 ){
            paginaAtual =0;
        }

           
    return "sessionUser";
        
              
    
}





}
