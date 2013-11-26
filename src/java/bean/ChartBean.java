/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jcrbsa
 */
import dao.InterfaceLivrosDAO;
import dao.LivrariaDAO;
import dao.LivrariaDAOException;
import java.io.Serializable;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;  
import org.primefaces.model.chart.ChartSeries;  

@ManagedBean(name = "chartBean", eager = true)
@SessionScoped

public class ChartBean implements Serializable {  
  
    private CartesianChartModel categoryModel;  
  
    public ChartBean()  {  
        createCategoryModel();  
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
  
    private void createCategoryModel()  {  
        categoryModel = new CartesianChartModel();  
      InterfaceLivrosDAO idao;
        try {
            idao = new LivrariaDAO();
            
                  ChartSeries aluno = new ChartSeries();  
        aluno.setLabel("Aluno");  

  
        aluno.set("Usuario", idao.totalLivrosReservados(2));  

       
        
        ChartSeries professor = new ChartSeries();  
        professor.setLabel("Professor");  
  
        professor.set("Usuario", idao.totalLivrosReservados(3));  
       
 
             categoryModel.addSeries(aluno);  
        categoryModel.addSeries(professor);  
            
            
        } catch (LivrariaDAOException ex) {
            Logger.getLogger(ChartBean.class.getName()).log(Level.SEVERE, null, ex);
        }

  
  
      
    }  
}  