import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Sorter {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw = new PrintWriter("sorted_eigenvector.txt");
        File dir = new File("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\eigenvector_output");
        File[] directoryListing = dir.listFiles();
        //debug(directoryListing);
        if (directoryListing != null) {
            for (File folder : directoryListing) {
                List<Double> g = new ArrayList<>();
                for (File file : folder.listFiles()) {
                    //List<Double> g = new ArrayList<>();

                    debug(file.getName());
                    try {
                        in = new Scanner(new FileInputStream(file));
                    } catch (Exception e) {
                    }
                    g.add(in.nextDouble());
                }
                Collections.sort(g);
                for (double d : g) pw.printf("%.15f, ", d);
                pw.println();
            }

        }
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}