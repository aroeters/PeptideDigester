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
public class PepsinDigesterHigherPH implements Digester {

    /**
     * contains the minimal length a peptide should have.
     */
    private final Integer minimalLength;
    /**
     * The first pattern of the Pepsin High PH digestor.
     * pattern created by Rutger Ozinga
     */
    private final Pattern pattern1 = Pattern.compile("(?![HKR]P)[^R](?=[FLWY][^P])");
    /**
     * The second pattern of the Pepsin High PH digestor.
     * pattern created by Rutger Ozinga
     */
    private final Pattern pattern2 = Pattern.compile("(?![HKR]P)[^FLWY](?=[A-Z][^P])");

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public PepsinDigesterHigherPH(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Pepsin Higher PH (PH > 2)
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        ArrayList<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        indices.addAll(pm.getIndexList(pattern2, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }
}
