/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import peptidecutter.PeptideCutter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import peptidematcher.PeptideMatcher;

/**
 *
 * @author arne
 */
public class ChemotrypsinDigesterLowSpecific implements Digester {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * The Patterns for the regex.
     */
    private final Pattern pattern1 = Pattern.compile("[FLY](?!P)");
    private final Pattern pattern2 = Pattern.compile("[W](?![MP])");
    private final Pattern pattern3 = Pattern.compile("[M](?![PY])");
    private final Pattern pattern4 = Pattern.compile("[H](?![DMPW])");
    
    public ChemotrypsinDigesterLowSpecific(final Integer minLength) {
        this.minimalLength = minLength;
    }
    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Chemotrysin high specificity
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        ArrayList<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        indices.addAll(pm.getIndexList(pattern2, peptide));
        indices.addAll(pm.getIndexList(pattern3, peptide));
        indices.addAll(pm.getIndexList(pattern4, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }
    
}
