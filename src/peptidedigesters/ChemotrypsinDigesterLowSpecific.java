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

    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;

    public ChemotrypsinDigesterLowSpecific(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Chemotrysin high specificity
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length() - 1);
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        indices.addAll(pm.getIndexList(pattern2, peptide));
        indices.addAll(pm.getIndexList(pattern3, peptide));
        indices.addAll(pm.getIndexList(pattern4, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
