import java.util.ArrayList;
import java.util.Scanner;
public class dfsTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int n =obj.nextInt();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
		dfsOfGraph(n,arr );
		

	}
	public static void dfsOfGraph(int n,ArrayList<ArrayList<Integer>> arr)
	{
		int[] vis=new int[n+1];
		ArrayList<Integer> storedfs=new ArrayList<>();
		for(int i=0;i<=n;i++)
		{
			if(vis[i]==0)
			{
				dfs(i,vis,arr,storedfs);
			}
		}
	}
	public static ArrayList<Integer> dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> arr
			,ArrayList<Integer> storedfs)
	{
		vis[node]=1;
		storedfs.add(node);
		for(Integer it:arr.get(node))
		{
			if(vis[it]==0)
			{
				dfs(it,vis,arr,storedfs);
			}
		}
		return storedfs;
	}

}
