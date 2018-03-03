package Menagerie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author faycal
 */
public class Chien extends Animal{
    public Chien(String _nom){
        super(_nom);
        //System.out.println("constructeur Chien appelé");      
    }
   // public String cri(){return "(Chien) : Aboiement";}
    public String cri(){return "Aboiement";}
    
    
}
