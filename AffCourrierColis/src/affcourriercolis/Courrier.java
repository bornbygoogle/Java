/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affcourriercolis;

/**
 *
 * @author p0607615
 */
public abstract class Courrier
{
    String destinataire;
    boolean express;
    static int compteur=0;
    int numcourrier;

    public Courrier(String _dest, boolean _exp)
    {
        destinataire = _dest;
        express = _exp;
        numcourrier=compteur++;
    }
    
    public abstract double calculPrix();
    public String getDestinataire() { return destinataire; }
    public boolean getExpress() { return express; }
    public int getNum() { return numcourrier; }
    public void setDestinataire(String _dest) { this.destinataire = _dest; }   
    public void setExpress(boolean _exp) { this.express = _exp; }
}
