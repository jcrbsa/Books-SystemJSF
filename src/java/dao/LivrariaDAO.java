/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Livros;
import bean.Usuario;
import java.util.List;
import util.ConnectionLivrariaFactory;


//import util.ConnectionLivrariaFactory;
/**
 *
 * @author richardsonandrade
 */
public class LivrariaDAO implements InterfaceLivrosDAO, InterfaceUsuariosDAO {

    private Connection conn;

    public LivrariaDAO() throws LivrariaDAOException {
        try {
            this.conn = ConnectionLivrariaFactory.getConnection();
        } catch (Exception e) {
            throw new LivrariaDAOException("Erro: " + ":\n" + e.getMessage());
        }
    }

 @Override
    public void salvar(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
                if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
                }
            try {
                String SQL = "INSERT INTO livros(isbn,titulo,edicao_num,ano_publicacao,descricao)"
                        + "values(?,?,?,?,?)";
                conn = this.conn;

                ps = conn.prepareStatement(SQL);
                ps.setString(1, livro.getIsbn());
                ps.setString(2, livro.getTitulo());
                ps.setInt(3, livro.getEdicao());
                ps.setString(4, livro.getPublicacao());
                ps.setString(5, livro.getDescricao());
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao inserir dados" + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
        }
    

    @Override
    public void excluir(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
            } try{
                conn = this.conn;
                String SQL = "DELETE FROM livros WHERE  isbn =?";

                ps = conn.prepareStatement(SQL);
                ps.setString(1, livro.getIsbn());

                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao excluir dados" + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
        }
    

    @Override
    public void atualizar(Livros livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
            try {
            
                String SQL = "UPDATE livros SET titulo=?," + "edicao_num=?," + "ano_publicacao=?, descricao=?" + "WHERE isbn=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1, livro.getTitulo());
                ps.setInt(2, livro.getEdicao());
                ps.setString(3, livro.getPublicacao());
                ps.setString(4, livro.getDescricao());
                ps.setString(5, livro.getIsbn());

                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
        }
    
    @Override
    public void atualizarTodos(List<Livros> livro) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (livro == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
            try {
                for (Livros livros : livro) {
                    
                
            
                String SQL = "UPDATE livros SET titulo=?," + "edicao_num=?," + "ano_publicacao=?, descricao=?" + "WHERE isbn=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1, livros.getTitulo());
                ps.setInt(2, livros.getEdicao());
                ps.setString(3, livros.getPublicacao());
                ps.setString(4, livros.getDescricao());
                ps.setString(5, livros.getIsbn());

                ps.executeUpdate();
                }
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            } /*finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }*/
        }
    
    

    @Override
    public List todosLivros() throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM livros");
            
            rs= ps.executeQuery();
            List<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
                String isbn = rs.getString(1);
                String titulo = rs.getString(2);
                int edicao = rs.getInt(3);
                String publicacao = rs.getString(4);
                String descricao = rs.getString(5);
                list.add(new Livros(isbn, titulo, edicao, publicacao, descricao));
            }
            return list;

        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public Livros procurarLivro(String isbn) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Livros livro = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM livros WHERE isbn =?");
             ps.setString(1,isbn);
            rs = ps.executeQuery();
             if (rs.next()) {
            String titulo = rs.getString(2);
            int edicao = rs.getInt(3);
            String publicacao = rs.getString(4);
            String descricao = rs.getString(5);
            livro =  new Livros(isbn, titulo, edicao, publicacao, descricao);

             }
             
            return livro; 
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }



    }

    @Override
    public Usuario procurarLogin(String email) throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
         Usuario user = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM user WHERE login =?");
            ps.setString(1,email);
    
            rs = ps.executeQuery();
            
            if (rs.next()) {
            
             email = rs.getString(2);
             String senha = rs.getString(3);
              user = new Usuario(email,senha);
              
            }
            
            return user;
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
        
    }

    @Override
    public void inserirLogin(String email, String senha, int tipo) throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
           
            try {
                String SQL = "INSERT INTO user(login,senha,tipo)"
                        + "values(?,?,?)";
                conn = this.conn;

                ps = conn.prepareStatement(SQL);
                ps.setString(1, email);
                ps.setString(2, senha);
                ps.setInt(3, tipo);
               
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao inserir dados" + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
    
    }

    @Override
    public void atualizarUsuario(Usuario usuario) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
            try {
                                    
          
                String SQL = "UPDATE user SET nome=?,"  + "senha=?" + "WHERE loginn=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getEmail());
               

                ps.executeUpdate();
                
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            } /*finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }*/

    }

    @Override
    public void excluirUsuario(Usuario usuario) throws LivrariaDAOException {
PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
            } try{
                conn = this.conn;
                String SQL = "DELETE FROM user WHERE  login =?";

                ps = conn.prepareStatement(SQL);
                ps.setString(1, usuario.getEmail());

                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao excluir dados" + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
    
    }

    @Override
    public void salvarUsuario(Usuario usuario) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
                if (usuario == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
                }
            try {
                String SQL = "INSERT INTO user(nome,login,senha,tipo)"
                        + "values(?,?,?,?)";
                conn = this.conn;

                ps = conn.prepareStatement(SQL);
                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getEmail());
                ps.setString(3, usuario.getSenha());
                ps.setInt(4, usuario.getTipo());

                
                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao inserir dados" + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
        
    }

    @Override
    public List todosUsuario() throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM user");
            
            rs= ps.executeQuery();
            List<Usuario> list = new ArrayList<Usuario>();
            while (rs.next()) {
                String nome = rs.getString(1);
                String email = rs.getString(2);
                String senha = rs.getString(3);
             
                list.add(new Usuario(nome, email, senha));
            }
            return list;

        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
        
        
    }

    @Override
    public void atualizarTodosUsuario(List<Usuario> usuario) throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
            try {
                for (Usuario usuarios : usuario) {
                    
                
            
                String SQL = "UPDATE user SET nome=?,"  + "senha=?" + "WHERE login=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1, usuarios.getNome());
                ps.setString(2, usuarios.getSenha());
                ps.setString(3, usuarios.getEmail());
                

                ps.executeUpdate();
                }
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            } /*finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }*/
        
    }

    @Override
    public ArrayList<Livros>  procurarLivroAutor(String autor) throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM livros WHERE autor =?");
             ps.setString(1,autor);
            rs= ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
            String isbn = rs.getString("isbn");
            String titulo = rs.getString("titulo");
            int edicao = rs.getInt("edicao_num");
            String publicacao = rs.getString("ano_publicacao");
            String descricao = rs.getString("descricao");
            list.add(new Livros(isbn, titulo,autor, edicao, publicacao, descricao));

             }
             
            return list; 
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
        
        
    
    }

    @Override
    public ArrayList<Livros> procurarLivroTitulo(String titulo) throws LivrariaDAOException {
        
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
    
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM livros WHERE titulo =?");
             ps.setString(1,titulo);
            rs = ps.executeQuery();
                ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
            String isbn = rs.getString("isbn");
            String autor = rs.getString("autor");
            int edicao = rs.getInt("edicao_num");
            String publicacao = rs.getString("ano_publicacao");
            String descricao = rs.getString("descricao");
           
            list.add(new Livros(isbn, titulo,autor, edicao, publicacao, descricao));

             }
             
            return list; 
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    }

    

    

}
