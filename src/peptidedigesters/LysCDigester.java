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
public class LysCDigester implements Digester {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;
    /**
     * The number of miscleavages used for the data.
     */
    private final Integer mc;

    /**
     * The Patterns for the regex.
     */
    Pattern pattern1 = Pattern.compile("[K](?=[A-Z])");
    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices = new ArrayList<>();

    public LysCDigester(final Integer minLength, final Integer misc) {
        this.minimalLength = minLength;
        this.mc = misc;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Chemotrysin high specificity
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        this.indices.add(0);
        this.indices.add(peptide.length());
        PeptideMatcher pm = new PeptideMatcher();
        indices.addAll(pm.getIndexList(pattern1, peptide));
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength, this.mc);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
