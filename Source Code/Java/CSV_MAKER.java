/**
 * Created by Aminul on 8/4/2019.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;

public class CSV_MAKER {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        File dir = new File("E:\\amazon");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File file : directoryListing) {
                try {
                    in = new Scanner(new FileInputStream(file));
                    pw = new PrintWriter("C:\\Users\\499AZK\\IdeaProjects\\Sohail_T-IT\\CSV\\" + file.getName().replace(".txt", ".csv") );
                } catch (Exception e) {
                    e.printStackTrace();
                }
               // pw.println("from,to");
                //in.nextLine();
                boolean b = true;
                while (in.hasNextLine()) {
                    String line = in.nextLine().replaceAll("\t", ",");
                    if(line.length() >0) pw.println(line);
                }
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