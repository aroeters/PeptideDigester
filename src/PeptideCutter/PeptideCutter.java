/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeptideCutter;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author arne
 */
public class PeptideCutter {
     public ArrayList<String> getDigestionArray(final String peptide,
             final ArrayList<Integer> indices,
             final Integer minimalLength) {
         
        Collections.sort(indices);
        ArrayList<String> digestedPeptide = new ArrayList<>();
        for (int i = 0; i < indices.size() - 1; i++) {
            if (indices.get(i + 1) - indices.get(i) >= minimalLength) {
                digestedPeptide.add(peptide.substring(indices.get(i) + 1, indices.get(i + 1) + 1));
            }
        }
        return digestedPeptide;
    }
}
