import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStreamReader;
public class BuildingRoads {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        Roads(arr, n);
        // System.out.println(arr);

    }

    public static void Roads(ArrayList<ArrayList<Integer>> arr, int n) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        dfs(arr, vis, 1);
        for (int i = 2; i <= n; i++) {
            if (vis[i] == -1) {
                dfs(arr, vis, i);
                sb.append(i - 1 + " " + i);
                sb.append("\n");
                ans++;
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> arr, int[] vis, int s) {
        if (vis[s] == 1)
            return;
        vis[s] = 1;
        for (Integer it : arr.get(s)) {
            if (vis[it] == -1) {
                dfs(arr, vis, it);
            }

        }
    }
}
