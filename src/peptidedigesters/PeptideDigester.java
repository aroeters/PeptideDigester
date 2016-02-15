package peptidedigesters;

import java.util.ArrayList;

/**
 *
 * @author arne
 */
public class PeptideDigester {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        String peptideTRY = "ADHPRFPIDVSGPSVWMDTDKSHKYAPDFDIEGPEGWM";
        String peptideTRY2 = "GHYEVTGSDDETGKLQGSGVSLASKK";
        String peptideTRY3 = "GDVPSVGLEGPDVDLQGPEAK";
        String peptideTRY4 = "VEGTLKGPEVDLKGPR";
        String peptideTRY5 = "ADLDVSGPKVDIDVPDVNIEGPEGK";
        Integer i = 1000000;
        Integer count = 0;
        ArrayList<String> tryout = new ArrayList<>();
        while (count < i) {
             count++;
             tryout.add(peptideTRY);
             tryout.add(peptideTRY2);
             tryout.add(peptideTRY3);
             tryout.add(peptideTRY4);
             tryout.add(peptideTRY5);
        }
        System.out.println("Starting to process " + i*5 + " peptides to show the performance.");
        ChemotrypsinDigesterLowSpecific o1 = new ChemotrypsinDigesterLowSpecific(6);
        long start1 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o1.digest(peptide);
        }
        System.out.println("Chemotrypsin low spec\t" +(System.currentTimeMillis() - start1)/1000 + " s");
        ChemotrypsinDigesterHighSpecific o2 = new ChemotrypsinDigesterHighSpecific(6);
        long start2 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o2.digest(peptide);
        }
        System.out.println("Chemotrypsin high spec\t" +(System.currentTimeMillis() - start2)/1000 + " s");
        TrypsinDigester o3 = new TrypsinDigester(6);
        long start3 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o3.digest(peptide);
        }
        System.out.println("Trypsin\t\t\t" +(System.currentTimeMillis() - start3)/1000 + " s");
        TrypsinDigesterConservative o4 = new TrypsinDigesterConservative(6);
        long start4 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o4.digest(peptide);
        }
        System.out.println("Trypsin Conservative\t" +(System.currentTimeMillis() - start4)/1000 + " s");
        PepsinDigesterHigherPH o5 = new PepsinDigesterHigherPH(6);
        long start5 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o5.digest(peptide);
        }
        System.out.println("PepsinDigestorHigherPH\t" +(System.currentTimeMillis() - start5)/1000 + " s");
        PepsinDigesterLowPH o6 = new PepsinDigesterLowPH(6);
        long start6 = System.currentTimeMillis();
        for (String peptide : tryout) {
            o6.digest(peptide);
        }
        System.out.println("PepsinDigestorLowPH\t" + (System.currentTimeMillis() - start6)/1000 + " s");
    }
}
