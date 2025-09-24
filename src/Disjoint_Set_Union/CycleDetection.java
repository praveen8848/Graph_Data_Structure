package Disjoint_Set_Union;

// Naive DSU approach to check Cycle in undirected graph
public class CycleDetection {
    private int[] parent;

    public CycleDetection(int n){
        parent = new int[n];
        for(int i= 0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }

    public boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            //cycle found
            return true;
        }
        parent[rootA] = rootB;
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        // Undirected Graph
        int[][] edges = { {0,1}, {1,2}, {2,3}, {3,0} };
        boolean check = true;
        CycleDetection DSU = new CycleDetection(n);
        for(int[] edge : edges){
            if(DSU.union(edge[0], edge[1])){
                System.out.println("Cycle found in the graph.");
                check =false;
                break;
            }
        }
        if(check){
            System.out.println("No Cycle in the Graph.");
        }
    }
}
