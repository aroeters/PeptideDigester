/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeptideDigestors;

import PeptideCutter.PeptideCutter;
import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        PeptideCutter PC = new PeptideCutter();
        return PC.getDigestionArray(peptide, indices, this.minimalLength);
    }
}