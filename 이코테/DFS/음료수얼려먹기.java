package 이코테.DFS_BFS;

public class 음료수얼려먹기 {
	
	
	static boolean[][] visit;
	public static void main(String[] args) {

		
		int[][] arr = {
				{0,0,1,1,0},
				{0,0,0,1,1},
				{1,1,1,1,1},
				{0,0,0,0,0},
		};
		
		visit = new boolean[arr.length][arr[0].length];
		int cnt =0;
		for(int c=0; c<arr.length;c++) {
			
			for(int r =0; r<arr[c].length;r++) {
				
				
				if(arr[c][r]==0&&visit[c][r]==false) {
					dfs(arr,c,r);
					cnt++;
					
				}
			}
			
		}
		System.out.println(cnt);
		
	}
	
	private static void dfs(int[][] arr, int col, int row) {
		
		if(col<0||row<0||col >= arr.length|| row>=arr[0].length) {
			return;
		}
		if(arr[col][row]==1||visit[col][row]==true) {
			return;
		}
		visit[col][row] =true;
		dfs(arr,col-1,row);
		dfs(arr,col+1,row);
		dfs(arr,col,row-1);
		dfs(arr,col,row+1);
		
		
	}
	
}
