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
    public static String echange2DerniersCar(String chaineCar)
    {
        String maChaine = new String();
        String subChaine = new String();        
        String subChaineEchange = new String();
        Integer chaineLength = chaineCar.length();
        if (chaineLength>1)
        {
            subChaineEchange = chaineCar.substring(chaineLength-2,chaineLength);
            subChaine = chaineCar.substring(0,chaineLength-2);
            chaineLength = subChaineEchange.length();        
            maChaine = subChaine + "" + subChaineEchange.charAt(chaineLength-1) + "" + subChaineEchange.charAt(0);
        }
        else { maChaine = chaineCar; }
        System.out.println(maChaine);
        return maChaine;        
    }
}

