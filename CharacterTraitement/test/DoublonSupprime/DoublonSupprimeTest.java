/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublonSupprime;

import static DoublonSupprime.DoublonSupprimeClass.DoublonSupprime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bornbygoogle
 */
public class DoublonSupprimeTest {
    
    public DoublonSupprimeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void supprimeAau1erCaractere()
    {
        assertEquals("BCD",DoublonSupprime("ABCD"));
        assertEquals("BBAA",DoublonSupprime("BBAA"));
        assertEquals("CD",DoublonSupprime("AACD"));
        assertEquals("BCD",DoublonSupprime("BACD"));
        assertEquals("BAA",DoublonSupprime("AABAA"));        
        assertEquals("B",DoublonSupprime("AB"));               
        assertEquals("B",DoublonSupprime("B"));
        assertEquals("",DoublonSupprime("A"));
    }
  
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
