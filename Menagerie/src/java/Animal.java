/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bornbygoogle
 */
public abstract class Animal 
{
    
    protected String nom;

    public Animal(String _nom){
        nom=_nom;
    }
    public abstract String sound();
    /*public String toString()
    {
        return "L'animal named "+this.getNom()+" a un cri : "+this.sound();
    }*/
    public String getNom() { return nom; }
}
