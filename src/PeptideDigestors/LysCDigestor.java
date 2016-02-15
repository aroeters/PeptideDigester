/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeptideDigestors;

import PeptideCutter.PeptideCutter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import peptidematcher.PeptideMatcher;

/**
 *
 * @author Rutger
 */
public class LysCDigestor implements Digestor {
    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * The Patterns for the regex.
     */
    Pattern pattern1 = Pattern.compile("[K]");
    
    
    public LysCDigestor(final Integer minLength) {
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
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }
}
