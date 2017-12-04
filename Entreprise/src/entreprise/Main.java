/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise;

import java.util.Vector;

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
        Horaire a=new Horaire("AAAA", 200);
	Commercial b=new Commercial ("BBBB",200,5000);
	Fixe c=new Fixe("CCCC");
        Vector tab = new Vector();
        tab.addElement(a);
        tab.addElement(b);
        tab.addElement(c);
        for (int i=0;i<tab.size();i++){
            System.out.println(tab.elementAt(i));
        }
    }
    
}
