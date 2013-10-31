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
public class ValidaISBN implements Validator{
    
    @Override
    public void validate(FacesContext context, UIComponent componente, Object objeto) throws ValidatorException{
        
        String isbnDigitado = (String)objeto;
        Pattern p =  Pattern.compile("\\[978]{3}-\\d{1,2}-\\d{3,5}-\\d{3,4}-[0-9xX]{1}");
        Matcher m = p.matcher(isbnDigitado);
        boolean matchFound = m.matches();
        
        if(!matchFound){
            FacesMessage message = new FacesMessage();
            message.setDetail("ISBN invalido");
            message.setSummary("ISBN inválido");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        
    }
    
    
    
    
    
    
    
}
