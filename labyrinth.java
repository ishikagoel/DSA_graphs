import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import jdk.jfr.BooleanFlag;

public class labyrinth {
    static int min = Integer.MAX_VALUE;
    static String ans = "";

    public static class triplet {
        int x, y;
        String path;

        public triplet(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        char[][] arr = new char[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], false);
        }
        int sti = 0, stj = 0;
        for (int i = 0; i < n; i++) {
            char[] s2 = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s2[j];
                if (arr[i][j] == 'A') {
                    sti = i;
                    stj = j;
                }
            }
        }
        String path = "";
        graph(arr, path, sti, stj, vis);
        if (ans == "")
            System.out.println("NO");
        else {
            System.out.println("YES");
            System.out.println(ans.length());
            System.out.println(ans);
        }
    }
    public static void graph(char[][] arr, String path, int i, int j, boolean[][] vis) {
        Queue<triplet> q = new LinkedList<>();
        q.add(new triplet(i, j, path));
        while (!q.isEmpty()) {
            triplet p = q.poll();
            System.out.println(path);
            if (arr[p.x][p.y] == 'B') {
                ans = p.path;
                return;
            }
            vis[p.x][p.y] = true;
            if (check(p.x, p.y + 1, arr, vis)) {
                q.add(new triplet(p.x, p.y + 1, p.path + 'R'));
            }
            if (check(p.x - 1, p.y, arr, vis)) {
                q.add(new triplet(p.x - 1, p.y, p.path + 'U'));
            }
            if (check(p.x + 1, p.y, arr, vis)) {
                q.add(new triplet(p.x + 1, p.y, p.path + 'D'));
            }
            if (check(p.x, p.y - 1, arr, vis)) {
                q.add(new triplet(p.x, p.y - 1, p.path + 'L'));
            }
        }
    }

    public static boolean check(int i, int j, char[][] arr, boolean[][] vis) {
        int n = arr.length;
        int m = arr[0].length;
        if (i >= 0 && i < n && j >= 0 && j < m && vis[i][j] == false && (arr[i][j] == '.' || arr[i][j] == 'B')) {
            return true;
        } else
            return false;
    }
}
