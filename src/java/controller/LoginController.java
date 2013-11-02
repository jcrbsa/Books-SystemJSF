/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Usuario;
import dao.InterfaceLivrosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jcrbsa
 */
public class LoginController {
    
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String checkLogin() throws LivrariaDAOException{
        
        
        Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher(login);
        boolean matchFound = m.matches();
        FacesContext context = FacesContext.getCurrentInstance(); 
        String forward = "login";
        
        Pattern p2 =  Pattern.compile("[a-z]{3,255}@[a][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m2 = p2.matcher(login); 
         boolean matchFound2 = m2.matches();
         
         Pattern p3 =  Pattern.compile("[a][d][m][i][n]@[a][d][m][i][n][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m3 = p3.matcher(login); 
         boolean matchFound3 = m3.matches();
         
         
        
       
        if(!matchFound && !matchFound2 && !matchFound3){
     
            FacesMessage message  = new FacesMessage("email inválido.");
                       context.addMessage("formulario", message);
        }else{
              InterfaceLivrosDAO  idao = new LivrariaDAO();
              Usuario user = idao.procurarLogin(login);
            if (user != null){  
                if(password.equals(user.getSenha())){
                    if(matchFound || matchFound2)
                    forward = "sessionUser";
                    else
                        forward ="sessionAdmin";
                        
                }else{
                    
            FacesMessage message  = new FacesMessage("Senha Incorreta");
                                    context.addMessage("formulario", message);

                }
            }else{
             FacesMessage message  = new FacesMessage("Usuário não Cadastrado");
                                     context.addMessage("formulario", message);

            }
        }

        
      return forward;
    }
    
    public String checkCadastro() throws LivrariaDAOException{
        
         Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher(login);
        boolean matchFound = m.matches();
        FacesContext context = FacesContext.getCurrentInstance(); 

        Pattern p2 =  Pattern.compile("[a-z]{3,255}@[a][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m2 = p2.matcher(login); 
         boolean matchFound2 = m2.matches();
         
         
         
         FacesMessage message  = null;
       
        if(!matchFound && !matchFound2){
     
           message = new FacesMessage("email inválido.");
     
        }else{
        
            
              InterfaceLivrosDAO  idao = new LivrariaDAO();
               Usuario user = idao.procurarLogin(login);
            if ( user != null){  
                
             message = new FacesMessage("Login já existe");

            }else{
                int tipo ;
             if(matchFound){
                tipo = 3;
             }else{
                tipo = 2;
             }
            
              idao = new LivrariaDAO();
              idao.inserirLogin(login,password,tipo);
              message = new FacesMessage("Cadastro realizado com sucesso!");
            }
        }        context.addMessage("formulario", message);

        
        
        
        return "login";
    }
    
    
}
