/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;
/**
 *
 * @author richardsonandrade
 */
public class Livros implements Serializable{
    
    
    private String isbn;
    private String titulo;
    private int edicao;
    private String publicacao;

    private String autor;
    private boolean selecionado;
    private boolean selected;
    private int num_exemplar;
    private int cod_exemplar;
    private String emailSolicitante;
    private boolean liberado;
    private String devolucao;

    public String getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(String devolucao) {
        this.devolucao = devolucao;
    }
    

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

   

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }

    public int getCod_exemplar() {
        return cod_exemplar;
    }

    public void setCod_exemplar(int cod_exemplar) {
        this.cod_exemplar = cod_exemplar;
    }

    public int getNum_exemplar() {
        return num_exemplar;
    }

    public void setNum_exemplar(int num_exemplar) {
        this.num_exemplar = num_exemplar;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    private boolean canEdit;

    public boolean isCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }
    private boolean  checkBox;

    public boolean isCanEdit() {
        return canEdit;
    }

    public Livros() {
    }
    
    
    public Livros(String isbn, String emailUsuario, boolean liberado) {
        this.checkBox = false;
        this.isbn = isbn;
        this.emailSolicitante = emailUsuario;
        this.liberado = liberado;
        this.checkBox = false;
        
    }

    public Livros(String isbn, String titulo, int edicao, String publicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
    
        this.canEdit = false; 
        this.selected = false;
    }
    
    
  
  
    
    public Livros(String isbn, String titulo,String autor, int edicao, String publicacao, boolean selecionado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;

        this.canEdit = false;
        this.autor = autor;
        this.selecionado = selecionado;
                this.selected = false;

    }
    
    
     public Livros(String isbn, String titulo,String autor, int edicao, String publicacao, String devolucao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
   
        this.canEdit = false;
        this.autor = autor;
        this.selecionado = selecionado;
        this.selected = false;
        this.devolucao = devolucao;

    }
     

     
     


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    /**
     * @return the publicacao
     */
    public String getPublicacao() {
        return publicacao;
    }

    /**
     * @param publicacao the publicacao to set
     */
    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    

   public void setCanEdit(boolean canEdit) {
      this.canEdit = canEdit;
   }
    
    
}
