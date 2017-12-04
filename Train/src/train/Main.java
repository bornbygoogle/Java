/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;
import java.util.*;

/**
 *
 * @author faycal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector tab =new Vector();
        tab.add(new Enfant("Didi"));
        tab.add(new Adulte("Dada"));
        tab.add(new Etudiant("Dudu"));
        Collections.sort(tab);
        for(int i=0;i<tab.size();i++){
            System.out.println(tab.elementAt(i));
        }
    }
    
}
