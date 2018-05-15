/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisationjeuvideo;

import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author bornbygoogle
 */
public class ModelisationJeuVideo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList tab =new ArrayList();
       
        tab.add(new Joueur("Messi","Lionel","Argentine","Barcelone",90,90,90,"attaquant","gauche"));
        tab.add(new Entraineur("Mourinho","Jose","Portugaise","Manchester",90,99,80,85));
        tab.add(new Joueur("Costa","Diego","Espagnole","Chelsea",90,90,90,"attaquant","droit"));

        for(int i=0;i<tab.size();i++){
            System.out.println(tab.get(i));
        }
        System.out.println("---------------------------------- Tableau apres tri -----------------");
        Collections.sort(tab);
        for(int i=0;i<tab.size();i++){
            System.out.println(tab.get(i));
        }
    }
    
}
