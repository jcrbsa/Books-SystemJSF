/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package meupacote;

import bean.Livros;
import dao.InterfaceLivrosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jcrbsa
 */
public class Test {
    public static void main(String[] args) throws LivrariaDAOException {
        
        InterfaceLivrosDAO test = new LivrariaDAO();
         List<Livros> list = new ArrayList<Livros>();
         list = test.todosLivros();
        for (Livros livro : list) {
           System.out.println(livro.getTitulo());
        }
        
    }
    
}
