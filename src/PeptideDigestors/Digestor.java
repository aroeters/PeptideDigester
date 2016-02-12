/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeptideDigestors;

import java.util.ArrayList;

/**
 *
 * @author arne
 */
public interface Digestor {
    /**
     * Digests the peptide.
     * @param peptide String of the peptide
     * @return A list with the new peptide(s)
     */
    abstract ArrayList<String> digest(final String peptide);
}
