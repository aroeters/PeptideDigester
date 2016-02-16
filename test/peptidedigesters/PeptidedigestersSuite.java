/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

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
@Suite.SuiteClasses({peptidedigesters.ChemotrypsinDigesterLowSpecificTest.class, peptidedigesters.ChemotrypsinDigesterHighSpecificTest.class, peptidedigesters.LysCDigesterTest.class, peptidedigesters.DigesterTest.class, peptidedigesters.TrypsinDigesterTest.class, peptidedigesters.TrypsinDigesterConservativeTest.class, peptidedigesters.PepsinDigesterLowPHTest.class, peptidedigesters.GluCDigesterTest.class, peptidedigesters.PeptideDigesterTest.class, peptidedigesters.NoDigesterTest.class, peptidedigesters.AspNDigesterTest.class, peptidedigesters.PepsinDigesterHigherPHTest.class})
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
