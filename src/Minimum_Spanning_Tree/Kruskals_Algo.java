package Minimum_Spanning_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskals_Algo {
    public static void main(String[] args) {
        int n = 5;
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 1),
                new Edge(1, 2, 2),
                new Edge(3, 4, 3)
        );
        int ans = kruskal(n, edges);
        System.out.println("MST Weight = " + ans);
    }

    static class Edge {
        int u;
        int v;
        int w;

        Edge(int a, int b, int c) {
            u = a;
            v = b;
            w = c;
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[px] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public static int kruskal(int n, List<Edge> e) {
        Collections.sort(e, (a, b) -> a.w - b.w);

        DSU dsu = new DSU(n);
        int mstSum = 0;
        int edgesTaken = 0;
        List<Edge> lst = new ArrayList<>();

        for (Edge ed : e) {
            int u = ed.u;
            int v = ed.v;

            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                mstSum += ed.w;
                lst.add(ed);
            }
        }
        if (lst.size() != n - 1) {
            System.out.println("No MST exists (Graph is disconnected).");
            return -1;
        }
        System.out.println("MST Edges: ");
        for (Edge ee : lst) {
            System.out.println(ee.u + " -- " + ee.v + " (weight = " + ee.w + ")");
        }
        return mstSum;
    }
}