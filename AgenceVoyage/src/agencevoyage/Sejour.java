/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencevoyage;

/**
 *
 * @author bornbygoogle
 */
public class Sejour extends Voyage 
{

    public Sejour(String _nom, int _duree, Destination _dest1, Destination _dest2) 
    {
        super(_nom, _duree, _dest1, _dest2);
    }

    @Override
    public Double calculPrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
