//Created by Aminul on 8/27/2019.

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class PageRank_cleaner {
    public static void main(String[] args)throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        File dir = new File("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\eigenvector\\amazon");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                debug(file.getName());
                try {
                    in = new Scanner(new FileInputStream(file));
                    pw = new PrintWriter("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\eigenvector_output\\amazon\\" + file.getName().replace(".txt", "") + "_avg.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                StringTokenizer stringTokenizer = new StringTokenizer(in.nextLine(), "{}:,");
                double sum = 0, cnt = 0;
                while (stringTokenizer.hasMoreElements()) {
                    String x = stringTokenizer.nextToken();
                    String y = stringTokenizer.nextToken();
                    sum += Double.parseDouble(y);
                    //debug(y);
                    cnt++;
                }
                pw.println(sum / cnt);
                pw.close();
            }
        }
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}