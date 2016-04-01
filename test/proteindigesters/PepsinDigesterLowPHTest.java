/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteindigesters;

import proteindigesters.PepsinDigesterLowPH;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rutger
 */
public class PepsinDigesterLowPHTest {
    
    public PepsinDigesterLowPHTest() {
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

    /**
     * Test of digest method, of class PepsinDigesterLowPH.
     */
    @Test
    public void testDigest() {
        System.out.println("digest");
        String peptide = "";
        PepsinDigesterLowPH instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.digest(peptide);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndices method, of class PepsinDigesterLowPH.
     */
    @Test
    public void testGetIndices() {
        System.out.println("getIndices");
        PepsinDigesterLowPH instance = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getIndices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
