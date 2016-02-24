/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import peptidecutter.PeptideCutter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import peptidematcher.PeptideMatcher;

/**
 *
 * @author arne
 */
public class PepsinDigesterLowPH implements Digester {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;
    /**
     * The first pattern of the Pepsin Low PH digester. pattern created by
     * Rutger Ozinga
     */
    private final Pattern pattern1 = Pattern.compile("(?![HKR]P)[^R](?=[FL][^P])");
    /**
     * The second pattern of the Pepsin Low PH digester. pattern created by
     * Rutger Ozinga
     */
    private final Pattern pattern2 = Pattern.compile("(?![HKR]P)[FL](?=[A-Z][^P])");
    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public PepsinDigesterLowPH(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Pepsin low PH (PH1.3)
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length());
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        indices.addAll(pm.getIndexList(pattern2, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
