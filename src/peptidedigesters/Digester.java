/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import java.util.ArrayList;

/**
 *
 * @author arne
 */
public interface Digester {
    /**
     * Digests the peptide.
     * @param peptide String of the peptide
     * @return A list with the new peptide(s)
     */
    abstract ArrayList<String> digest(final String peptide);
    
    /**
     * Returns the indices of the splitting sites found without length filtering.
     * @return ArrayList<Integer> indices
     */
    abstract ArrayList<Integer> getIndices();
}
