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
public class Lettre extends Courrier
{

    private final static double CHRONO = 1.0;
    private final static double PRIX_TIMBRE = 0.73;
    
    public Lettre(String _dest, boolean _exp) {
        super(_dest, _exp);
    }

    @Override
    public double calculPrix() 
    {
        double prix = PRIX_TIMBRE;
        if (super.getExpress())
        { 
            prix = CHRONO + PRIX_TIMBRE; 
        }
        return prix;
    }
    
}
