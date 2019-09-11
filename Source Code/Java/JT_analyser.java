/**
 * Created by Aminul on 8/28/2019.
 */

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class JT_analyser {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        try {
            in = new Scanner(new FileInputStream("JT_eigen_mapped.csv"));
            pw = new PrintWriter("JT_eigen_postition_percentage.txt");
        } catch (Exception e) {}

        in.nextLine();
        List<Pair> g = new ArrayList<>();
        while (in.hasNextLine()) {
            String a[] = in.nextLine().split(",");
            Pair p = new Pair(Arrays.copyOfRange(a, 0, 5), Double.parseDouble(a[5]));
            g.add(p);
        }
        Collections.sort(g);
        double total = 0;
        HashMap<String, int[]> frequency = new HashMap<>();
        HashMap<String, double[]> result = new HashMap<>();
        for (int i = 0; i < g.size() / 5; i++) {
            Pair p = g.get(i);
            for(int j = 0; j < p.a.length; j++) {
                frequency.putIfAbsent(p.a[j], new int[p.a.length]);
                frequency.get(p.a[j])[j]++;
            }
            total++;
        }

        for(String key : frequency.keySet()) {
            //debug(key, frequency.get(key));
            result.putIfAbsent(key, new double[5]);
            int i = 0;
            for(int j : frequency.get(key)) {
                result.get(key)[i++] = (j / total) * 100.0;
            }
        }

        for(String key : result.keySet()) {
            pw.println("Data set: " +key);
            int i = 1;
            for(double j : result.get(key)) {
                pw.println("at position " + i + ": " + + j + " %");
                i++;
            }

            pw.println();
        }


        pw.close();
    }

    static class Pair implements Comparable<Pair> {
        String a[];
        double p;

        Pair() {

        }

        Pair(String arr[], double pp) {
            a = arr;
            p = pp;
        }

        public int compareTo(Pair pr) {
            return Double.compare(p, pr.p);
        }

        public String toString() {
            return Arrays.deepToString(a) + " " + p;
        }
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

}