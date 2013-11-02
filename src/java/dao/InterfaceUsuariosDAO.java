/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Usuario;
import java.util.List;

/**
 *
 * @author jcrbsa
 */
public interface InterfaceUsuariosDAO {
    
    void atualizarUsuario(Usuario usuario) throws LivrariaDAOException;
    void excluirUsuario(Usuario usuario) throws LivrariaDAOException;
    void salvarUsuario(Usuario usuario) throws LivrariaDAOException;
    List todosUsuario() throws LivrariaDAOException;    
    void atualizarTodosUsuario(List<Usuario> usuario) throws LivrariaDAOException;
}
