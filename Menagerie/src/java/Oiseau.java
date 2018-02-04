/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bornbygoogle
 */
public class Oiseau extends Animal
{

    public Oiseau(String _nom) {
        super(_nom);
    }
    
    @Override
    public String sound(){
      return "Gazouillement";   
    }
}
