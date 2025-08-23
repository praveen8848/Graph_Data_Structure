package Representation;

import java.util.ArrayList;
import java.util.List;

public class Representation_of_Directed_Graph {
    public static void main(String[] args) {
        graphmatrix_ gp = new graphmatrix_(5);
        gp.addEdge(0, 1);
        gp.addEdge(0, 4);
        gp.addEdge(1, 2);
        gp.addEdge(1, 3);
        gp.addEdge(1, 4);
        gp.addEdge(2, 3);
        gp.addEdge(3, 4);
        System.out.println("Printing directed graph.");
        gp.showGraph();
        System.out.println();

        System.out.println("Printing Unditrected Graph by list approach.");
        graphmatrixlist_ gpl = new graphmatrixlist_(5);
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
        EdgeList_ el = new EdgeList_();
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

class graphmatrix_{
    int v;
    int[][] matrix;
    public graphmatrix_(int x){
        this.v = x;
        matrix = new int[v][v];

    }
    public void addEdge(int u, int v){
        matrix[u][v] = 1;
        //matrix[v][u] = 1;
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
class graphmatrixlist_{
    ArrayList<ArrayList<Integer>> lst;
    public graphmatrixlist_(int e){
        lst = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            lst.add(new ArrayList<>());
        }
    }
    public void addinGraph(int x, int y){
        lst.get(x).add(y);
      //  lst.get(y).add(x);
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
}

class Edge_{
    int s;
    int d;
    public Edge_(int x, int y){
        this.s = x;
        this.d = y;
    }

}

class EdgeList_{
    private List<Edge_> list;
    public EdgeList_(){
        list = new ArrayList<>();

    }
    public void addinEdgeList(int u, int v){
        list.add(new Edge_(u, v));
        //list.add(new Edge_(v, u));
    }
    public void showthelist(){
        System.out.println("Edge List: ");
        for(Edge_  e : list){
            System.out.println(e.s + " -> "+ e.d);
        }
    }

}


