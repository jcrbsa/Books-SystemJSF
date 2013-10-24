/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author richardsonandrade
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;



public  class ConverteAnoMySQL implements Converter {
    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException{
        
        String formatado = null;
        if(value == null)
            return null;
        Date date = null;
        
        try{
            DateFormat df = new SimpleDateFormat("yyyy");
            date = (Date) df.parse(value);
            formatado = df.format(date);
        }catch (ParseException pe){
            throw new ConverterException("Data no formato inválido");
        }
        
        return formatado;
    }
          

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
             DateFormat df = new SimpleDateFormat("yyyy");
         
         Date date = null;
         try{
             date =(Date) df.parse((String) value);
         }catch (ParseException ex){
             ex.printStackTrace();
         }
         String formatado = df.format(date);
         return formatado;
    }



    
    
}
