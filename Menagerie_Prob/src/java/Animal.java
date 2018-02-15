/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
/**
 *
 * @author faycal
 */
public abstract class Animal implements Serializable {
    String nom;
    public Animal(){}
    String getNom(){return nom;}
    public Animal(String _nom){
        nom=_nom;
       // System.out.println("constructeur animal appelé");
    }
    public String toString(){return "Cri de "+nom+" "+this.cri();}
    public abstract String cri();
}
