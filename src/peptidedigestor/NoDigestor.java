/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigestor;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author arne
 */
public class NoDigestor implements Digestor {

    /**
     * contains the minimal length a peptide should have.
     */
    private final Integer minimalLength;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public NoDigestor(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // No Digestion
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        ArrayList<String> digestedPeptide = new ArrayList<>();
        if (peptide.length() >= minimalLength) {
            digestedPeptide.add(peptide);
        }
        return digestedPeptide;
    }

    @Override
    public ArrayList<String> getDigestionArray(final String peptide, final ArrayList<Integer> indices) {
        Collections.sort(indices);
        ArrayList<String> digestedPeptide = new ArrayList<>();
        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) >= this.minimalLength) {
                digestedPeptide.add(peptide.substring(indices.get(i) + 1, indices.get(i + 1) + 1));
            }
        }
        return digestedPeptide;
    }
}