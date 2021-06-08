import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class test {
    public static class edge {
        int parent, city, length;

        edge(int x, int y, int z) {
            parent = x;
            city = y;
            length = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        int[] storage = new int[k];
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");
            int x = Integer.parseInt(s2[0]);
            int y = Integer.parseInt(s2[1]);
            int length = Integer.parseInt(s2[2]);
            graph.get(x).add(new edge(x, y, length));
            graph.get(y).add(new edge(y, x, length));
        }
        HashSet<Integer> notallowed = new HashSet<>();
        if (k > 0) {
            String[] s3 = br.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                storage[i] = Integer.parseInt(s3[i]);
                notallowed.add(storage[i]);
            }
        }
        System.out.println(graph.get(0).size());
        System.out.println(graph.get(1).get(0).city);
        System.out.println(graph.get(2).size());
        // solution starts here :-

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (edge x : graph.get(storage[i])) {
                if ((x.city != storage[i]) && (!notallowed.contains(x.city)))
                    ans = Math.min(ans, x.length);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        br.close();
    }
}