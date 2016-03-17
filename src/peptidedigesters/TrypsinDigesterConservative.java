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
public class TrypsinDigesterConservative implements Digester {

    /**
     * contains the minimal length a peptide should have.
     */
    private final Integer minimalLength;
    /**
     * The number of miscleavages used for the data.
     */
    private final Integer mc;
    /**
     * The first pattern of the Pepsin Low PH digester.
     */
    private final Pattern pattern1 = Pattern.compile("[KR](?!P)(?=[A-Z])");
    /**
     * The ArrayList of indices to cut the protein/peptide.
     */
    private ArrayList<Integer> indices;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public TrypsinDigesterConservative(final Integer minLength, final Integer misc) {
        this.minimalLength = minLength;
        this.mc = misc;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Trypsin conservative
        indices = new ArrayList<>();
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
