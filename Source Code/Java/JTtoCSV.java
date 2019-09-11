//Created by Aminul on 8/6/2019.

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class JTtoCSV {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        try {
            in = new Scanner(new FileInputStream("output_degree.txt"));
            pw = new PrintWriter("JT_degree_mapped.csv");
        } catch (Exception e) { }

        pw.println("row1,row2,row3,row4,row5,P_value,J_value");
        while (in.hasNextLine()) {
            /*String line = in.nextLine();
            while (line.startsWith("class")) {
                line = in.nextLine();
            }*/
            StringBuilder sb = new StringBuilder();
            in.nextLine();
            StringTokenizer st = new StringTokenizer(in.nextLine());
            st.nextElement();
            int x = 0;
            while (st.hasMoreElements()) {
                String str = st.nextToken(), out = "";
                if(x == 5 || x == 6) out = str;
                else if(str.equals("1")) out = "fb";
                else if(str.equals("2")) out = "crime";
                else if(str.equals("3")) out = "p2p";
                else if(str.equals("4")) out = "amazon";
                else out = "email_eu";
                sb.append(out);
                sb.append(",");
                x++;
            }
            st = new StringTokenizer(in.nextLine());
            st.nextElement();
            String str = st.nextToken();
            sb.append(str);
            sb.append(",");
            in.nextLine();
            sb.append(in.nextLine().trim());

            pw.println(sb.toString());
        }


        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}