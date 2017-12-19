/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeCaracteres;

/**
 *
 * @author bornbygoogle
 */
public class echangeCaracteresClass 
{
    
    public static void main(String[] args) {
        // TODO code application logic here
        echange2DerniersCar("RAIN");
    }
    
    public static String echange2DerniersCar(String chaineCar)
    {
        String maChaine = new String();
        String subChaine = new String();        
        String subChaineEchange = new String();
        Integer chaineLength = chaineCar.length();
        subChaineEchange = chaineCar.substring(chaineLength-2,chaineLength);
        subChaine = chaineCar.substring(0,chaineLength-2);
        chaineLength = subChaineEchange.length();        
        maChaine = subChaine + "" + subChaineEchange.charAt(chaineLength-1) + "" + subChaineEchange.charAt(0);
        return maChaine;
    }
}

