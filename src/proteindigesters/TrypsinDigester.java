/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteindigesters;

import proteincutter.PeptideCutter;
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
     * The number of miscleavages used for the data.
     */
    private final Integer mc;
    /**
     * The ArrayList of indices to cut the protein/peptide
     */
    private ArrayList<Integer> indices;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public TrypsinDigester(final Integer minLength, final Integer misc) {
        this.minimalLength = minLength;
        this.mc = misc;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Trypsin
        // The order for the sites is:
        // p4   p3  p2  p1/amino  p1F p2F p3F p4F
        indices = new ArrayList<>();
        this.indices.add(0);
        this.indices.add(peptide.length());
        ArrayList<String> aa = new ArrayList<>(Arrays.asList("K", "R"));
        for (String amino : aa) {
            for (int index = peptide.indexOf(amino); index >= 0 && index <= peptide.length() - 2;
                    index = peptide.indexOf(amino, index + 1)) {
                String p1 = peptide.substring(index, index + 1);
                String p1F = peptide.substring(index + 1, index + 2);
                if (index >= 1) {
                    String p2 = peptide.substring(index - 1, index);
                    if (p2.equals("W") && amino.equals("K") && p1F.equals("P")) {
                        indices.add(index + 1);
                    } else if (p2.equals("M") && amino.equals("R") && p1F.equals("P")) {
                        indices.add(index + 1);
                    } else {
                        if (p2.equals("C")) {
                            if (amino.equals("K")) {
                                if (p1F.equals("D") || p1F.equals("H") || p1F.equals("Y")) {
                                    continue;
                                } else if (!p1F.equals("P")) {
                                    indices.add(index + 1);
                                }
                            } else if (amino.equals("R")) {
                                if (p1F.equals("K")) {
                                    continue;
                                } else if (!p1F.equals("P")) {
                                    indices.add(index);
                                }
                            } else if (!p1F.equals("P")) {
                                indices.add(index + 1);
                            }
                        } else if (p2.equals("D") && amino.equals("K") && p1F.equals("D")) {
                            continue;
                        } else if (p2.equals("R") && amino.equals("R")) {
                            if (p1F.equals("R") || p1F.equals("H")) {
                                continue;
                            } else if (!p1F.equals("P")) {
                                indices.add(index + 1);
                            }
                        } else if (!p1F.equals("P")) {
                            indices.add(index + 1);
                        }

                    }
                }
            }

        }
        PeptideCutter pc = new PeptideCutter();
        return pc.getDigestionArray(peptide, indices, this.minimalLength, this.mc);
    }

    @Override
    public ArrayList<Integer> getIndices() {
        return this.indices;
    }

}
