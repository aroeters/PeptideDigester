/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import peptidecutter.PeptideCutter;
import java.util.ArrayList;

/**
 *
 * @author arne
 */
public class NoDigester implements Digester {

    /**
     * contains the minimal length a peptide should have.
     */
    private final Integer minimalLength;
    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;
    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public NoDigester(final Integer minLength) {
        this.minimalLength = minLength;
    }
    
    @Override
    public final ArrayList<String> digest(final String peptide) {
        // No Digestion
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length() - 1);
        PeptideCutter PC = new PeptideCutter();
        return PC.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }
}
