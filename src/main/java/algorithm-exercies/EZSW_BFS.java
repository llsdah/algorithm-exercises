package AlgorismStudy1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EZSW_BFS {
	static int N = 10;
	static int n,e;
	static int[][] graph = new int[N][N];
	
	// 최단 경로 
	static int[][] board = new int[N][N];
	static int[][] d = {{-1,0},{1,0},{0,1},{0,-1}};
	
static class Point_BFS{
	int row;
	int col;
	int dis;
	Point_BFS(int r, int c,int d){
		row = r;
		col = c;
		dis = d;
	}
}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		for(int i =0; i< e;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u][v] = graph[u][v]=1;
		}
/*
5 6
0 1 0 2 1 3 1 4 2 4 3 4

*/
		bfs(0);
		n = sc.nextInt();
		for(int i =0; i<n;i++) {
			for(int k =0; k<n;k++) {
				board[i][k] = sc.nextInt();
			}
		}
		// 시작과 끝 점 
		int r = sc.nextInt();
		int c = sc.nextInt();

		int er = sc.nextInt();
		int ec = sc.nextInt();
		
		
		
/*		

5
0 0 0 0 0
0 1 1 1 1
0 0 0 0 0
1 1 1 1 0
0 0 0 0 0
0 1 4 2
	
*/	

		System.out.println( shortest(r,c,er,ec));

	}
	private static int shortest(int sr, int sc, int er, int ec) {
		boolean[][] visit = new boolean[N][N];
		Queue<Point_BFS> q = new LinkedList<>();
		visit[sr][sc] = true;
		q.offer(new Point_BFS(sr, sc, 0));
		while(!q.isEmpty()) {
			Point_BFS cur = q.poll();
			if(cur.row==er && cur.col==ec) return cur.dis;
			
			for(int i=0; i< 4; i++) {
				int nr = cur.row+ d[i][0];
				int nc = cur.col + d[i][1];
				if(nr<0||nc<0|| nr>n-1||nc>n-1) continue;
				if(visit[nr][nc]) continue;
				if(board[nr][nc] == 1) continue;
				visit[nr][nc] = true;
				q.offer(new Point_BFS(nr,nc,cur.dis+1));
			}
		}
		
		return -1;
	}
	private static void bfs(int node) {

		boolean[] visit = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		
		visit[node] = true;
		q.offer(node);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print( cur + " ");
			for( int next =0; next<N;next++) {
				if(!visit[next]&&graph[cur][next]!=0) {
					visit[next] = true;
					q.offer(next);
				}
			}
			
		}
		
	}

}





