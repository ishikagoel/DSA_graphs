import java.util.*;
import java.io.*;

public class Dijikstra {
    public static class edge {
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

    static class pair implements Comparable<pair> {
        int v, wsf;
        String psf;

        pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = 9;
        // int[][] graph = new int[n][n];
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        List<List<edge>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            arr.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w = graph[i][j];
                if (graph[i][j] != 0) {
                    arr.get(i).add(new edge(j, i, w));
                    arr.get(j).add(new edge(i, j, w));
                }
            }
        }
        boolean[] vis = new boolean[n];
        Arrays.fill(vis, false);
        dfs(arr, n, vis);

    }

    public static void dfs(List<List<edge>> arr, int n, boolean[] vis) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0, 0 + "", 0));
        while (!pq.isEmpty()) {
            pair rm = pq.poll();
            if (vis[rm.v] == true) {
                continue;
            }
            vis[rm.v] = true;
            System.out.println(rm.v + " " + rm.psf + " " + rm.wsf);
            for (edge it : arr.get(rm.v)) {
                if (vis[it.v] == false) {
                    pq.add(new pair(it.v, rm.psf + it.v, rm.wsf + it.w));
                }
            }
        }
    }

}
