/**
 * Created by Aminul on 8/4/2019.
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

import java.io.File;

public class Median_Betweeness {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        File dir = new File("E:\\analysised folder\\amazon");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                try {
                    in = new Scanner(new FileInputStream(file));
                    pw = new PrintWriter("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\output_amazon\\" + file.getName() + "_avg.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }


                List<Double> g = new ArrayList<>();
                in.nextLine();
                while (in.hasNextLine()) {
                    StringTokenizer st = new StringTokenizer(in.nextLine(), ",");
                    st.nextElement();
                    String num = st.nextToken();
                    try {
                        g.add(Double.parseDouble(num));
                    } catch (Exception e) {
                      //  debug(num);
                    }
                }

                Collections.sort(g);
                double median = g.get(g.size() / 2), avg = 0;
                if (g.size() % 2 == 0) median = (g.get(g.size() / 2) + g.get((g.size() / 2) + 1)) / 2.0;
                for (double d : g) avg += d;
                pw.printf("%.5f\n", avg / g.size());
                pw.close();
            }
        } else {
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
        }


        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}