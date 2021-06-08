import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.io.InputStreamReader;

public class Bakery {
    static class edge {
        int parent, city, length;

        edge(int p, int c, int l) {
            parent = p;
            city = c;
            length = l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        ArrayList<ArrayList<edge>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().trim().split(" ");
            int u = Integer.parseInt(s1[0]);
            int v = Integer.parseInt(s1[1]);
            int l = Integer.parseInt(s1[2]);
            arr.get(u).add(new edge(u, v, l));
            arr.get(v).add(new edge(v, u, l));
        }
        HashSet<Integer> storage = new HashSet<>();
        int[] ss = new int[k];
        if (k > 0) {
            String[] s2 = br.readLine().trim().split(" ");
            for (int i = 0; i < k; i++) {
                storage.add(Integer.parseInt(s2[i]));
                ss[i] = Integer.parseInt(s2[i]);
            }
        }
        mini(arr, n, storage, ss);
    }

    public static void mini(ArrayList<ArrayList<edge>> arr, int n, HashSet<Integer> storage, int[] ss) {
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        int value = Integer.MAX_VALUE;
        // System.out.println(storage);
        for (int i = 0; i < storage.size(); i++) {
            for (edge it : arr.get(ss[i])) {
                // System.out.println(it.city + " " + it.parent + " " + it.length);
                if ((!storage.contains(it.city))) {
                    // System.out.println("***");
                    value = Math.min(value, it.length);
                }
            }
        }
        System.out.println(value == Integer.MAX_VALUE ? "-1" : value);
    }
}
