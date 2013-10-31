/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jcrbsa
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

class Livro {

    private String titulo;
    private Usuario retiradoPor;
    private Date dtEmprestimo;
    private Date dtDevolucao;
    private Usuario bloqueadoPor;
    private Date dtBloqueio;
    private Date dtDesbloqueio;

    public boolean isEmprestado() {
        return (!(retiradoPor == null));
    }

    public boolean isEmAtraso() {
        Date hoje = new Date();
        return (isEmprestado()
                && dtDevolucao.before(hoje));
    }

    public boolean isBloqueado() {
        Date hoje = new Date();
        return (retiradoPor == null
                && !(bloqueadoPor == null)
                && !(dtDesbloqueio.before(hoje)));
    }

    public boolean isDisponivel() {
        Date hoje = new Date();
        return (retiradoPor == null
                && (bloqueadoPor == null
                || dtDesbloqueio.before(hoje)));
    }

    public boolean bloqueia(Usuario u, int prazo) {
        GregorianCalendar cal = new GregorianCalendar();
        if (isDisponivel() && u.isProfessor()) {
            bloqueadoPor = u;
            dtBloqueio = cal.getTime();
            cal.add(Calendar.DATE, (prazo > 20 ? 20 : prazo));
            dtDesbloqueio = cal.getTime();
            return (true);
        } else {
            return (false);
        }
    }

    public boolean desbloqueia(Usuario u) {
        if (u == bloqueadoPor) {
            bloqueadoPor = null;
            return (true);
        } else {
            return (false);
        }
    }

    public boolean empresta(Usuario u, int prazo) {
        GregorianCalendar cal = new GregorianCalendar();
        if (isDisponivel()) {
            retiradoPor = u;
            dtEmprestimo = cal.getTime();
            cal.add(Calendar.DATE, prazo);
            dtDevolucao = cal.getTime();
            return (true);
        } else {
            return (false);
        }
    }
}
