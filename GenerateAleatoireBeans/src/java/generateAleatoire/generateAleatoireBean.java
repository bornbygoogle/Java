/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateAleatoire;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author bornbygoogle
 */
public class generateAleatoireBean implements Serializable {
    
    private double alea;
    
    public generateAleatoireBean() { alea = Math.random(); }
    
    public double getAlea() { return alea; }
    
    public void setAlea(double value)
    {
        alea = value;
    }    
}
