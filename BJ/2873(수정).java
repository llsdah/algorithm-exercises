package backJun;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[][] arr;
	static int minR;
	static int minC;
	static int R;
	static int C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));

		R=sc.nextInt(); // 총 줄의수
		C=sc.nextInt(); // 총 칸의수		
		arr = new int[R][C];
		int min = (int)1e9;
		// 값 입력 
		// 체스판 처럼 흰칸 검은칸이 반복되어 있는 구조 생각
		// 왼쪽 위는 흰칸! (시작점)
		for(int i=0; i< R;i++) {
			for(int k=0;k<C;k++) {
				arr[i][k] =sc.nextInt();
				// 검은색 칸중 가장 작은 것 (더해서 홀 수 인것)
				// 그림을 그려보면 흰칸에 작은 수가 있는 경우와 검은칸에 작은 수가 있는경우가 다름
				if( (i+k)%2==1&&arr[i][k]<min) { 
					min = arr[i][k];
					minR=i;
					minC=k;
				}
			}
		}
		
		String ans ="";
		if(R%2==1||C%2==1) ans = odd();
		else ans = even();
		
		System.out.println(ans);
		
	}
	// 짝수 !!
	private static String even() {
		StringBuilder sb1 = new StringBuilder(); //최소 지점까지용
		StringBuilder sb2 = new StringBuilder();// 그 이후 용도
		
		//시작에서
		int sr =0;
		int sc =0;
		
		// 끝에서
		int er = R-1;
		int ec = C-1;
		
		// er과 sr 사이에 행 1개만 남을때까지 
		while(er-sr>1) { // ㄹ 기준 으로 최소 검은 지점찾아보기
			// 시작 기준
			if(sr/2 < minR/2) {
				for(int i=0; i<C-1;i++) {
					sb1.append("R");
				}
				sb1.append("D");
				for(int i=0;i<C-1;i++) {
					sb1.append("L");
				}
				sb1.append("D");
				sr+=2;// 두칸 돌았으니까 
			}
			
			// 끝 기준
			if(er/2 < minR/2) {
				for(int i=0; i<C-1;i++) {
					sb2.append("R");
				}
				sb2.append("D");
				for(int i=0;i<C-1;i++) {
					sb2.append("L");
				}
				sb2.append("D");
				er-=2;// 두칸 돌았으니까 
			}
			
		}
		
		//ec 와 sc 사이에 열 1개일때까지
		while(ec-sc>1) {
			// sc기준으로 최소값 검은 검 없으면 세로 ㄹ 모양 이동
			if(sc/2< minC/2) {
				sb1.append("DRUR");
				sc+=2;
			}
			
			//ec 기준 현재 열과 다음열에 최솺 검은 지점이 없다면 ㄹ 대칭
			if(ec/2 >minC/2) {
				sb2.append("DRUR");
				ec-=2;
			}
			
		}
		// 마지막 검은 점 있는 장소 도착 
		if( sc==minC) sb1.append("RD");
		else sb1.append("DR");
		String str1 = sb1.toString();
		String str2 = sb2.reverse().toString();
		
		return str1+str2;
	}
	// 홀 수가 하나라고 있는 경우 메로리 제한피하기 위한 공식 도출 입력 
	private static String odd() {
		StringBuilder sb= new StringBuilder();
		
		if(R%2==1) { // 행이 홀수? 면 ㄹ 모양 방문 그림 그려보기
			for(int i=0; i<R;i++) {
				
				for(int k=0;k<C-1;k++) {
					if(i%2==0) sb.append("R");
					else sb.append("L");
				}
				
				if(i !=R-1) sb.append("D");
			}
		}else if(C%2==1) { //열이 홀수 회전한 ㄹ 모양 방문
			for(int i=0;i<C;i++) {
				for(int k=0;k<R-1;k++) {
					if(i%2==0) sb.append("D");
					else sb.append("U");
				}
				if(i !=C-1) sb.append("R");
			}
			
		}
		
		return sb.toString();
	}
}

/*

*/

/* 메모리 초관... 
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
		int min =(int)1e9;
		for(int i=0; i< n;i++) {
			for(int k=0;k<r;k++) {
				arr[i][k] =sc.nextInt();
				min = Math.min(min, arr[i][k]);
			}
		}
		// 한개라도 홀수면 그냥 다 방문
		boolean[][] visit = new boolean[n][r];
		//둘다 짝수면?
		if(n%2==0&&r%2==0) {
			loof : for(int i=0; i< n;i++) {
				for(int k=0;k<r;k++) {
					if(min==arr[i][k]) {
						visit[i][k]=true;
						break loof;
					}
				}
			}
		}
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

*/
