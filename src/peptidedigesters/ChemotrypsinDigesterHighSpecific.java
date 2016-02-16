/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import peptidecutter.PeptideCutter;
import peptidematcher.PeptideMatcher;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author arne
 */
public class ChemotrypsinDigesterHighSpecific implements Digester {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;
    /**
     * The first Patterns for the regex.
     */
    private final Pattern pattern1 = Pattern.compile("[FY](?!P)(?=[A-Z])");
    /**
     * The second pattern for the regex.
     */
    private final Pattern pattern2 = Pattern.compile("[W](?![MP])(?=[A-Z])");

    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;

    /**
     * Initiates the class.
     *
     * @param minLength minimal length a peptide should have
     */
    public ChemotrypsinDigesterHighSpecific(final Integer minLength) {
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
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
