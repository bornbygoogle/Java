/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entreprise_ig;

/**
 *
 * @author faycal
 */

public class Fixe extends Employe {
    static int SALAIRE_FIXE=1500;
    public Fixe (String _nom){
        super(_nom);
        paie=SALAIRE_FIXE;
    }
    public double laPaye(){return paie;}
}
