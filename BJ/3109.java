package backJun;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int R;
	static int C;
	static boolean[][] map;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		R = sc.nextInt();
		C = sc.nextInt();
		 arr = new int[R][C];
		 map =new boolean[R][C];
		
		//정보 입력 창구 입니다. 
		for(int i =0;i<R;i++) {
			String str = sc.next();
			char[] temp = str.toCharArray();
			for(int k=0;k<temp.length;k++) {
				if(temp[k]=='x') {
					arr[i][k]=1;
					map[i][k]=true;
				}
			}
		}
		for(int i=0;i<R;i++) {
				dfs(i,0);
		}
		System.out.println(cnt);

	}
	static int[] d = {-1,0,1}; // 위 중간 아래 
	static int nr; // 다음것 저장 
	static int nc;
	static int cnt;// 총 갯수 
	private static boolean dfs(int r, int c) {
		
		for(int i=0; i<3;i++) {
			nr = r+d[i];
			nc = c+1;
			if(nr>=0&&nr<R&&map[nr][nc]==false) {
				if(nc==C-1) {
					cnt++;
					return true;
				}
				
				
				map[nr][nc]=true;
				if(dfs(nr,nc)) return true;
				
			}
			
		}
		return false;
	}
}

/*

*/
