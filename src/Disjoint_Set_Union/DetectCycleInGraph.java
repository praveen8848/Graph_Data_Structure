package Disjoint_Set_Union;

class OptimizedDSU {
    int[] parent;
    int[] rank;

    public OptimizedDSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i<n; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            // If already in the same set, then cycle detected
            return false;
        }

        // Attach smaller rank tree under larger rank tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}
public class DetectCycleInGraph {
    public static boolean hasCycle(int n, int[][] edges) {
        OptimizedDSU dsu = new OptimizedDSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If union fails, means cycle detected
            if (!dsu.union(u, v)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5; // number of nodes
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4},
                {2, 4}, // Adding this connects all nodes
                {4, 0}  // This creates a cycle
        };

        if (hasCycle(n, edges)) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does not contain a cycle.");
        }
    }
}

