/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faycal
 */
public class Enfant extends Adulte {
    public Enfant(String _nom,String _prenom){super(_nom,_prenom);}
    public double calculPrix(){return super.calculPrix()/2;}
   // public String getType(){ return "enfant";}
    
}
