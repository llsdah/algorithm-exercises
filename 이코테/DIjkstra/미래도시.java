package 이코테.다익스트라;

import java.util.Arrays;

public class 미래도시 {

	
	static final int INF =(int) 1e9;// 무한의 값을 의미
	static int n; // 노드의 갯수
	static int m; // 간성의 갯수 
	static public int[][] graph = new int[101][101];// 2차원 배열 그래프
	public static void main(String[] args) {
// 모든 도시간의 최소값을 구해라 하하핳 플로이드 워셜 
		n =5;
		
		
		for(int i =0; i<101;i++) {
			Arrays.fill(graph[i],INF);
		}
		
		for(int i =1; i<=n;i++) {
			for(int k =1; k<=n;k++) {
				if(i==k) graph[i][k]=0;
			}
		}
		
		graph[1][2] =1;
		graph[2][1] =1;
		
		graph[1][3]=1;
		graph[3][1]=1;
		
		graph[1][4]= 1;
		graph[4][1]= 1;
	
		graph[2][4]=1;
		graph[4][2]=1;
	
		graph[3][4]=1;
		graph[4][3]=1;
	
		graph[3][5]=1;
		graph[5][3]=1;
	
		graph[4][5]=1;
		graph[5][4]=1;
		
		// 점화식 수행합니다. 
		for(int i =1; i<=n;i++) {
			
			for(int a =1; a<=n;a++) {
				for(int b=1;b<=n;b++) {
					graph[a][b] =Math.min(graph[a][b], 
							graph[a][i]+graph[i][b]);
				}
			}
			
		}
		
		int x  =4;
		int k=5;
		
		
		System.out.println( (graph[1][k]+graph[k][x])+" 최단거리");
	
	
	}
	
	

}
