/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jcrbsa
 */
import java.util.Date;
class Aluno extends Usuario {
private Date dataLimite;
Aluno (String st, Date dt) {
super (st);
dataLimite=dt;
}
public void renovaCartao (Date dt) {
dataLimite=dt;
}
public boolean isRegular () {
Date hoje=new Date();
return(dataLimite.after(hoje));
}
public boolean isARenovar() { return(!isRegular()); }

public int getCotaMaxima(){ 
    return (isRegular() ? 3 : super.getCotaMaxima()); }
public int getPrazoMaximo()
{ return (isRegular() ?
7 : super.getPrazoMaximo()); } 
}