
package meupacote;
import dao.InterfaceLivrosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class Test implements Serializable {

   private static final long serialVersionUID = 1L;
   private  String locale = "pt";

    public static void main(String[] args) throws LivrariaDAOException {
         InterfaceLivrosDAO idao = new LivrariaDAO();
         System.out.println(idao.quantidadelLivrosUsuario("test@recife.ifpe.edu.br"));

    }

   private static Map<String,Object> countries;
   

   static{
      countries = new LinkedHashMap<String,Object>();
           
          countries.put("Português" ,new Locale("pt"));
           countries.put("Inglês" ,Locale.ENGLISH );
           countries.put("Francês" , Locale.FRENCH);
           countries.put("Espanhol" , new Locale("es"));
     
   }
   

   public Map<String, Object> getCountries() {
      return countries;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   //value change event listener
   public void localeChanged(ValueChangeEvent e){
      String newLocaleValue = e.getNewValue().toString();
      for (Map.Entry<String, Object> entry : countries.entrySet()) {
         if(entry.getValue().toString().equals(newLocaleValue)){
            FacesContext.getCurrentInstance()
               .getViewRoot().setLocale((Locale)entry.getValue());         
         }
      }
   }
}