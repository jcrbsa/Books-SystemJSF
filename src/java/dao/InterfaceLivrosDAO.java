/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Livros;
import bean.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author richardsonandrade
 */
public interface InterfaceLivrosDAO {
    
    void atualizar(Livros livro) throws LivrariaDAOException;
    void excluir(Livros livro) throws LivrariaDAOException;
    void salvar(Livros livro) throws LivrariaDAOException;
    List todosLivros() throws LivrariaDAOException;
    Livros procurarLivro(String isbn) throws LivrariaDAOException;
    
   ArrayList<Livros>  procurarLivroAutor(String autor) throws LivrariaDAOException;
   ArrayList<Livros>  procurarLivroTitulo(String titulo) throws LivrariaDAOException;

    void atualizarTodos(List<Livros> livro) throws LivrariaDAOException;

    
}
