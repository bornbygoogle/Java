/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author faycal
 */
public class Commercial extends Horaire {
    static double COMM=0.1;
    protected double ventes;
    public Commercial (String _nom,double _nbheures, double _ventes){
        super(_nom,_nbheures);
        ventes=_ventes;
    }
    public double laPaye(){
        return super.laPaye()+ventes*COMM;
    }
}
