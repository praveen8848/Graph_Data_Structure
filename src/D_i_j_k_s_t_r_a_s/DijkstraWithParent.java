package D_i_j_k_s_t_r_a_s;

import java.util.*;


public class DijkstraWithParent {

    // Dijkstra algorithm with parent array
    public static void dijkstra(List<List<Pair>> adj, int source, int n) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1); // -1 means no parent

        dist[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.weight;

            if(d > dist[u]) continue;

            for(Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int w = neighbor.weight;

                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;           // Update parent
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + source + ":");
        for(int i = 0; i < n; i++) {
            System.out.println("Node " + i + " : " + dist[i]);
        }

        // Print shortest paths
        System.out.println("\nShortest paths from node " + source + ":");
        for(int i = 0; i < n; i++) {
            if(i == source) continue;
            List<Integer> path = new ArrayList<>();
            int node = i;
            while(node != -1) {
                path.add(node);
                node = parent[node];
            }
            Collections.reverse(path);
            System.out.println("Path to " + i + " : " + path);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        adj.get(0).add(new Pair(1, 2)); // A -> B (weight 2)
        adj.get(0).add(new Pair(3, 1)); // A -> D (weight 1)
        adj.get(1).add(new Pair(2, 3)); // B -> C (weight 3)
        adj.get(3).add(new Pair(2, 5)); // D -> C (weight 5)

        int source = 0; // Start from node A (0)
        dijkstra(adj, source, n);
    }
}
