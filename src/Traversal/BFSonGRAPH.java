package Traversal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BFSonGRAPH {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(),
                        new ArrayList<>(Arrays.asList(2,4)),
                        new ArrayList<>(Arrays.asList(1,3)),
                        new ArrayList<>(Arrays.asList(2,4)),
                        new ArrayList<>(Arrays.asList(1,3))
                )
        );
        Queue<Integer> qt = new ArrayDeque<>();
        boolean[] flag = new boolean[5];
        qt.add(1);
        flag[1] = true;
        while (!qt.isEmpty()){
            int t = qt.poll();
            System.out.print(t + " ");

            for (int neighbour : lst.get(t)){
                if(!flag[neighbour]){
                    qt.add(neighbour);
                    flag[neighbour] = true;
                }
            }

        }
        System.out.println();
        bfs(1, lst);
    }
    public static void bfs(int start, ArrayList<ArrayList<Integer>> list){
        boolean[] visted = new boolean[5];
        Queue<Integer> qt = new ArrayDeque<>();
        qt.offer(start);
        visted[start] = true;

        while (!qt.isEmpty()){
            int next = qt.poll();
            System.out.print(next + " ");
            for(int neighbour : list.get(next)){
                if(!visted[neighbour]){
                    qt.add(neighbour);
                    visted[neighbour] = true;
                }
            }
        }
    }
}
