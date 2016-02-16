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
 * @author Rutger
 */
public class AspNDigester implements Digester {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * The Patterns for the regex.
     */
    private final Pattern pattern1 = Pattern.compile("[A-Z](?=D)");
    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;
    
    public AspNDigester(final Integer minLength) {
        this.minimalLength = minLength;
    }
    @Override
    public final ArrayList<String> digest(final String peptide) {
        // AspN 
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length());
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
