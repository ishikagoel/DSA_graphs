import java.util.*;
import java.io.*;

public class PrimsAlgo {
    public static class edge implements Comparable<edge> {
        int p;
        int v;
        int w;

        edge(int v, int p, int w) {
            this.p = p;
            this.v = v;
            this.w = w;
        }

        public int compareTo(edge o) {
            return this.w - o.w;
        }

    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int[][] graph = new int[n][n];
        List<List<edge>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w = obj.nextInt();
                graph[i][j] = w;
                if (w != 0) {
                    arr.get(i).add(new edge(j, i, w));
                    arr.get(j).add(new edge(i, j, w));
                }
            }
        }
        boolean[] vis = new boolean[n];
        dfs(arr, n, vis);

    }

    public static void dfs(List<List<edge>> arr, int n, boolean[] vis) {
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(0, -1, 0));
        while (!pq.isEmpty()) {
            edge rm = pq.poll();

            if (vis[rm.v] == true)
                continue;
            vis[rm.v] = true;
            if (rm.p != -1)
                System.out.println(rm.p + " " + rm.v + " " + rm.w);
            for (edge it : arr.get(rm.v)) {
                if (vis[it.v] == false) {
                    pq.add(new edge(it.v, rm.v, it.w));
                }
            }
        }
    }
}