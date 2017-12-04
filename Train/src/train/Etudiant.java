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
public class Etudiant extends Client {
    public Etudiant(String _nom){super(_nom);}
    public double calculPrix(){return (PRIX_BASE * 0.8) *(1+TVA/100) ;}
    public String getType(){ return "etudiant";}
}
