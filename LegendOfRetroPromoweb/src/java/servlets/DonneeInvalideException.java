/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Home
 */
public class DonneeInvalideException extends Exception
{
    public DonneeInvalideException(String erreur)
    {
        super(erreur);
    }
}
