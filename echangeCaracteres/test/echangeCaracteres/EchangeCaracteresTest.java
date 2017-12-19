/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeCaracteres;

import static echangeCaracteres.echangeCaracteresClass.echange2DerniersCar;
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
public class EchangeCaracteresTest {
    
    public EchangeCaracteresTest() {
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
    public void testEchangeChaineAvec2Car()
    {
        assertEquals("BA",echange2DerniersCar("AB"));
    }
    
    @Test
    public void testEchangeChaineAvec4Car()
    {
        assertEquals("RANI",echange2DerniersCar("RAIN"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
