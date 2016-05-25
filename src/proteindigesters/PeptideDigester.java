package proteindigesters;

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
        String peptideTry = "VEGTLKGPEVDLKGPR";
        Integer i = 1;
        Integer count = 0;
        ArrayList<String> tryout = new ArrayList<>();
        while (count < i) {
             count++;
             tryout.add(peptideTry);
        }

        TrypsinDigester o4 = new TrypsinDigester(6, 3);
        long start4 = System.currentTimeMillis();
        for (String peptide : tryout) {
            System.out.println(o4.digest(peptide));
        }
        System.out.println("Trypsin Conservative\t" +(System.currentTimeMillis() - start4)/1000 + " s");
//        PepsinDigesterHigherPH o5 = new PepsinDigesterHigherPH(0, 3);
//        long start5 = System.currentTimeMillis();
//        for (String peptide : tryout) {
//            o5.digest(peptide);
//        }
//        System.out.println("PepsinDigestorHigherPH\t" +(System.currentTimeMillis() - start5)/1000 + " s");
//        PepsinDigesterLowPH o6 = new PepsinDigesterLowPH(0, 3);
//        long start6 = System.currentTimeMillis();
//        for (String peptide : tryout) {
//            o6.digest(peptide);
//        }
//        System.out.println("PepsinDigestorLowPH\t" + (System.currentTimeMillis() - start6)/1000 + " s");
    }
}
