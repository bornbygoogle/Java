package LOREntities;
// Generated Jun 16, 2018 12:17:17 AM by Hibernate Tools 4.3.1



/**
 * DecrireId generated by hbm2java
 */
public class DecrireId  implements java.io.Serializable {


     private int idJeu;
     private int idTag;

    public DecrireId() {
    }

    public DecrireId(int idJeu, int idTag) {
       this.idJeu = idJeu;
       this.idTag = idTag;
    }
   
    public int getIdJeu() {
        return this.idJeu;
    }
    
    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }
    public int getIdTag() {
        return this.idTag;
    }
    
    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DecrireId) ) return false;
		 DecrireId castOther = ( DecrireId ) other; 
         
		 return (this.getIdJeu()==castOther.getIdJeu())
 && (this.getIdTag()==castOther.getIdTag());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdJeu();
         result = 37 * result + this.getIdTag();
         return result;
   }   


}


