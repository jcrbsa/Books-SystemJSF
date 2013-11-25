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
    private String descricao;
    private String autor;
    private boolean selecionado;
    private boolean selected;
    private int num_exemplar;
    private int cod_exemplar;

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

    public Livros(String isbn, String titulo, int edicao, String publicacao, String descricao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
        this.canEdit = false; 
        this.selected = false;
    }
    
    
  
  
    
    public Livros(String isbn, String titulo,String autor, int edicao, String publicacao, String descricao, boolean selecionado) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
        this.canEdit = false;
        this.autor = autor;
        this.selecionado = selecionado;
                this.selected = false;

    }
    
    
     public Livros(String isbn, String titulo,String autor, int edicao, String publicacao, String descricao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
        this.canEdit = false;
        this.autor = autor;
        this.selecionado = selecionado;
        this.selected = false;

    }
     
     public Livros(int num_exemplar, boolean selecionado, int cod_exemplar) {
         this.selecionado = selecionado;
         this.num_exemplar =  num_exemplar;
         this.canEdit = false;
         this.cod_exemplar = cod_exemplar;
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

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
 

   public void setCanEdit(boolean canEdit) {
      this.canEdit = canEdit;
   }
    
    
}
