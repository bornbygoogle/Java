/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Adrien Marchand
 */
public class InitException extends Exception
{
    public InitException(String erreur)
    {
        super(erreur);
    }
}
