/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author faycal
 */
public class Tableau implements Serializable {
    
    
    
    private Vector tab;
    
   
    
    public Tableau() {
        tab = new Vector();
    }
    
    public Vector getTab() {
        return tab;
    }
    public void setTab(Vector a){
        tab=a;
    }
    
}
