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
public class PepsinDigestorLowPH implements Digestor {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public PepsinDigestorLowPH(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Pepsin low PH (PH1.3)
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        List<Character> aa = new ArrayList<>(Arrays.asList('F', 'L'));
        List<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        for (Character amino : aa) {
            for (int index = peptide.indexOf(amino); index >= 2 && index <= peptide.length() - 3;
                    index = peptide.indexOf(amino, index + 1)) {
                String p1 = peptide.substring(index, index + 1);
                String p1F = peptide.substring(index + 1, index + 2);
                String p2F = peptide.substring(index + 2, index + 3);
                if (index == 2) {
                    String p2 = peptide.substring(index - 1, index);
                    String p3 = peptide.substring(index - 2, index - 1);
                    if (!p3.equals("H") || !p3.equals("K") || !p3.equals("R") && !p2.equals("P") && !p2F.equals("P")) {
                        indices.add(index);
                    }
                } else if (index >= 3) {
                    String p2 = peptide.substring(index - 1, index);
                    String p3 = peptide.substring(index - 2, index - 1);
                    String p4 = peptide.substring(index - 3, index - 2);

                    if (p4.equals("H") || p4.equals("K") || p4.equals("R") && p3.equals("P")
                            && p2.equals("R") && p1F.equals("P")) {
                    } else if (p3.equals("H") || p3.equals("K") || p3.equals("R") && p2.equals("P")
                            && p2F.equals("P")) {
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
