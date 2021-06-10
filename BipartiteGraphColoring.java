//package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class BipartiteGraphColoring {

	static class Node{
		int node,parent;
		Node(int node,int parent)
		{
			this.node=node;
			this.parent=parent;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	static boolean isBipartite(int n,ArrayList<ArrayList<Integer>> arr)
	{
		int[] c=new int[n];
		Arrays.fill(c,-1);
		for(int i=0;i<n;i++)
		{
			if(c[i]==-1)
			{
				c[i]=0;
				if(bfs(c,i,arr))
					return true;
			}
		}
		return false;
	}
	//bipartite graph coloring using bfs
	static boolean bfs(int[] c,int s,ArrayList<ArrayList<Integer>> arr)
	{
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		c[s]=0;
		while(!q.isEmpty())
		{
			int node=q.peek();
			q.remove();
			for(Integer it:arr.get(node))
			{
				if(c[it]==-1)
				{
					q.add(it);
					if(c[node]==0)
						c[it]=1;
					else
						c[it]=0;
				}
				else if(c[it]==c[node])
				{
					return false;
				}
			}
		}
		return true;

	}
	//bipartite graph coloring using dfs
	public static boolean dfs(int[] c,int s,ArrayList<ArrayList<Integer>> arr)
	{
		
		for(Integer it:arr.get(s))
		{
			if(c[it]==-1)
			{
				if(c[s]==0)
					c[it]=1;
				else
					c[it]=0;
				if(!dfs(c,it,arr))return false;
			}
			 if(c[it]==c[s])
				return false;
			
		}
		return true;
	}

}
