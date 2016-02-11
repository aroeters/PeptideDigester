/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigestor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author arne
 */
public class ChemotrypsinDigestorLowSpecific implements Digestor {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public ChemotrypsinDigestorLowSpecific(final Integer minLength) {
        this.minimalLength = minLength;
    }
    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Chemotrysin low specificity
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        List<Character> aa = new ArrayList<>(Arrays.asList('F', 'L', 'Y', 'W', 'M', 'H'));
        List<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        for (Character amino : aa) {
            for (int index = peptide.indexOf(amino); index >= 0 && index <= peptide.length() - 2;
                    index = peptide.indexOf(amino, index + 1)) {
                String p1F = peptide.substring(index + 1, index + 2);
                if (!peptide.substring(index + 1, index + 2).equals("P")) {
                    if (amino.equals('W') && p1F.equals("M")) {
                    } else if (amino.equals('M') && p1F.equals("Y")) {
                    } else if (amino.equals('H') && p1F.equals("D")
                            || p1F.equals("M") || p1F.equals("W")) {
                    } else {
                        indices.add(index);
                    }
                }
            }
        }
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
