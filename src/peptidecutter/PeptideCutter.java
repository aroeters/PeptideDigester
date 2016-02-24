/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidecutter;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author arne
 */
public class PeptideCutter {

    /**
     * Cuts the peptide at the given indices.
     *
     * @param peptide the protein/peptide to be digested
     * @param indices the indices from where to digest
     * @param minimalLength minimal length of the peptide it should have after
     * digestion
     * @return ArrayList from the new peptides
     */
    public final ArrayList<String> getDigestionArray(final String peptide,
            final ArrayList<Integer> indices,
            final Integer minimalLength) {
        Collections.sort(indices);
        ArrayList<String> digestedPeptide = new ArrayList<>();
        for (int i = 0; i < indices.size() - 1; i++) {
            // To filter on the size of the peptide
            if (indices.get(i + 1) - indices.get(i) >= minimalLength) {
                if (i != 0 && i != indices.size() - 2) {
                    digestedPeptide.add(peptide.substring(indices.get(i) - 1, indices.get(i))
                            + "." + peptide.substring(indices.get(i), indices.get(i + 1)) + "."
                            + peptide.substring(indices.get(i + 1), indices.get(i + 1) + 1));
                } else if (i == 0 && indices.size() != 2) {
                    digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 1)) + "."
                            + peptide.substring(indices.get(i + 1), indices.get(i + 1) + 1));

                } else if (i == indices.size() - 2 && indices.size() != 2) {
                    digestedPeptide.add(peptide.substring(indices.get(i) - 1, indices.get(i)) + "."
                            + peptide.substring(indices.get(i), indices.get(i + 1)));
                } else {
                    digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 1)));
                }
            }
        }
        return digestedPeptide;
    }
}
