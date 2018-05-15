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
public abstract class Destination 
{
    protected String pays;
    protected String ville;
    protected double taxe;
    protected double prix;
    
    public Destination(String _pays, String _ville, double _taxe, double _prix)
    {
        this.pays = _pays;
        this.ville = _ville;
        this.taxe = _taxe;
        this.prix = _prix;
    }
    public String getType(){return this.getClass().getSimpleName();}
}
