/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author richardsonandrade
 */
public class Livros implements java.io.Serializable{
    
    
    private String isbn;
    private String titulo;
    private int edicao;
    private String publicacao;
    private String descricao;
    private String autor;
    
    private boolean canEdit;

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
       
    }
    
    public Livros(String isbn, String titulo,String autor, int edicao, String publicacao, String descricao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.descricao = descricao;
        this.canEdit = false;
        this.autor = autor;
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
