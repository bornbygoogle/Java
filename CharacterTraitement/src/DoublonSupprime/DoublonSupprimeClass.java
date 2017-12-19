/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublonSupprime;

/**
 *
 * @author bornbygoogle
 */
public class DoublonSupprimeClass 
{
    public static String DoublonSupprime(String chaineCar)
    {
        String maChaine = new String();
        String replaceChaine = new String();
        String subChaine = new String();        
        String subChaineTest = new String();
        Integer chaineLength = chaineCar.length();  
        if (chaineLength>1)
        {
            subChaineTest = chaineCar.substring(0,2);
            subChaine = chaineCar.substring(2,chaineLength);
            replaceChaine = subChaineTest.replaceAll("[aA]","");
            maChaine = replaceChaine + "" + subChaine;
        }
        else maChaine = chaineCar.replaceAll("[aA]","");
        System.out.println(maChaine);
        return maChaine;
    }
    
}
