import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 출구게임
	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// 한 팀은 모든 팀과 경기 무승 부 없다.
		int n = sc.nextInt();// 참가 팀수 
		// 이기면 1 지면 0 즉 
		// 한팀이 1이면 다른팀은 0 해당 점수의 배열의 유요한지 . 즉 대칭인지?
		int[] point = new int[n];
		for(int i=0;i<n;i++) {
			point[n]= sc.nextInt();
		}
		Arrays.sort(point);// 순 방향 정렬 
		boolean flag = true;
		int[] time = new int[n];// 
		for(int i =n-1;i>=0;i--) { // 큰것 부터 정렬
			int win = point[i];
			int lose = n-win;
			if( n-time[i]<win) break; // 가질 수 있는 최대 점수 보다 승이 크면 종료
			
			for(int k=0;k<i;k++) {//지금 순서 직전까지 돌명서 lose를 없애야댐 
				
			}
			
			
		}
		
		
	}
}
