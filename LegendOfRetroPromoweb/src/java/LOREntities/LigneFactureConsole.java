package LOREntities;
// Generated Jun 16, 2018 12:17:17 AM by Hibernate Tools 4.3.1



/**
 * LigneFactureConsole generated by hbm2java
 */
public class LigneFactureConsole  implements java.io.Serializable {


     private LigneFactureConsoleId id;
     private Facture facture;
     private VersionConsole versionConsole;
     private int quantite;

    public LigneFactureConsole() {
    }

    public LigneFactureConsole(LigneFactureConsoleId id, Facture facture, VersionConsole versionConsole, int quantite) {
       this.id = id;
       this.facture = facture;
       this.versionConsole = versionConsole;
       this.quantite = quantite;
    }
   
    public LigneFactureConsoleId getId() {
        return this.id;
    }
    
    public void setId(LigneFactureConsoleId id) {
        this.id = id;
    }
    public Facture getFacture() {
        return this.facture;
    }
    
    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    public VersionConsole getVersionConsole() {
        return this.versionConsole;
    }
    
    public void setVersionConsole(VersionConsole versionConsole) {
        this.versionConsole = versionConsole;
    }
    public int getQuantite() {
        return this.quantite;
    }
    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }




}


