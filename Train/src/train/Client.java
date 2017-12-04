
</*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

/**
 *
 * @author faycal
 */
public abstract class Client implements Comparable {
     protected String nom;
     protected static int compteur=1;
     protected int numplace;
     protected static final double PRIX_BASE=10;
     protected static final double TVA=20;
     public Client(String _nom){
         nom=_nom;
         numplace=compteur++;
     }
     public abstract double calculPrix();
     public String getType(){return this.getClass().getName();}
     public String toString(){
         return "numero : "+this.numplace+" Nom : "+this.nom+ " type tarif : "+this.getType()+" A payer : "+this.calculPrix()+" euros";
     }
     public int compareTo(Object a){
        Double pass1=this.calculPrix();
        Double pass2=((Client)a).calculPrix();
        return pass1.compareTo(pass2);
       
   }  
} 

