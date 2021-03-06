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
   int totalDeLivros() throws LivrariaDAOException;
   void solicitarLivros(String login, String isbn, int quantidade, int tipo_usuario)throws LivrariaDAOException;
    ArrayList<Livros> livrosPedidos(String login)throws LivrariaDAOException; 
   int quantidadelLivrosUsuario(String email)throws LivrariaDAOException;
  
     int totalLivrosReservados(int cod_usuario)throws LivrariaDAOException;
   int totalLivrosLiberados(int cod_usuario)throws LivrariaDAOException;

  ArrayList<Livros> livrosReservadosAluno(int i, String aluno)throws LivrariaDAOException;

    ArrayList<Livros> livrosReservadosProfessor(int i, String professor)throws LivrariaDAOException;

void emprestarLivro (String isbn, boolean emprestimo)throws LivrariaDAOException;

int totalAlunos()throws LivrariaDAOException;
}

