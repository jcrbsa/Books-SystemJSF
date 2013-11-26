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
  private CartesianChartModel categoryModel2; 

  

    public void setCategoryModel2(CartesianChartModel categoryModel2) {
        this.categoryModel2 = categoryModel2;
    }
    public ChartBean()  {  
        createCategoryModel();  
        createCategoryModel2();
    }  
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
      public CartesianChartModel getCategoryModel2() {
        return categoryModel2;
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
    
    private void createCategoryModel2()  {  
        categoryModel2 = new CartesianChartModel();  
      InterfaceLivrosDAO idao;
        try {
            idao = new LivrariaDAO();
            
         ChartSeries aluno = new ChartSeries();  
        aluno.setLabel("Aluno");  

  
        aluno.set("Usuario", idao.totalLivrosLiberados(2));  

       
        
        ChartSeries professor = new ChartSeries();  
        professor.setLabel("Professor");  
  
        professor.set("Usuario", idao.totalLivrosLiberados(3));  
       
 
             categoryModel2.addSeries(aluno);  
        categoryModel2.addSeries(professor);  
            
            
        } catch (LivrariaDAOException ex) {
            Logger.getLogger(ChartBean.class.getName()).log(Level.SEVERE, null, ex);
        }

  
  
      
    }  
    
}  