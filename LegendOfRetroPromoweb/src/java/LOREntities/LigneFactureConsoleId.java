package LOREntities;
// Generated Jun 16, 2018 12:17:17 AM by Hibernate Tools 4.3.1



/**
 * LigneFactureConsoleId generated by hbm2java
 */
public class LigneFactureConsoleId  implements java.io.Serializable {


     private int idVersionConsole;
     private int idFacture;

    public LigneFactureConsoleId() {
    }

    public LigneFactureConsoleId(int idVersionConsole, int idFacture) {
       this.idVersionConsole = idVersionConsole;
       this.idFacture = idFacture;
    }
   
    public int getIdVersionConsole() {
        return this.idVersionConsole;
    }
    
    public void setIdVersionConsole(int idVersionConsole) {
        this.idVersionConsole = idVersionConsole;
    }
    public int getIdFacture() {
        return this.idFacture;
    }
    
    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof LigneFactureConsoleId) ) return false;
		 LigneFactureConsoleId castOther = ( LigneFactureConsoleId ) other; 
         
		 return (this.getIdVersionConsole()==castOther.getIdVersionConsole())
 && (this.getIdFacture()==castOther.getIdFacture());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdVersionConsole();
         result = 37 * result + this.getIdFacture();
         return result;
   }   


}


