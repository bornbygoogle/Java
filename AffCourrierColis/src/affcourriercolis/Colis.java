/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affcourriercolis;

/**
 *
 * @author p0607615
 */
public class Colis extends Courrier
{

    private final static double CHRONO = 2.0;
    private final static double TARIF = 0.1;
    private double poids;
    
    public Colis(String _dest, boolean _exp, double _poids) {
        super(_dest, _exp);
        this.poids = _poids;
    }

    @Override
    public double calculPrix() 
    {
        double prix = 0;
        if (super.getExpress())
        { 
            prix = CHRONO + TARIF*this.poids; 
        }        
        return prix;
    }
    
}
