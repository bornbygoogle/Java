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
        echange2DerniersCar("CD");
    }
    
    public static String echange2DerniersCar(String chaine2Car)
    {
        String maChaine = new String();
        Integer chaineLength = chaine2Car.length();
        maChaine = chaine2Car.charAt(chaineLength-1) + "" + chaine2Car.charAt(0);
        System.out.println(maChaine);
        return maChaine;
    }
}

