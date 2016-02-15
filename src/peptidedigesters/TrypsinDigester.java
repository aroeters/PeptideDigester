/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigesters;

import peptidecutter.PeptideCutter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author arne
 */
public class TrypsinDigester implements Digester {

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
    public TrypsinDigester(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Trypsin
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length() - 1);
        ArrayList<Character> aa = new ArrayList<>(Arrays.asList('K', 'R'));
        for (Character amino : aa) {
            for (int index = peptide.indexOf(amino); index >= 0 && index <= peptide.length() - 2;
                    index = peptide.indexOf(amino, index + 1)) {
                String p1 = peptide.substring(index, index + 1);
                String p1F = peptide.substring(index + 1, index + 2);
                if (index >= 1) {
                    String p2 = peptide.substring(index - 1, index);
                    if (amino.equals('K') && p2.equals("W") && p1F.equals("P")) {
                        indices.add(index);
                    } else if (amino.equals('R') && p2.equals("M") && p1F.equals("P")) {
                        indices.add(index);
                    } else {
                        if (amino.equals('K') && p2.equals("C") && p1F.equals("D") || p1F.equals("H")
                                || p1F.equals("Y")) {
                        } else if (amino.equals('K') && p2.equals("D") && p1F.equals("D")) {
                        } else if (amino.equals('R') && p2.equals("C") && p1F.equals("K")) {
                        } else if (amino.equals('R') && p2.equals("R") && p1F.equals("R") || p1F.equals("H")) {
                        } else if (!p1F.equals("P")) {
                            indices.add(index);
                        }
                    }
                } else {
                    if (!p1F.equals('P')) {
                        indices.add(index);
                    }
                }

            }
        }
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }

}
