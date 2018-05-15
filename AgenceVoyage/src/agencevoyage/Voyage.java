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
public abstract class Voyage 
{
    protected String nom;
    protected int duree;
    protected Destination dest1;
    protected Destination dest2;
    
    public Voyage(String _nom, int _duree, Destination _dest1, Destination _dest2)
    {
        this.nom = _nom;
        this.duree = _duree;
        this.dest1 = _dest1;
        this.dest2 = _dest2;
    }
    
    //Retourner le nom de class
    public String getType(){return this.getClass().getSimpleName();}
    
    //Calculer les prix des voyages
    public abstract Double calculPrix();    
    
    // Affichage des voyages
    public abstract String toString();
}
