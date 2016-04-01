/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteindigesters;

import proteindigesters.Digester;
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
public class DigesterTest {
    
    public DigesterTest() {
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
     * Test of digest method, of class Digester.
     */
    @Test
    public void testDigest() {
        System.out.println("digest");
        String peptide = "";
        Digester instance = new DigesterImpl();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.digest(peptide);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndices method, of class Digester.
     */
    @Test
    public void testGetIndices() {
        System.out.println("getIndices");
        Digester instance = new DigesterImpl();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getIndices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class DigesterImpl implements Digester {

        public ArrayList<String> digest(String peptide) {
            return null;
        }

        public ArrayList<Integer> getIndices() {
            return null;
        }
    }
    
}
