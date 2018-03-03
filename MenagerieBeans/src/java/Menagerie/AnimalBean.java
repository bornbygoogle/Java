/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menagerie;

import java.beans.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author bornbygoogle
 */
public class AnimalBean implements Serializable{
   
    static Vector  tabanimaux=new Vector();
    
    private String name="";
    private String type="";
    private String cri="";
    
    public AnimalBean() { }
    
    public String getName() { return name; }
    public String getType() { return type; }
    public String getCri()
    {
        return ((Animal)tabanimaux.lastElement()).cri();
    }
    public void addAnimal() 
    { 
        switch(type)
        {
            case "Chat" : tabanimaux.add(new Chat(name));break;
            case "Chien" : tabanimaux.add(new Chien(name));break;
            case "Oiseau" : tabanimaux.add(new Oiseau(name));break;
        }
        /*try{
            FileOutputStream fs = new FileOutputStream("tabanimaux.dat");//sérialisation
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(tabanimaux);
            os.close();
        }
        catch(FileNotFoundException e) {}
        catch(IOException e) {}*/
        //cri = this.cri();
        //return cri; 
    }
        
    public void setName(String _nom) { this.name=_nom; }
    public void setType(String _type) { this.type=_type; }
    
}
