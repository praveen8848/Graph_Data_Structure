package Disjoint_Set_Union;

// Disjoint Set Union (Union-Find) Data Structure
class DisjointSet {
    private int[] parent; // Stores parent (leader) of each node
    private int[] rank;   // Stores rank (approximate tree height)

    // Constructor: initialize DSU with n elements
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;   // Each node is its own parent initially
            rank[i] = 0;     // Rank starts from 0
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] != x) {
            // Recursively find parent and compress the path
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by Rank
    // Returns false if x and y are already in the same set (cycle detected)
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // If both nodes have the same root -> cycle
        if (rootX == rootY) {
            return false;
        }

        // Attach smaller rank tree under larger rank tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY; // rootX becomes child of rootY
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX; // rootY becomes child of rootX
        } else {
            // If both ranks are equal, choose one root and increase its rank
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}

public class DetectCycleInGraph {
    // Function to check if an undirected graph contains a cycle
    public static boolean hasCycle(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);

        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If union returns false => u and v already connected => cycle exists
            if (!dsu.union(u, v)) {
                return true;
            }
        }
        return false; // No cycle found
    }

    public static void main(String[] args) {
        int n = 5; // number of nodes
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4},
                {2, 4}, // connecting components
                {4, 0}  // creates cycle
        };

        // Call function and print result
        if (hasCycle(n, edges)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}
