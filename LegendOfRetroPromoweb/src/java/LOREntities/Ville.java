package LOREntities;
// Generated Jun 16, 2018 12:17:17 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ville generated by hbm2java
 */
public class Ville  implements java.io.Serializable {


     private Integer idVille;
     private Pays pays;
     private String nomVille;
     private String cp;
     private Set personnes = new HashSet(0);

    public Ville() {
    }

	
    public Ville(Pays pays, String nomVille, String cp) {
        this.pays = pays;
        this.nomVille = nomVille;
        this.cp = cp;
    }
    public Ville(Pays pays, String nomVille, String cp, Set personnes) {
       this.pays = pays;
       this.nomVille = nomVille;
       this.cp = cp;
       this.personnes = personnes;
    }
   
    public Integer getIdVille() {
        return this.idVille;
    }
    
    public void setIdVille(Integer idVille) {
        this.idVille = idVille;
    }
    public Pays getPays() {
        return this.pays;
    }
    
    public void setPays(Pays pays) {
        this.pays = pays;
    }
    public String getNomVille() {
        return this.nomVille;
    }
    
    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }
    public String getCp() {
        return this.cp;
    }
    
    public void setCp(String cp) {
        this.cp = cp;
    }
    public Set getPersonnes() {
        return this.personnes;
    }
    
    public void setPersonnes(Set personnes) {
        this.personnes = personnes;
    }




}


