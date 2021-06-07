import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class RoundTrips {
    static boolean flag = false;

    public static class pair {
        int n, p;

        pair(int x, int y) {
            n = x;
            p = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<ArrayList<pair>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            arr.get(u).add(new pair(v, u));
            arr.get(v).add(new pair(u, v));
        }
        // for (int i = 0; i < arr.size(); i++) {
        // for (int j = 0; j < arr.get(i).size(); j++) {
        // System.out.print(arr.get(i).get(j).n + " ");
        // }
        // System.out.println();
        // }
        Trips(arr, n);
    }

    public static void Trips(ArrayList<ArrayList<pair>> arr, int n) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        // String storedfs;
        Stack<Integer> storedfs = new Stack<>();
        for (int i = 1; i <= n; i++) {

            if (vis[i] == -1) {
                pair p = new pair(i, 0);
                dfs(arr, vis, p, storedfs, 0);
            }
        }
        if (flag == false)
            System.out.println("IMPOSSIBLE");
    }

    public static void dfs(ArrayList<ArrayList<pair>> arr, int[] vis, pair node, Stack<Integer> storedfs, int ans) {
        // System.out.println(storedfs);
        if (vis[node.n] == 1 && storedfs.size() > 3) {
            storedfs.add(node.n);
            if (!flag) {
                System.out.println(storedfs);
                flag = true;
            }
            return;
        }
        vis[node.n] = 1;
        for (pair it : arr.get(node.n)) {
            if (it.n != node.p) {
                storedfs.add(it.n);
                dfs(arr, vis, it, storedfs, ans + 1);
            }
        }
        vis[node.n] = 0;
    }

}
