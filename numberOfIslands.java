import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class numberOfIslands {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int m = obj.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] ch = obj.next().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = ch[j];
            }
        }
        islands(grid);
    }

    public static void islands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(vis[i], false);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    dfs(grid, vis, i, j, ans);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void dfs(char[][] grid, boolean[][] vis, int i, int j, int ans) {
        vis[i][j] = true;
        if (check(i, j + 1, grid) && grid[i][j + 1] == '1') {
            if (vis[i][j + 1] != true)
                dfs(grid, vis, i, j + 1, ans);
        }
        if (check(i, j - 1, grid) && grid[i][j - 1] == '1') {
            if (vis[i][j - 1] != true)
                dfs(grid, vis, i, j - 1, ans);
        }
        if (check(i + 1, j, grid) && grid[i + 1][j] == '1') {
            if (vis[i + 1][j] != true)
                dfs(grid, vis, i + 1, j, ans);
        }
        if (check(i - 1, j, grid) && grid[i - 1][j] == '1') {
            if (vis[i - 1][j] != true)
                dfs(grid, vis, i - 1, j, ans);
        }
        return;

    }

    public static boolean check(int i, int j, char[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            return true;
        } else
            return false;
    }
}
