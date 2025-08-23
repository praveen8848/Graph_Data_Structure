package Representation;

import java.util.ArrayList;
import java.util.List;

public class one {
    public static void main(String[] args) {
        graphmatrix gp = new graphmatrix(5);
        gp.addEdge(0, 1);
        gp.addEdge(0, 4);
        gp.addEdge(1, 2);
        gp.addEdge(1, 3);
        gp.addEdge(1, 4);
        gp.addEdge(2, 3);
        gp.addEdge(3, 4);
        System.out.println("Printing undirected graph.");
        gp.showGraph();
        System.out.println();

        System.out.println("Printing Undirected Graph by list approach.");
        graphmatrixlist gpl = new graphmatrixlist(5);
        gpl.addinGraph(0, 1);
        gpl.addinGraph(0, 4);
        gpl.addinGraph(1, 2);
        gpl.addinGraph(1, 3);
        gpl.addinGraph(1, 4);
        gpl.addinGraph(2, 3);
        gpl.addinGraph(3, 4);
        gpl.showtheGraph();
        System.out.println();
        System.out.println("Showing Graph Edge list.");
        EdgeList el = new EdgeList();
        el.addinEdgeList(0,1);
        el.addinEdgeList(0,4);
        el.addinEdgeList(1,2);
        el.addinEdgeList(1,3);
        el.addinEdgeList(1,4);
        el.addinEdgeList(2,3);
        el.addinEdgeList(3,4);
        el.showthelist();
    }
}
class graphmatrix{
    int v;
    int[][] matrix;
    public graphmatrix(int x){
        this.v = x;
        matrix = new int[v][v];

    }
    public void addEdge(int u, int v){
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    public void showGraph(){
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println("Adjacency matrix.");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
class graphmatrixlist{
    ArrayList<ArrayList<Integer>> lst;
    public graphmatrixlist(int e){
        lst = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            lst.add(new ArrayList<>());
        }
    }
    public void addinGraph(int x, int y){
        lst.get(x).add(y);
        lst.get(y).add(x);
    }

    public void showtheGraph(){
        for (int i = 0; i<lst.size(); i++){
            System.out.print(i + "->");
            for(int v : lst.get(i)){
                System.out.print( v + " ");
            }
            System.out.println();
        }
    }
    public int size(){
        return lst.size();
    }
    public ArrayList<ArrayList<Integer>> returnList(){
        return lst;
    }
}

class Edge{
    int s;
    int d;
    public Edge(int x, int y){
        this.s = x;
        this.d = y;
    }

}

 class EdgeList{
    private List<Edge> list;
    public EdgeList(){
        list = new ArrayList<>();

    }
    public void addinEdgeList(int u, int v){
        list.add(new Edge(u, v));
        list.add(new Edge(v, u));
    }
    public void showthelist(){
        System.out.println("Edge List: ");
        for(Edge e : list){
            System.out.println(e.s + " -> "+ e.d);
        }
    }

}

