import java.util.Arrays;
public class BellmanFord 
{
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		//code
		
		int[][] graph=new int[][]{
			{0,-1,4,0,0},
			{0,0,3,2,2},
			{0,0,0,0,0},
			{0,1,5,0,0},
			{0,0,0,-3,0}
		};
		
		int V=5;
		
		for(int i=0;i<V;i++){
			for(int j=0;j<V;j++){
				if(graph[i][j]==0){
					graph[i][j]=Integer.MAX_VALUE;
				}
			}
		}
		
		bf(graph,0,V);
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
	
	public static void bf(int[][] graph,int src,int V){
		// Integer.max value(Infinity) represents absence of edge
		int dist[]=new int[V];
		for(int i=0;i<V;i++){
			dist[i]=Integer.MAX_VALUE;
		}
		dist[src]=0;
		for(int i=1;i<V;i++){
			for(int u=0;u<V;u++){
				for(int v=0;v<V;v++){
					if(graph[u][v]!=Integer.MAX_VALUE){
						if(dist[v]>dist[u]+graph[u][v]){
							dist[v]=dist[u]+graph[u][v];
						}
					}
				}
			}
		}
		for(int u=0;u<V;u++){
			for(int v=0;v<V;v++){
				if(graph[u][v]!=Integer.MAX_VALUE){
				if(dist[v]>dist[u]+graph[u][v]){
					
					System.out.println("the system contains negative weight cycle");
				}
			}
		}
		}
		for(int i=0;i<V;i++){
			System.out.println("distance of source "+src +" to "+i+" is "+dist[i]);
		}
		
	}
}