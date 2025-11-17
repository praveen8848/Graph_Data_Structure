package Minimum_Spanning_Tree;


import java.util.*;

public class Prims_Algo {

    static class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public static int prims(int n, List<List<Pair>> adj) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));  // Start from node 0
        int mstSum = 0;
        int edgesTaken = 0;

        List<String> mstEdges = new ArrayList<>();

        while (!pq.isEmpty() && edgesTaken < n - 1) {

            Pair curr = pq.poll();
            int node = curr.node;
            int wt = curr.weight;

            if (visited[node]) continue;

            visited[node] = true;
            mstSum += wt;

            if (wt != 0) {
                mstEdges.add("Added edge with weight " + wt);
                edgesTaken++;
            }

            for (Pair p : adj.get(node)) {
                if (!visited[p.node]) {
                    pq.add(new Pair(p.node, p.weight));
                }
            }
        }

        if (edgesTaken != n - 1) {
            System.out.println("No MST exists (Graph is disconnected).");
            return -1;
        }

        System.out.println("MST Edges (weights only):");
        for (String s : mstEdges) System.out.println(s);

        return mstSum;
    }

    public static void main(String[] args) {

        int n = 5;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Undirected Graph
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);
        addEdge(adj, 3, 4, 9);

        int mstWeight = prims(n, adj);
        System.out.println("Total MST Weight = " + mstWeight);
    }

    static void addEdge(List<List<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }
}
