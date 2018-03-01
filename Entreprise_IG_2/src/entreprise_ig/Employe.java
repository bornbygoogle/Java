/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_ig;
import java.io.*;

/**
 *
 * @author faycal
 */
public abstract class Employe implements Comparable, Serializable {
    protected String nom;
    protected double paie;
    protected int numero;
    static int compteur=0;
    
    public Employe(String _nom){
        nom=_nom;
        numero=compteur++;
    }
    public abstract double laPaye();
    public String toString(){
       return "Nom :"+this.getNom()+" Numéro :"+this.getNum()+ " Salaire :"+this.laPaye();
    }
    public String getNom(){return nom;}
    public int getNum(){return numero;}
    public Employe clone() throws CloneNotSupportedException{return (Employe)super.clone();}
    public int compareTo(Object a){
        Double paie1=this.paie;
        Double paie2=((Employe)a).paie;
        
        return paie1.compareTo(paie2);
       
   }
}
