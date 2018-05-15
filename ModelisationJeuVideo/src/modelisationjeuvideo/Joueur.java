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
public class Joueur extends Personne 
{
    protected int vitesse;
    protected int endurance;
    protected int technique;
    protected String poste;
    protected String piedaccelleration;
    
    public Joueur(String _nom, String _prenom, String _nationalite, String _club, int _vitesse, int _endurance, int _technique, String _poste, String _piedacceleration)
    {
        super(_nom,_prenom,_nationalite,_club);
        
        this.endurance = _endurance;
        this.piedaccelleration = _piedacceleration;
        this.poste = _poste;
        this.technique = _technique;
        this.vitesse = _vitesse;
    }

    @Override
    public String toString(){
         return "Nom : "+ this.nom
                 +" Prenom : "+this.prenom
                 + " Nationalité : "+this.nationalite
                 +" Club : "+this.club
                 +" Vitesse : "+this.vitesse
                 +" Endurance : "+this.endurance
                 +" Technique : "+this.technique
                 +" Poste : "+this.poste
                 +" Pied acceleration : "+this.piedaccelleration
                ;
     }
    
}
