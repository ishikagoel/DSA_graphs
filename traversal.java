package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class traversal {

	public static void main(String[] args) 
	{
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		ArrayList<ArrayList<Integer>> arr=new ArrayList<>();//adjacencylist
		for(int i=0;i<n;i++)
		{
			arr.add(new ArrayList<>());
		}
		int u=obj.nextInt();
		int v=obj.nextInt();
		arr.get(u).add(v);
		arr.get(v).add(u);
		traverse( n,arr);



	}
	public static void traverse(int n,ArrayList<ArrayList<Integer>> arr)
	{
		ArrayList<Integer> bfs=new ArrayList<>();
		int[] vis=new int[n+1];
		for(int i=0;i<n;i++)
		{
			if(vis[i]==0)
			{
				vis[i]=1;
				Queue<Integer> q=new LinkedList<>();
				q.add(i);
				
				while(!q.isEmpty())
				{
					Integer node=q.poll();
					q.add(node);
					for(Integer it:arr.get(node))
					{
						if(vis[it]==0)
						{
							q.add(it);
							vis[it]=1;
						}
					}
				}
				
			}
		}
		
	}


}
