//package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {

	public static void main(String[] args) {

	}

	public static int[] topoSort(int n, ArrayList<ArrayList<Integer>> arr) {
		int[] vis = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0)
				dfs(vis, arr, i, st);
		}
		int[] topo = new int[n];
		int id = 0;
		while (!st.isEmpty()) {
			topo[id++] = st.pop();
		}
		return topo;
	}

	public static void dfs(int[] vis, ArrayList<ArrayList<Integer>> arr, int s, Stack<Integer> st) {
		vis[s] = 1;
		for (Integer it : arr.get(s)) {
			if (vis[it] == 0) {
				dfs(vis, arr, it, st);
			}
		}
		st.add(s);
	}

}
