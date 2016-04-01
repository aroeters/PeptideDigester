/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteindigesters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rutger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({proteindigesters.ChemotrypsinDigesterLowSpecificTest.class, proteindigesters.ChemotrypsinDigesterHighSpecificTest.class, proteindigesters.LysCDigesterTest.class, proteindigesters.DigesterTest.class, proteindigesters.TrypsinDigesterTest.class, proteindigesters.TrypsinDigesterConservativeTest.class, proteindigesters.PepsinDigesterLowPHTest.class, proteindigesters.GluCDigesterTest.class, proteindigesters.PeptideDigesterTest.class, proteindigesters.NoDigesterTest.class, proteindigesters.AspNDigesterTest.class, proteindigesters.PepsinDigesterHigherPHTest.class})
public class PeptidedigestersSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
