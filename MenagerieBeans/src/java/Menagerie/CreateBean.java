/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menagerie;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author bornbygoogle
 */
public class CreateBean implements Serializable{
   
    private String name="";
    private String type="";
    private String cri="";
    
    public CreateBean() { }
    
    public String getName() { return name; }
    public String getType() { return type; }
    public String getCri() 
    { 
        //cri = this.cri();
        return cri; 
    }
        
    public void setName(String _nom) { this.name=_nom; }
    public void setType(String _type) { this.type=_type; }
    
}
