import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildingTeams {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int m = obj.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int u = obj.nextInt();
            int v = obj.nextInt();
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        Teams(arr, n);
    }

    public static void Teams(ArrayList<ArrayList<Integer>> arr, int n) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        int f = 0;
        for (int i = 0; i <= n; i++) {
            if (vis[i] == -1) {
                vis[i] = 0;
                if (dfs(arr, i, vis) == false) {
                    f = 1;
                }
            }
        }
        if (f == 0) {
            for (int i = 1; i <= n; i++) {
                System.out.print(vis[i] + 1 + " ");
            }
            System.out.println();
        } else
            System.out.println("IMPOSSIBLE");

    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> arr, int s, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for (Integer it : arr.get(node)) {
                if (vis[it] == -1) {
                    q.add(it);
                    vis[it] = vis[node] == 1 ? 0 : 1;
                } else if (vis[node] == vis[it])
                    return false;
            }

        }
        return true;
    }

    public static boolean dfs(ArrayList<ArrayList<Integer>> arr, int s, int[] vis) {
        if (vis[s] == -1)
            vis[s] = 0;

        for (Integer it : arr.get(s)) {
            if (vis[it] == -1) {
                if (vis[s] == 1) {
                    vis[it] = 0;
                } else
                    vis[it] = 1;
                if (!dfs(arr, it, vis))
                    return false;
            } else if (vis[it] == vis[s])
                return false;

        }
        return true;
    }

}
