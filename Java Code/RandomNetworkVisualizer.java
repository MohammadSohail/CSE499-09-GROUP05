import java.io.*;
import java.util.*;
import static java.lang.Math.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.*;

public class RandomNetworkVisualizer {
    public static void main(String[] args)throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int number_of_nodes = 50;
        Graph graph = getRandomGraph(number_of_nodes, "graph");
        graph.display();
          
        pw.close();
    }

    static Graph getRandomGraph(int n, String graphName) {
        Graph graph = new SingleGraph(graphName);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            graph.addNode(String.valueOf(i));
        }
        for (int i = 1; i <= n; i++) {
            String u = String.valueOf(random.nextInt(n));
            String v = String.valueOf(random.nextInt(n));
            try {
                graph.addEdge(u+v, u, v);
            } catch (Exception e) {
                continue;
            }
        }
        return graph;
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}