/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_1;

/**
 *
 * @author faycal
 */
public abstract class Employe {
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
}
