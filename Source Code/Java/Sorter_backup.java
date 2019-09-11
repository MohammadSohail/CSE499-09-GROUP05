import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;

public class Sorter_backup {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw = new PrintWriter("sorted_eigenvector.txt");
        File dir = new File("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\eigenvector_output");
        File[] directoryListing = dir.listFiles();
        //debug(directoryListing);
        if (directoryListing != null) {
            for (File file : directoryListing) {
                // debug(file.getName());
                try {
                    in = new Scanner(new FileInputStream(file));
                } catch (Exception e) {
                }
                while (in.hasNextLine()) {
                    StringTokenizer stringTokenizer = new StringTokenizer(in.nextLine(), ",");
                    List<Double> g = new ArrayList<>();
                    while (stringTokenizer.hasMoreElements()) g.add(Double.parseDouble(stringTokenizer.nextToken()));
                    Collections.sort(g);
                    for (double d : g) pw.printf("%.15f, ", d);
                    pw.println();
                }
            }
        }
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}