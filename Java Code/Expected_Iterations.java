//Created by Aminul on 3/25/2019.

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Expected_Iterations {
    public static void main(String[] args)throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 100; i <= 10000; i+=100) {
            pw.printf("Number of nodes: %d, Iterations: %d\n", i, count_iteration(i));
        }
        pw.close();
    }

    static int count_iteration(int n) {
        double average = 0, TRIALS = 100;
        for(int trial = 0; trial < TRIALS; trial++) {
            int edges = 0, iterations = 0;
            DSU dsu = new DSU(n);
            Random random = new Random();
            //HashSet<Long> set = new HashSet<>();
            while (edges < n - 1) {
                int u = random.nextInt(n), v = random.nextInt(n);
               // if(!set.add(getHash(u, v))) continue; // ignoring duplicate edges
                if (dsu.union(u, v)) {
                    edges++;
                }
                iterations++;
            }
            average += iterations;
        }
        return (int) round(average / TRIALS);
    }

    static long getHash(long u, long v) {
        return ( min(u, v) << 31 ) | v;
    }

    static class DSU {
        int parent[], size[], n;
        DSU(int N){
            n = N;
            parent = new int[N];
            size = new int[N];
            for(int i = 0; i < N; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        DSU(int [] p){
            parent = p; n = p.length;
        }

        int find(int i) {
            int p = parent[i];
            if (i == p) return i;
            return parent[i] = find(p);
        }

        boolean equiv(int u, int v){
            return find(u) == find(v);
        }

        boolean union(int u, int v){
            u = find(u); v = find(v);
            if(u == v) return false;
            if(size[u] > size[v]){
                int t = u; u = v; v = t;
            }
            parent[u] = v;
            size[v] += size[u];
            return true;
        }

        int count(){
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(i == find(i)) cnt++;
            }
            return cnt;
        }
    }

    static void debug(Object...obj) {
        System.err.println(Arrays.deepToString(obj));
    }
}