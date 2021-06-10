import java.util.*;
import java.io.*;

public class StepsByKnight {
    static class pair {
        int x, y, ans;

        pair(int x, int y, int ans) {
            this.x = x;
            this.y = y;
            this.ans = ans;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int[] kinghtpos = new int[2];
        kinghtpos[0] = Integer.parseInt(s[0]);
        kinghtpos[1] = Integer.parseInt(s[1]);
        int[] targetpos = new int[2];
        String[] s1 = br.readLine().trim().split(" ");
        targetpos[0] = Integer.parseInt(s1[0]);
        targetpos[1] = Integer.parseInt(s1[1]);
        int n = Integer.parseInt(br.readLine());
        // System.out.println(n);
        graph(kinghtpos, n, targetpos);
    }

    public static void graph(int[] kinghtpos, int n, int[] targetpos) {
        int[][] vis = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                vis[i][j] = -1;
        bfs(vis, kinghtpos, targetpos);
    }

    public static void bfs(int[][] vis, int[] kinghtpos, int[] targetpos) {
        Vector<pair> q = new Vector<>();
        q.add(new pair(kinghtpos[0], kinghtpos[1], 0));
        vis[kinghtpos[0]][kinghtpos[1]] = 1;
        int[] ic = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] jc = { 1, 2, 2, 1, -1, -2, -2, -1 };
        while (!q.isEmpty()) {
            pair p = q.firstElement();
            q.remove(0);
            if (p.x == targetpos[0] && p.y == targetpos[1]) {
                System.out.println(p.ans);
                return;
            }

            for (int i = 0; i < 8; i++) {
                if (check(p.x + ic[i], p.y + jc[i], vis)) {
                    vis[p.x][p.y] = 1;
                    q.add(new pair(p.x + ic[i], p.y + jc[i], p.ans + 1));
                }
            }
        }
    }

    public static boolean check(int i, int j, int[][] vis) {
        int n = vis.length;
        if (i > 0 && i < n && j > 0 && j < n && vis[i][j] == -1) {
            return true;
        } else {
            return false;
        }

    }

}
