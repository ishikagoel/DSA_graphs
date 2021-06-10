import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NewsDistribution {
    static Stack<Integer> s = new Stack<>();
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().trim().split(" ");
            for (int j = 1; j < Integer.parseInt(s1[0]); j++) {
                int u = Integer.parseInt(s1[j]);
                int v = Integer.parseInt(s1[j + 1]);
                arr.get(u).add(v);
                arr.get(v).add(u);
            }
        }
        dfs1(arr, n);

    }

    public static void dfs1(List<List<Integer>> arr, int n) {
        int[] vis = new int[n + 1];
        int[] fs = new int[n + 1];
        Arrays.fill(vis, -1);
        for (int i = 1; i <= n; i++) {
            if (vis[i] == -1) {
                dfs(arr, vis, i, s);
                for (int j = 0; j < s.size(); j++) {
                    fs[s.get(j)] = ans;
                }
            }
            s.clear();
            ans = 0;
        }
        StringBuilder out=new StringBuilder();
		for(int i=1; i<=n; i++)
			out.append(fs[i]+" ");
		System.out.println(out);
    }

    public static void dfs(List<List<Integer>> arr, int[] vis, int node, Stack<Integer> s) {
        vis[node] = 1;
        s.add(node);
        ans++;
        // System.out.println(ans + " " + node);
        for (int it : arr.get(node)) {
            if (vis[it] == -1) {
                dfs(arr, vis, it, s);
            }
        }
        // System.out.println(ans + " " + node);
        return;
    }

}
