/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteincutter;

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
     * @param mc The number of miscleavages allowed
     * @return ArrayList from the new peptides
     */
    public final ArrayList<String> getDigestionArray(final String peptide,
            final ArrayList<Integer> indices,
            final Integer minimalLength,
            final Integer mc) {
        Collections.sort(indices);
        ArrayList<String> digestedPeptide = new ArrayList<>();
        for (int i = 0; i < indices.size() - 1; i++) {
            // To filter on the size of the peptide
            switch (mc) {
                case 3: {
                    if (i < indices.size() - 4) {
                        if (indices.get(i + 4) - indices.get(i) >= minimalLength) {
                            digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 4)));
                        }
                    }
                }
                case 2: {
                    if (i < indices.size() - 3) {
                        if (indices.get(i + 3) - indices.get(i) >= minimalLength) {
                            digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 3)));
                        }
                    }
                }
                case 1: {
                    if (i < indices.size() - 2) {
                        if (indices.get(i + 2) - indices.get(i) >= minimalLength) {
                            digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 2)));
                        }
                    }
                }
                case 0: {
                    if (indices.get(i + 1) - indices.get(i) >= minimalLength) {
                        digestedPeptide.add(peptide.substring(indices.get(i), indices.get(i + 1)));
                    }
                    break;
                }
                default: {
                    break;
                }
            }

        }
        return digestedPeptide;
    }
}
