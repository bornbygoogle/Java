/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.util.Vector;
import beans.PromoBean;

/**
 *
 * @author bornbygoogle
 */
public class ResultatInvalideException extends Exception
{
    private Vector<PromoBean> resultat;
    public ResultatInvalideException(String message, Vector<PromoBean> res)
    {
        super(message);
        this.resultat = res;
    }
    public Vector<PromoBean> getResultat()            {return this.resultat;}
}
