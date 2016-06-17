package proteindigesters;

import java.util.ArrayList;

/**
 *
 * @author arne
 */
public class ProteinDigester {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        String demoPeptide = "VEGTLKGPEVDLKGPR";
        Integer i = 1;
        Integer count = 0;
        ArrayList<String> peptides = new ArrayList<>();
        while (count < i) {
             count++;
             peptides.add(demoPeptide);
        }
        // minimal peptide length = 6 and miscleavages = 3
        Digester trypsinDigester = new TrypsinDigester(6, 3); 
        for (String peptide : peptides) {
            System.out.println(trypsinDigester.digest(peptide));
        }

    }
}
