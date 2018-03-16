/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author faycal
 */
public class resultatrequete implements Serializable {
    
        
    private ResultSet result;
   private int nbcol;
   private ResultSetMetaData rs ;
    
    public resultatrequete() {
    }
    
    public ResultSet getResult() {
        return result;
    }
   public int getNbcol(){
        return nbcol;
    }
    public void setResult(ResultSet value)throws SQLException {
        result=value;
      rs =result.getMetaData();
      nbcol = rs.getColumnCount();
    }
   public void setNbcol(int a){
        nbcol=a;
    }
    public ResultSetMetaData getResultSetMetaData (){
        return rs;
    }
       
}
