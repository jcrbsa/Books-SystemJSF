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
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jcrbsa
 */
public class Test {
     public static final ArrayList<Livros> employees = new ArrayList<Livros>();
     public Test(){
   
     }
    public static void main(String[] args) throws LivrariaDAOException {

      /*  InterfaceLivrosDAO test = new LivrariaDAO();
         List<Livros> list = new ArrayList<Livros>();
         list = test.todosLivros();
         for (Iterator<Livros> it = list.iterator(); it.hasNext();) {
            Livros livros = it.next();
            employees.add(livros);
        }
         System.out.println("Livros Adicionados no ArrayList<LIvros>...");
         System.out.println("Livros Armazenado no Array");
         for (int i = 0; i <  employees.size(); i++) {
             System.out.println(employees.get(i).getTitulo());
            
        }*/
        
        
        Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher("rbsa@recife.ifpe.edu.br");
     
        if (!m.matches()) {
               System.out.println( m.matches()); 
        }
       
        
    
    }
}
