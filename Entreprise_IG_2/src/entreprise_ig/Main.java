/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_ig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

/**
 *
 * @author faycal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
       // IG a =new IG();
        Vector z=new Vector();
        try{
        
        FileInputStream fis = new FileInputStream("C:\\Users\\fbraiki\\Desktop\\tabemploye.dat");//désérialisation
        ObjectInputStream ois = new ObjectInputStream(fis);
        z = (Vector) ois.readObject(); 
        ois.close();
        }
        catch(FileNotFoundException e) {}
        catch(IOException e) {} 
        for(int i=0;i<z.size();i++)System.out.println(z.elementAt(i));
    }
    
}