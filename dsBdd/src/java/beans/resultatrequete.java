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
 * @author p0607615
 * 
 */
public class resultatrequete implements Serializable {
           
    private ResultSet result;
    
    public resultatrequete() {}
    
    public ResultSet getResult() {
        return result;
    }
    public void setResult(ResultSet value)throws SQLException {
        result=value;
    }
}
