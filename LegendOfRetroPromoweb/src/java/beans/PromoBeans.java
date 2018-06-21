/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author bornbygoogle
 */
public class PromoBeans implements Serializable {
    
    private Vector<PromoBean> result;
    
    public PromoBeans() {}
    
    public Vector<PromoBean> getResult() {
        return result;
    }
    public void setResult(Vector<PromoBean> value)
    {
        result=value;
    }
}
