/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidematcher;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arne
 */
public class PeptideMatcher {
    /**
     * Matches the regex that is given and returns the array with indices.
     * @param pattern compiled regex
     * @param peptide peptide/protein to match on
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getIndexList(final Pattern pattern, final String peptide) {
        ArrayList<Integer> indices = new ArrayList<>();
        Matcher matcher = pattern.matcher(peptide);
        while (matcher.find()) {
            if (!indices.contains(matcher.start() + 1)) {
                indices.add(matcher.start() + 1);
            }
        }
        return indices;
    }
}
