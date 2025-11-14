package Bellman_Ford;

import java.util.*;

// A simple Edge structure


public class BellmanFord {

    // Bellman-Ford Algorithm
    public static void bellmanFord(int V, int E, int src, Edge[] edges) {

        // Step 1: Create distance array and initialize
        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 1; i <= V - 1; i++) {
            for (Edge e : edges) {

                // If src node of edge is reachable
                if (dist[e.src] != Integer.MAX_VALUE &&
                        dist[e.src] + e.weight < dist[e.dest]) {

                    dist[e.dest] = dist[e.src] + e.weight;
                    parent[e.dest] = e.src;
                }
            }
        }

        // Step 3: Check for negative-weight cycle
        for (Edge e : edges) {
            if (dist[e.src] != Integer.MAX_VALUE &&
                    dist[e.src] + e.weight < dist[e.dest]) {

                System.out.println("Graph contains a negative-weight cycle!");
                return;
            }
        }

        // Step 4: Print results
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " : " + dist[i]);
        }

        // Step 5: (Optional) Print paths
        System.out.println("\nPaths from source:");
        for (int v = 0; v < V; v++) {
            if (dist[v] == Integer.MAX_VALUE) {
                System.out.println("No path to node " + v);
            } else {
                printPath(v, parent);
            }
        }
    }

    // Function to print the path using parent array
    private static void printPath(int v, int[] parent) {
        List<Integer> path = new ArrayList<>();

        while (v != -1) {
            path.add(v);
            v = parent[v];
        }

        Collections.reverse(path);
        System.out.println(path);
    }


    // Main function to run and test the algorithm
    public static void main(String[] args) {

        // Number of vertices and edges
        int V = 5;
        int E = 8;

        // Create graph as an edge list
        Edge[] edges = new Edge[E];

        // Example graph
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        // Run Bellman-Ford
        bellmanFord(V, E, 0, edges);
    }
}
