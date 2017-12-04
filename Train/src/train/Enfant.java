/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

/**
 *
 * @author faycal
 */
public class Enfant extends Adulte {
    public Enfant(String _nom){super(_nom);}
    public double calculPrix(){return super.calculPrix()/2;}
    public String getType(){ return "enfant";}
    
}
