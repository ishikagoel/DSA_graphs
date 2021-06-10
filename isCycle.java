
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class isCycle 
{
	static class Node
	{
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
	public static boolean isCycle(int v,ArrayList<ArrayList<Integer>> arr)
	{
		int[] vis=new int[v+1];
		Arrays.fill(vis,0);
		for(int i=1;i<=v;i++)
		{
			if(vis[i]==0)
			{
				if(bfs(arr,vis,i))
					return true;
			}
		}
		return false;
	}
	public static boolean bfs(ArrayList<ArrayList<Integer>> arr,int[] vis,int s)
	{
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(s,-1));
		vis[s]=1;
		while(!q.isEmpty())
		{
			int node=q.peek().node;
			int par=q.peek().parent;
			q.remove();
			for(Integer it:arr.get(node))
			{
				if(vis[it]==0)
				{
					vis[it]=1;
					q.add(new Node(it,node));
				}
				else if(it!=par)
					return true;
			}
		}
		return false;
	}
}
