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
public abstract class Personne implements Comparable
{
    protected String nom;
    protected String prenom;
    protected String nationalite;
    protected String club;
    
    public Personne(String _nom, String _prenom, String _nationalite, String _club)
    {
        this.nom=_nom;
        this.prenom=_prenom;
        this.nationalite=_nationalite;
        this.club=_club;
    }
    
    public String getName() {
        return this.nom;
    }
    
    public String getType(){return this.getClass().getSimpleName();}
    public abstract String toString();
    
    public int compareTo(Object a){
        String nom1=this.getName();
        String nom2=((Personne)a).getName();
        return nom1.compareTo(nom2);       
   }  
    
}
