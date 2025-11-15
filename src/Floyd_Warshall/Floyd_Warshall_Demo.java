package Floyd_Warshall;

public class Floyd_Warshall_Demo {
    static final int INF = 1000000000;
    public static void main(String[] args) {
        int[][] graph = {
                {0,   1,   INF, INF},
                {INF, 0,   -4,  INF},
                {INF, -10, 0,   2},
                {3,   INF, INF, 0}
        };
        FloydWarshall(graph);
    }
    public static void FloydWarshall(int[][] graph){
        int n = graph.length;

        for (int via = 0; via < n; via++) {
            for (int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(graph[i][via] != INF && graph[via][j] != INF){
                        graph[i][j] = Math.min(graph[i][j], graph[i][via]+graph[via][j]);
                    }
                }
            }
        }
        printThePath(graph);
    }
    public static void printThePath(int[][] graph){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.println("Shortest Distance from node " + i+" to node " + j + " is: " +graph[i][j]);
            }
        }
    }
}
