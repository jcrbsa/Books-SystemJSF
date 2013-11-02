/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author jcrbsa
 */
public class ValidaEmail implements Validator {
    
    
     @Override
    public void validate(FacesContext context, UIComponent componente, Object objeto) throws ValidatorException{
        
         String email = (String)objeto;
        Pattern p =  Pattern.compile("[a-z]{3,255}@[r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();

        
        Pattern p2 =  Pattern.compile("[a-z]{3,255}@[a][.][r][e][c][i][f][e][.][i][f][p][e][.][e][d][u][.][b][r]");
        Matcher m2 = p2.matcher(email); 
         boolean matchFound2 = m2.matches();
 
         
        
       
        if(!matchFound && !matchFound2){
        
            FacesMessage message = new FacesMessage();
            message.setDetail("Email invalido");
            message.setSummary("Email inválido");
            throw new ValidatorException(message);
        }
        
    }
    
}
