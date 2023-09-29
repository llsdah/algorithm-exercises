package AlgorismStudy1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 재귀
public class EZSW_DFS {

	static final int N = 10; // 최대 노드의 수 
	static int[][] grape = new int[N][N];
	static boolean[] visit = new boolean[N];
	static int n,e;// 노드 수, 간선 수 

	//flood fill
	static int[][] d = { {-1,0},{1,0},{0,-1},{0,1}}; //이동용도 상 하 좌 우 
	static int[][] board = new int[N][N];
	static class Point { //위치 값
		int row, col;
		Point(int r, int c){
			row =r;
			col = c;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		for(int i =0; i<e;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			grape[u][v] =grape[v][u] = 1;
		}
		dfs1(0);
		dfs2(0);
/*		
5
6
0 1 0 2 1 3 1 4 2 4 3 4	
		
*/		
		System.out.println();
		System.out.println();

		n = sc.nextInt();
		for(int i =0; i<n;i++) {
			for(int k =0; k<n;k++) {
				board[i][k] = sc.nextInt();
			}
		}
		int sCol = sc.nextInt();
		int sRow = sc.nextInt();
		int color = sc.nextInt();
		dfs(sRow,sCol,color);
/*		

5
0 0 0 0 0
0 0 0 1 1
0 0 0 1 1
0 1 1 1 1
1 1 0 0 0
1 1 3	
	
*/		
		for(int i =0; i<n;i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		
	}
	private static void dfs(int sRow, int sCol, int color) {
		boolean[][] visit = new boolean[n][n];
		Stack<Point> st = new Stack<>();
		st.push(new Point(sRow,sCol));
		
		System.out.println("이거 시작은 하나?");
		while(!st.empty()) {
			Point curr = st.pop();
			if(visit[curr.row][curr.col]) continue;
			visit[curr.row][curr.col] = true;
			board[curr.row][curr.col] =color;
			for(int i =0; i< 4;i++) { // 동서남북 접근합니다. 
				int nr = curr.row+d[i][0];
				int nc = curr.col+d[i][1];
				if( nr<0|| nr>n-1||nc<0||nc>n-1) continue;
				if(visit[nr][nc])continue;
				if(board[nr][nc]==1) continue; //벽입니다.
				st.push(new Point(nr,nc));
				
			}
		}
		
	}
	// 재귀를 이용한 구현 
	private static void dfs1(int node) {
		visit[node] = true;
		System.out.print(node+" ");
		for(int next = 0; next<N;next++) {
			if(!visit[next]&&grape[node][next]!=0) {
				dfs1(next);
			}
		}
	}
	
	//스택을 통한 구현
	private static void dfs2(int node) {
		boolean[] visit = new boolean[N];
		Stack<Integer> st = new Stack<>();
		st.push(node);
		
		while(!st.empty()) {
			int curr = st.pop();
			if(visit[curr]) continue;
			visit[curr] = true;
			System.out.print(curr+" ");
			
			for(int next = 0; next<N;next++) {
				if(!visit[next]&&grape[curr][next]!=0) {
					st.push(next);
				}
			}
		}
		
	}
}






