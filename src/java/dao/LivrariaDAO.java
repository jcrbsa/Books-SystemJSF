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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import util.ConnectionLivrariaFactory;


//import util.ConnectionLivrariaFactory;
/**
 *
 * @author richardsonandrade
 */
public class LivrariaDAO implements InterfaceLivrosDAO, InterfaceUsuariosDAO,InterfaceLoginDAO  {

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
                int edicao = rs.getInt("edicao_num");
                String publicacao = rs.getString("ano_publicacao");
                String descricao = rs.getString("descricao");
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
             int qt_livros = rs.getInt("qt_livros");
             int tipo_usuario = rs.getInt("tipo");
             
              user = new Usuario(email,senha, qt_livros, tipo_usuario);
              
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
    public Usuario atualizarUsuario(Usuario usuario) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (usuario == null) {
            throw new LivrariaDAOException("O valor passado não pode ser nulo");
        }
            try {
                                    
          
                String SQL = "UPDATE user SET nome=?,"  + "senha=?" + "WHERE login=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1, usuario.getNome());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getEmail());
               

                ps.executeUpdate();
                
                return usuario;
                
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            }finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }

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
            boolean selecionado =  rs.getBoolean("selecionado");
            list.add(new Livros(isbn, titulo,autor, edicao, publicacao, descricao, selecionado));

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
           boolean selecionado =  rs.getBoolean("selecionado");
            list.add(new Livros(isbn, titulo,autor, edicao, publicacao, descricao, selecionado));

             }
             
            return list; 
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    }

    @Override
    public void atualizarSenha(String login,String senha) throws LivrariaDAOException {

     PreparedStatement ps = null;
        Connection conn = null;
    
            try {
            
                String SQL = "UPDATE user SET senha=? WHERE login=?";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);

                ps.setString(1,senha);
                ps.setString(2, login);
      

                ps.executeUpdate();
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao atualizar dados " + sqle);
            } finally {
                ConnectionLivrariaFactory.closeConnection(conn, ps);
            }
    
    
    
    
    }

    @Override
    public int totalDeLivros() throws LivrariaDAOException{
        
         PreparedStatement ps = null;
          Connection conn = null;
          ResultSet rs = null;
          int total = 0;
            try {
            
            
             conn = this.conn;
            ps =conn.prepareStatement("SELECT COUNT(*) FROM livros");
            
            rs= ps.executeQuery();
            if(rs.next())
                return rs.getInt("count(*)");
            else
                return  0;

        
            } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            //ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
  

    
 
    }

    @Override
    public void solicitarLivros(String login, String isbn, int quantidade,int tipo_usuario) throws LivrariaDAOException {
 PreparedStatement ps = null;
        Connection conn = null;
         
            try {
                String SQL = "INSERT INTO pedidos(id_livro,id_usuario,tipo_usuario) values(?,?,?)";

                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.setString(1,isbn);
                ps.setString(2,login);
                ps.setInt(3,tipo_usuario);
                ps.executeUpdate();
                
                SQL = "UPDATE livros SET selecionado=? WHERE isbn=? ";
                  
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
               ps.setBoolean(1, true);
                ps.setString(2, isbn);
                
                ps.executeUpdate(); 
                
               SQL = "UPDATE user SET qt_livros=? WHERE login=? ";
                  
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.setInt(1, quantidade);
                ps.setString(2, login);
                ps.executeUpdate(); 
                
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao inserir dados" + sqle);
            }
    
    }

    @Override
    public ArrayList<Livros> livrosPedidos(String login) throws LivrariaDAOException {
          PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pedidos p, livros l WHERE p.id_livro = l.isbn and p.id_usuario = ?");
            ps.setString(1,login);
            rs= ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
           String autor = rs.getString("autor");
            String isbn = rs.getString("isbn");
            String titulo = rs.getString("titulo");
            int edicao = rs.getInt("edicao_num");
            String publicacao = rs.getString("ano_publicacao");
            String descricao = rs.getString("descricao");
            String devolucao = rs.getString("devolucao");
            list.add(new Livros(isbn, titulo,autor, edicao, publicacao, descricao, devolucao));

             }
             
            return list; 
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }finally {
            ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
    
    }

    @Override
    public int quantidadelLivrosUsuario(String email) throws LivrariaDAOException {
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
         int qt_livros = -1;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM user WHERE login =?");
            ps.setString(1,email);
    
            rs = ps.executeQuery();
            
            if (rs.next()) {
          
              qt_livros = rs.getInt("qt_livros");
             
            }
            
            return qt_livros;
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } 
        
    
    
    }

    @Override
    public ArrayList<Livros> mostrarExemplares(String isbn) throws LivrariaDAOException {
   
         PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM exemplar WHERE isbn =?");
             ps.setString(1,isbn);
            rs= ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
          
            boolean selecionado =  rs.getBoolean("situacao");
            int num_exemplar = rs.getInt("num_exemplar");
            int cod_exemplar = rs.getInt("cod_exemplar");
            list.add(new Livros(num_exemplar, selecionado,cod_exemplar));

             }
             
            return list; 
        
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }
        
    
    }

    @Override
    public void atualizarExemplares(int cod_exemplar, boolean situacao) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
         
            try {
            
                String SQL = "UPDATE exemplar SET situacao=? WHERE cod_exemplar=? ";
                  
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
               ps.setBoolean(1, situacao);
                ps.setInt(2, cod_exemplar);
                
                ps.executeUpdate(); 
                
               
                
            } catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao inserir dados" + sqle);
            }
        
        
        
    }

    @Override
    public int totalLivrosReservados(int cod_usuario) throws LivrariaDAOException {
        
               PreparedStatement ps = null;
          Connection conn = null;
          ResultSet rs = null;
          int total = 0;
            try {
            
            
             conn = this.conn;
            ps =conn.prepareStatement("SELECT COUNT(*) FROM pedidos WHERE tipo_usuario=?");
            ps.setInt(1, cod_usuario );
            rs= ps.executeQuery();
            if(rs.next())
                return rs.getInt("count(*)");
            else
                return  0;

        
            } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            //ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
        
    }
    
    @Override
    public int totalLivrosLiberados(int cod_usuario) throws LivrariaDAOException {
        
               PreparedStatement ps = null;
          Connection conn = null;
          ResultSet rs = null;
          int total = 0;
            try {
            
            
             conn = this.conn;
            ps =conn.prepareStatement("SELECT COUNT(*) FROM pedidos WHERE tipo_usuario=? AND liberado=1");
            ps.setInt(1, cod_usuario );
            rs= ps.executeQuery();
            if(rs.next())
                return rs.getInt("count(*)");
            else
                return  0;

        
            } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } finally {
            //ConnectionLivrariaFactory.closeConnection(conn, ps, rs);
        }
        
    }
    
    

    @Override
    public ArrayList<Livros> livrosReservadosAluno(int i, String aluno) throws LivrariaDAOException {
        
          PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pedidos WHERE tipo_usuario=? AND id_usuario=?");
             ps.setInt(1,i);
             ps.setString(2, aluno);
            rs= ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
          
            boolean selecionado =  rs.getBoolean("liberado");
            int num_exemplar = rs.getInt("id_usuario");
            int cod_exemplar = rs.getInt("id_livro");
            list.add(new Livros(num_exemplar, selecionado,cod_exemplar));

             }
             
            return list; 
        
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }
    }

    @Override
    public ArrayList<Livros> livrosReservadosProfessor(int i, String professor) throws LivrariaDAOException {
          PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pedidos WHERE tipo_usuario=? AND id_usuario=?");
             ps.setInt(1,i);
             ps.setString(2, professor);
            rs= ps.executeQuery();
            ArrayList<Livros> list = new ArrayList<Livros>();
            while (rs.next()) {
          
            boolean selecionado =  rs.getBoolean("liberado");
            int num_exemplar = rs.getInt("id_usuario");
            int cod_exemplar = rs.getInt("id_livro");
            list.add(new Livros(num_exemplar, selecionado,cod_exemplar));

             }
             
            return list; 
        
        } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        }
    }

    @Override
    public void emprestarLivro(String isbn, boolean emprestimo) throws LivrariaDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL;
         
            try { 
       
                
                SQL = "UPDATE pedidos SET liberado=? WHERE id_livro=? ";
                  
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
               ps.setBoolean(1, true);
                ps.setString(2, isbn);
                
                ps.executeUpdate(); 
                
               SQL = "UPDATE livros SET devolucao=? WHERE isbn=? ";
                  
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                GregorianCalendar cal=new GregorianCalendar();
                cal.add(Calendar.DATE, 7); 
                Date dtDevolucao=cal.getTime();
                String test = new SimpleDateFormat("dd/MM/yyyy").format(dtDevolucao);
                ps.setString(1,test );
                ps.setString(2, isbn);
                ps.executeUpdate(); 
            }catch (SQLException sqle) {
                throw new LivrariaDAOException("Erro ao Atualizar dados" + sqle);
            }
        
    }

    @Override
    public int totalAlunos() throws LivrariaDAOException {
        
        PreparedStatement ps = null;
          Connection conn = null;
          ResultSet rs = null;
         
            try {
            
            
             conn = this.conn;
            ps =conn.prepareStatement("SELECT COUNT(*) FROM user");
            
            rs= ps.executeQuery();
            if(rs.next())
                return rs.getInt("count(*)");
            else
                return  0;

        
            } catch (SQLException sqle) {
            throw new LivrariaDAOException(sqle);
        } 
  
    }

  
    

}
