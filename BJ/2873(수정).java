import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static String[] ch = {"L","R","U","D"};
	static int[][] arr;
	static int endX;
	static int endY;
	static int sum=0;
	static HashMap<Integer,String> map =new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		int n=sc.nextInt(); // 총 줄의수
		int r=sc.nextInt(); // 총 칸의수
		endX =n;
		endY =r;
		
		arr = new int[n][r];
		for(int i=0; i< n;i++) {
			for(int k=0;k<r;k++) {
				arr[i][k] =sc.nextInt();
			}
		}
		
		boolean[][] visit = new boolean[n][r];
		String str ="";
		bfs(0,0,0,visit,str);
		System.out.println(sum+" "+map.get(sum));
	}
	private static void bfs(int x, int y,int cnt,boolean[][] visit,String str) {

		if(x<0||y<0||x>=endX||y>=endY) return;
		if(visit[x][y]) return;
		if(endX-1==x&&endY-1==y) {
			if(sum<=cnt) {
				sum=cnt;
				map.put(sum, str);
			}
			return;
		}
		visit[x][y] =true;	
		for(int i=0; i<4;i++) {
			int nx =x+dx[i];
			int ny =y+dy[i];
			System.out.println("nx : nx "+nx+" : "+ny);
			bfs(nx,ny,cnt+arr[x][y] , visit, str+ch[i]);
		}
		
	}
}
