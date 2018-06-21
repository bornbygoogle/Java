/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author bornbygoogle
 */
public class ProduitBeans implements Serializable {
    
    private Vector<ProduitBean> result;
    
    public ProduitBeans() {}
    
    public Vector<ProduitBean> getResult() {
        return result;
    }
    public void setResult(Vector<ProduitBean> value)
    {
        result=value;
    }    
}