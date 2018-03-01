/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_interface;

/**
 *
 * @author faycal
 */
public class Horaire extends Employe {
    protected static double taux=50.12;
    protected double nbheures;
    public Horaire(String _nom, double _nbheures){
        super(_nom);
        nbheures=_nbheures;
    }
    public double laPaye(){
        return paie = taux * nbheures;
    }
    
}
