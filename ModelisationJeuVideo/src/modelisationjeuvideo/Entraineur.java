/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisationjeuvideo;

/**
 *
 * @author bornbygoogle
 */
public class Entraineur extends Personne 
{
    protected int management;
    protected int connaissance;
    protected int gestion;
    protected int communication;
    
    public Entraineur(String _nom, String _prenom, String _nationalite, String _club, int _management, int _connaissance, int _gestion, int _communication)
    {
        super(_nom,_prenom,_nationalite,_club);
        
        this.connaissance = _connaissance;
        this.communication = _communication;
        this.gestion = _gestion;
        this.management = _management;
    }

    @Override
    public String toString(){
         return getType()
                 +" Nom : "+ this.nom
                 +" Prenom : "+this.prenom
                 +" Nationalité : "+this.nationalite
                 +" Club : "+this.club
                 +" Management : "+this.management
                 +" Gestion : "+this.gestion
                 +" Communication : "+this.communication
                 +" Connaissance : "+this.connaissance
                 ;
     }
}
