//Created by Aminul on 3/26/2019.

import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class EigenCertainty {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        try {
            in = new Scanner(new FileInputStream("random_graph.txt"));
        } catch (Exception e){
            debug("FILE NOT FOUND, TAKING INPUT FROM STDIN");
        }
        int n = in.nextInt(), edges = in.nextInt();
        double adjacencyMatrix[][] = new double[n][n];
        while (edges-- > 0) {
            int u = in.nextInt(), v = in.nextInt();
            adjacencyMatrix[u][v] = adjacencyMatrix[v][u] = 1;
        }
        double certainty[] = getCentrality(adjacencyMatrix, n);
        for (int i = 0; i < n; i++) {
            pw.printf("Node: %d, Centrality: %.3f\n", i, certainty[i]);
        }
        pw.close();
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static double[] getCentrality(double[][] g, int n) {
        RealMatrix m = MatrixUtils.createRealMatrix(g);
        EigenDecomposition ed = new EigenDecomposition(m);

        double maxValue = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            double value = ed.getRealEigenvalue(i);
            if (maxValue < value) {
                x = i;
                maxValue = value;
            }
        }

        double c[] = new double[n];
        for (int i = 0; i < n; i++) {
            double a = Math.abs(ed.getEigenvector(x).getEntry(i));
            c[i] = a;
        }
        return c;
    }
}