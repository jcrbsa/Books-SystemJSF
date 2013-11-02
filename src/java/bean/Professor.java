/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author jcrbsa
 */
public class Professor extends Usuario {

    private Date dataLimite;

    Professor(String st, Date dt) {
        super(st);
        dataLimite = dt;
    }

    public void renovaCartao(Date dt) {
        dataLimite = dt;
    }

    public boolean isRegular() {
        Date hoje = new Date();
        return (dataLimite.after(hoje));
    }

    public boolean isARenovar() {
        return (!isRegular());
    }

    public int getCotaMaxima() {
        return (isRegular() ? 5 : super.getCotaMaxima());
    }

    public int getPrazoMaximo() {
        return (isRegular()
                ? 14 : super.getPrazoMaximo());
    }
}
